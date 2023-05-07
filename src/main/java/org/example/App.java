package org.example;
import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RemoteException {
        Server server = new ServerImpl();

        ClientImpl client = new ClientImpl(server);
        client.run();
    }
}
