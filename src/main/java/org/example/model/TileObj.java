package org.example.model;


import java.io.Serializable;


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
        return "TileObj{" +
                "type=" + type.toString() +
                ", variant=" + variant.toString() +
                '}';
    }
}

