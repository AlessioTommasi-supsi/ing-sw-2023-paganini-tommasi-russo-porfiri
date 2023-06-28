package org.project.ingsw2023PaganiniTommasiRussoPorfiri;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppClientRMI
{
    public static void main( String[] args ) throws RemoteException, NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            AppServer server = (AppServer) registry.lookup("Server");

            ClientImpl client = new ClientImpl(server.connect());
            client.run();
        }catch (Exception e){
            System.out.println("Error in main method");
            e.printStackTrace();
        }


    }
}
