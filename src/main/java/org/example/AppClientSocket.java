package org.example;
import org.example.distributed.*;
import org.example.distributed.socket.middleware.*;

import java.rmi.RemoteException;

public class AppClientSocket
{
    public static void main( String[] args ) throws RemoteException {
        ServerStub serverStub = new ServerStub("localhost", 1234);
        ClientImpl client = new ClientImpl(serverStub);
        new Thread() { //thread che si occupa di gestire i messaggi di rete in arrivo
            @Override
            public void run() {
                while(true) {
                    try {
                        serverStub.receive(client);
                    } catch (RemoteException e) {
                        System.err.println("Cannot receive from server. Stopping...");
                        try {
                            serverStub.close();
                        } catch (RemoteException ex) {
                            System.err.println("Cannot close connection with server. Halting...");
                        }
                        System.exit(1);
                    }
                }
            }
        }.start();

        client.run();//thread che gestisce interfaccia grafica!
    }
}
