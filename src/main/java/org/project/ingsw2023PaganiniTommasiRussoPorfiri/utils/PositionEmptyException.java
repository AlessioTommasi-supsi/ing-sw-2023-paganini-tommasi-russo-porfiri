package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import java.io.Serializable;

public class PositionEmptyException extends Exception implements Serializable {
    public PositionEmptyException(){
        super("This position is empty, does not contain any tile!");
    }
}