package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed.ClientImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppClientRMI
{
    public static void main( String[] args ) throws RemoteException, NotBoundException {
        try {
            Registry registry = LocateRegistry.getRegistry();
            AppServer server = (AppServer) registry.lookup("server");

            ClientImpl client = new ClientImpl(server.connect());
            client.run();
        }catch (Exception e){
            System.out.println("errore nel main");
            e.printStackTrace();
        }


    }
}
