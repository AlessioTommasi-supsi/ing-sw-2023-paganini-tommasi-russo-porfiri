package org.example.Model;

public class PositionEmptyException extends Exception {
    public PositionEmptyException(){
        super("This position is empty, does not contain any tile");
    }
}