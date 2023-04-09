package org.example.Model;

public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(){
        super("This position is already occupied by another tile");
    }
}
