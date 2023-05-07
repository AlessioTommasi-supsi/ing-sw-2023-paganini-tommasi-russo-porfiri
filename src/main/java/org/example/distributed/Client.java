package org.example.distributed;
import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
    /**
     * Notify the client of a model change
     * @param o     The resulting model view
     * @param arg   The causing event
     */
    void update(TurnView o, Choice arg) throws RemoteException;
}
