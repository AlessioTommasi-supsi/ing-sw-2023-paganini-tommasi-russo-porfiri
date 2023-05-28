package org.example.Model;


import java.io.Serializable;
import java.util.*;


public class TileObj implements Serializable {
    private TileType type;
    private TileVariant variant;


    public TileObj(TileType chosenType, TileVariant chosenVariant) {
        this.type = chosenType;
        this.variant = chosenVariant;
    }

    public TileObj(TileObj tile) {
        this.type = tile.getType();
        this.variant = tile.getVariant();
    }

    public TileType getType() {
        return type;
    }

    public TileVariant getVariant() {
        return variant;
    }

    @Override
    public String toString() {
        return "" +
                " " + type.toString() +
                " " + variant.toString();
    }
}

