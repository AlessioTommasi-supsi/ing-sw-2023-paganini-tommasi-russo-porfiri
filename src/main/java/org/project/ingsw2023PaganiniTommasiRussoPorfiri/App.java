package org.project.ingsw2023PaganiniTommasiRussoPorfiri;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;

import java.rmi.RemoteException;


public class App 
{
    public static void main( String[] args ) throws RemoteException {
        Server server = new ServerImpl();

        ClientImpl client = new ClientImpl(server);
        client.run();
    }
}
