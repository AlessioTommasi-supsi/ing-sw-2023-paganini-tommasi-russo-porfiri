package org.project.util;

import java.io.Serializable;

public class WrongNumberOfTilesException extends Exception implements Serializable {

    public WrongNumberOfTilesException(int count) {
        super("You tried to remove " + count + " tiles. You can only remove a number of tiles >0 and <4");
    }

}
