package org.project.model;

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