package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

public enum TileType {
    BOOK,
    CAT,
    FRAME,
    GAMES,
    PLANT,
    TROPHY;


    @Override
    public String toString() {
        return name().substring(0, 1);
    }

}