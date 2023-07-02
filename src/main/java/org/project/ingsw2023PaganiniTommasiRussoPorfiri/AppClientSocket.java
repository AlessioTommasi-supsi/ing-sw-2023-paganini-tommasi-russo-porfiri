package org.project.ingsw2023PaganiniTommasiRussoPorfiri;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.socket.middleware.*;

import java.rmi.RemoteException;

public class AppClientSocket
{
    public static void main( String[] args ) throws RemoteException {
        String ip = "127.0.0.1";

        if(args.length == 1) {
            ip = args[0].toString();
        }

        ServerStub serverStub = new ServerStub(ip, 1234);
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
