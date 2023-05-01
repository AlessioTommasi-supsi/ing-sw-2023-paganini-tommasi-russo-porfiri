package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

//CLASSE SCRITTA COME BOZZA SOLO PER POTER SCRIVERE TileObjBag!!
public class TileObj implements Serializable {
    private TileType type;
    private TileVariant variant;


    public TileObj(TileType chosenType, TileVariant chosenVariant) {
        this.type = chosenType;
        this.variant = chosenVariant;
    }

    public TileObj(TileType tile) {

        //this.type = tile.getType();
        //this.variant = tile.getVariant();
    }

    public TileType getType() {
        return type;
    }

    public TileVariant getVariant() {
        return variant;
    }
}
