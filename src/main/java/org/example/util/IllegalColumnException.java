package org.example.util;

import java.io.Serializable;

public class IllegalColumnException extends Exception implements Serializable {
    public IllegalColumnException(){
        super("Wrong column!");
    }
}
