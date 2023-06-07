package org.project.utils;

import java.io.Serializable;

public class PositionAlreadyOccupiedException extends Exception implements Serializable {
    public PositionAlreadyOccupiedException(){
        super("This position is already occupied by another tile!");
    }
}
