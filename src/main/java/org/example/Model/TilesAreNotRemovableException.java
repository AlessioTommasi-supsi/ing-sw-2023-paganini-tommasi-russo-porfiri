package org.example.Model;

import java.io.Serializable;

public class TilesAreNotRemovableException extends Exception implements Serializable {
    public TilesAreNotRemovableException(){
        super("These tiles are not removable");
    }
}
