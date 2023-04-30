package org.example.Model;

public class TilesAreNotRemovableException extends Exception {
    public TilesAreNotRemovableException(){
        super("These tiles are not removable");
    }
}
