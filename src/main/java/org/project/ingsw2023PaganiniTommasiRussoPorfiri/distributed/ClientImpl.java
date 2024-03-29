package org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.ViewMyShelfie;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
// GIITTTT PLSWORCK 2
public class ClientImpl extends UnicastRemoteObject implements Client, Runnable {

    ViewMyShelfie view = new ViewMyShelfie();
    //GUI PART
    //LoginGUI loginGui = new LoginGUI(view);
    //GraphicalUI gui = new GraphicalUI();

    //END GUI

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
