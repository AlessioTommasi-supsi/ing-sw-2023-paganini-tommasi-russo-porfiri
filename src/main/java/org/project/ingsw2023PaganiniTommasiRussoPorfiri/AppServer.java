package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppServer extends Remote {
    Server connect() throws RemoteException;
}
