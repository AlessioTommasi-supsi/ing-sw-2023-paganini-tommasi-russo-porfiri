package org.example.util;

import java.io.Serializable;

public class IllegalSizeOfTilesException extends Exception implements Serializable {
    public IllegalSizeOfTilesException(){
        super("libreria piena, in qualsiasi colonna non ci possono stare quel numero di tiles");
    }
}
