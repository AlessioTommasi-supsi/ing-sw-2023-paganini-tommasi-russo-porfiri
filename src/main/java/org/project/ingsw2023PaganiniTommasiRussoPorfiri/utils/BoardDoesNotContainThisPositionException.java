package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import java.io.Serializable;

public class BoardDoesNotContainThisPositionException extends Exception implements Serializable {

    public BoardDoesNotContainThisPositionException(int x, int y) {
        super("You tried to remove a tile from position " + x + " ," + y + " .This Board does not contain this position!");
    }

}
