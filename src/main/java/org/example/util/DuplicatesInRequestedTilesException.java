package org.example.util;

import java.io.Serializable;

public class  DuplicatesInRequestedTilesException extends Exception implements Serializable {

    public DuplicatesInRequestedTilesException() {
        super("Found one or more duplicates in the positions you entered! Please enter different coordinates for each tile to be removed!");
    }
}
