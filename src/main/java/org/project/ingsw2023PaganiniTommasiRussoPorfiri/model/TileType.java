package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

public enum TileType {
    BOOK("Libri1."),
    CAT("Gatti1."),
    FRAME("Libri1."),
    GAMES("Giochi1."),
    PLANT("Piante1."),
    TROPHY("Trofei1.");

    private String name;

    TileType(String book) {
        this.name = book;
    }

    @Override
    public String toString() {
        return name().substring(0, 1);
    }

}