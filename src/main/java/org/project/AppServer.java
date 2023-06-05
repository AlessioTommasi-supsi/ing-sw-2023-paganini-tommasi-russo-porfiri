package org.project;

import org.project.distributed.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppServer extends Remote {
    Server connect() throws RemoteException;
}
