package org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.controller.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements Server {

    public Turn model= null;
    private Controller controller= null;

    public ServerImpl() throws RemoteException {
        super();
    }
    public ServerImpl(Turn model) throws RemoteException {
        super();
        this.model = model;
    }

    public ServerImpl(int port) throws RemoteException {
        super(port);
    }

    public ServerImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void register(Client client) {
        //più controller ma i controller hanno lo stesso model!
        if (this.model == null) {
            System.err.println("New model");
            this.model = new Turn();
        }
        this.model.addObserver((o, arg) -> {
            try {
                client.update(new TurnView(model), arg);
            } catch (RemoteException e) {
                System.err.println("Unable to update the client: " + e.getMessage() + ". Skipping the update...");

            }
        });
        //if (this.controller == null) {
            this.controller = new Controller(model, client);
        //}
    }


    @Override
    public void update(Client client, Choice arg) {
        this.controller.update(client, arg);
    }
}
