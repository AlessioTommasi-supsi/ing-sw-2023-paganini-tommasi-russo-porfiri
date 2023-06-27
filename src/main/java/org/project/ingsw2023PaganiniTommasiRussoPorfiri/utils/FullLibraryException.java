package org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils;

import java.io.Serializable;

public class FullLibraryException extends Exception implements Serializable {
    public FullLibraryException() {
        super("With the tiles inserted, the library fills up!");
    }
}
