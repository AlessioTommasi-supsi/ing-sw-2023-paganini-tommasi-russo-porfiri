package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Turn;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.view.*;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client, Runnable {

    //TextualUI view = new TextualUI();
    View_my_shelfie view = new View_my_shelfie();

    public ClientImpl(Server server) throws RemoteException {
        super();
        initialize(server);
    }

    public ClientImpl(Server server, int port) throws RemoteException {
        super(port);
        initialize(server);
    }

    public ClientImpl(Server server, int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
        initialize(server);
    }

    private void initialize(Server server) throws RemoteException {
        server.register(this);
        //ERRORE E'QUI!!! COME ARG VIENE VISTO COME UNA CHOICE_MY_SHELLFIE E NON COME CHOICHE!!
        view.addObserver((o, arg) -> {
            try {
                server.update(this, new Choice(arg,null));

            } catch (RemoteException e) {
                System.err.println("Unable to update the server: " + e.getMessage() + ". Skipping the update...");
            }
        });
    }

    @Override
    public void update(TurnView o, Turn.Event arg) {
        view.update(o, arg);
    }

    @Override
    public void run() {
        view.run();
    }
}
