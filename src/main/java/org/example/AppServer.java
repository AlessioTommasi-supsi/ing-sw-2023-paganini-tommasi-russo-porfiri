package org.example;

import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppServer extends Remote {
    Server connect() throws RemoteException;
}
