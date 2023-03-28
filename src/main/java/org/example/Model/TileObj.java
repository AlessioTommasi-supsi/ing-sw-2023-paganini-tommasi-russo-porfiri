package org.example.Model;

import java.util.*;

//CLASSE SCRITTA COME BOZZA SOLO PER POTER SCRIVERE TileObjBag!!
public class TileObj {
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
}
