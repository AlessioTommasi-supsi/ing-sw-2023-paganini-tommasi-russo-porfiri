package org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.socket.middleware;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;


/*quello che serve al SERVER per funzionare*/ 
public class ClientSkeleton implements Client {

    private final ObjectOutputStream oos;
    private final ObjectInputStream ois;

    /*gli stream vanno aperti 1 volta sola per client e una volta sola per server!! (per ciascun socket)
    i socket stanno nelle view!!
    */ 
    public ClientSkeleton(Socket socket) throws RemoteException {
        try {
            this.oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RemoteException("Cannot create output stream", e);
        }
        try {
            this.ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            throw new RemoteException("Cannot create input stream", e);
        }
    }

    @Override
    public void update(TurnView o, Choice arg) throws RemoteException {
        try {
            oos.writeObject(o);

            this.oos.flush();
            this.oos.reset();

        } catch (IOException e) {
            throw new RemoteException("Cannot send model view", e);
        }
        try {
            oos.writeObject(arg);

            this.oos.flush();
            this.oos.reset();
        } catch (IOException e) {
            throw new RemoteException("Cannot send event", e);
        }

    }

    public void receive(Server server) throws RemoteException {
        Choice c;
        try {
            c = (Choice) ois.readObject();
        } catch (IOException e) {
            throw new RemoteException("Cannot receive choice from client", e);
        } catch (ClassNotFoundException e) {
            throw new RemoteException("Cannot deserialize choice from client", e);
        }
        server.update(this, c);
    }
}
