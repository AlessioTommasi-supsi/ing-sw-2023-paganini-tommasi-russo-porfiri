package org.example;

import org.example.distributed.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppServer extends Remote {
    Server connect() throws RemoteException;
}
