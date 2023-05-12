package org.example.util;

import java.io.Serializable;

public class FullLibraryException extends Exception implements Serializable {
    public FullLibraryException() {
        super("con le tiles immesse la libreria  diventa piena!");
    }
}
