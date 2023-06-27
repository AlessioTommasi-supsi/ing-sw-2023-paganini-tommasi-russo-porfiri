package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import java.io.Serializable;

public class IllegalColumnException extends Exception implements Serializable {
    public IllegalColumnException(){
        super("Wrong column!");
    }
}
