package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Choice;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TurnView;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.view.View_my_shelfie;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
// GIITTTT PLSWORCK 2
public class ClientImpl extends UnicastRemoteObject implements Client, Runnable {

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
                server.update(this, arg);

            } catch (RemoteException e) {
                System.err.println("Unable to update the server: " + e.getMessage() + ". Skipping the update...");
            }
        });
    }

    @Override
    public void update(TurnView o, Choice arg) {
        view.update(o, arg);
    }

    @Override
    public void run() {
        view.run();
    }
}
