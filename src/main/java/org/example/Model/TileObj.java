package org.example.Model;

import java.util.*;

//CLASSE SCRITTA COME BOZZA SOLO PER POTER SCRIVERE TileObjBag!!
public class TileObj {
    private TileType type;

    public TileObj(TileType chosenType) {
        this.type = chosenType;
    }

    public TileObj(TileObj tile){
        this.type = tile.getType();
    }

    public TileType getType() {
        return type;
    }
}
