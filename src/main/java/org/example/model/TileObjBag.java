package org.example.model;


import java.io.Serializable;
import java.util.*;

public class TileObjBag implements Serializable {
    private ArrayList<TileObj> tiles;

    public TileObjBag(){
        this.tiles = new ArrayList<TileObj>();

        //6 types of Item tiles, 132 in total, 22 of each type.
        for( TileType type : TileType.values() ){

            for(int i=0; i<7; i++){
                tiles.add(new TileObj(type, TileVariant.VARIANT_ONE));
            }
            for(int i=0; i<7; i++){
                tiles.add(new TileObj(type, TileVariant.VARIANT_TWO));
            }
            for(int i=0; i<8; i++){
                tiles.add(new TileObj(type, TileVariant.VARIANT_THREE));
            }

        }
    }

    public TileObjBag(TileObjBag bag){
        for (TileObj t : bag.getTiles()) {
            this.tiles.add(new TileObj(t));
        }
    }

    public ArrayList<TileObj> getTiles() {
        ArrayList<TileObj> tempTiles = new ArrayList<TileObj>(this.tiles);
        return tempTiles;
    }

    public int BagSize(){
        return tiles.size();
    }

    public void shuffleT(){
        Collections.shuffle(tiles);
    }

    public TileObj extractFromBag(){
        this.shuffleT();
        TileObj tempTile = new TileObj(tiles.get(0));
        tiles.remove(0);
        return tempTile;
    }

}
