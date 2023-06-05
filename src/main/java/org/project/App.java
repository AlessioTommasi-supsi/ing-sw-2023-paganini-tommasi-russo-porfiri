package org.project;
import org.project.distributed.*;

import java.rmi.RemoteException;


public class App 
{
    public static void main( String[] args ) throws RemoteException {
        Server server = new ServerImpl();

        ClientImpl client = new ClientImpl(server);
        client.run();
    }
}
