package org.project.util;

import java.io.Serializable;

public class IllegalSizeOfTilesException extends Exception implements Serializable {
    public IllegalSizeOfTilesException(int n){
        super("library full, that number of tiles (" + n + ") cannot fit in any column");
    }
}
