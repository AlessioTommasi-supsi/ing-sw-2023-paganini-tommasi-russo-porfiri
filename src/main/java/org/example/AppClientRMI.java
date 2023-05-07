package org.example;
import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

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
