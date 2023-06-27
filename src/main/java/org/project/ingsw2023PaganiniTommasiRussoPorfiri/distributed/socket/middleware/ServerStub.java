package org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.socket.middleware;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
/*quello che serve al CLIENT per funzionare*/ 
public class ServerStub implements Server {

    String ip;
    int port;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    private Socket socket;

    public ServerStub(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void register(Client client) throws RemoteException {
        try {//RICORDA PRIMA BISOGNA SEMPRE APRIRE OUTPUT STREAM DI INPUTSTREAM PER EVITARE DEADLOCK!
            this.socket = new Socket(ip, port);
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
        } catch (IOException e) { /*GENERALIZZO PER RITORNARE LA STESSA ECCEZIONE CHE RITORNEREBBE RMI!!*/
            throw new RemoteException("Unable to connect to the server", e);
        }
    }

    @Override
    public void update(Client client, Choice arg) throws RemoteException {
        try {
            oos.writeObject(arg);//scrivo al server
        } catch (IOException e) {
            throw new RemoteException("Cannot send event", e);
        }
    }

    /*metodo che ci serve per definire cosa fare quando arriva una nuova TurnView!*/
    public void receive(Client client) throws RemoteException {
        TurnView o;
        try {//leggo da input stream la turnView
            o = (TurnView) ois.readObject();//se stream vuoto rimane in attesa!!
        } catch (IOException e) {
            throw new RemoteException("Cannot receive model view from client", e);
        } catch (ClassNotFoundException e) {
            throw new RemoteException("Cannot deserialize model view from client", e);
        }

        Choice arg;
        try {//quando voglio ricevere argomenti
            arg = (Choice) ois.readObject();
        } catch (IOException e) {
            throw new RemoteException("Cannot receive event from client", e);
        } catch (ClassNotFoundException e) {
            throw new RemoteException("Cannot deserialize event from client", e);
        }

        client.update(o, arg);
    }

    public void close() throws RemoteException {
        try {
            socket.close();
        } catch (IOException e) {
            throw new RemoteException("Cannot close socket", e);
        }
    }
}
