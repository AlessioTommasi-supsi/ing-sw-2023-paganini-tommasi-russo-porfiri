package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import java.io.Serializable;

public class IllegalSizeOfTilesException extends Exception implements Serializable {
    public IllegalSizeOfTilesException(int n){
        super("library full, that number of tiles (" + n + ") cannot fit in any column");
    }
}
