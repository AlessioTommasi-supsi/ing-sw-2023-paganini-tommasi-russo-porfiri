package org.example.Model;

import java.util.*;

public class TileObjBag {

    private ArrayList<TileObj> tiles;

    public TileObjBag(){
        this.tiles = new ArrayList<>(132);

        //6 types of Item tiles, 132 in total, 22 of each type.
        for (int i=0; i<=21; i++){
            tiles.add(i, new TileObj(TileType.BOOK));
        }
        for (int i=22; i<=43; i++){
            tiles.add(i, new TileObj(TileType.CAT));
        }
        for (int i=44; i<=65; i++){
            tiles.add(i, new TileObj(TileType.FRAME));
        }
        for (int i=66; i<=87; i++){
            tiles.add(i, new TileObj(TileType.GAMES));
        }
        for (int i=88; i<=109; i++){
            tiles.add(i, new TileObj(TileType.PLANT));
        }
        for (int i=110; i<=131; i++){
            tiles.add(i, new TileObj(TileType.TROPHY));
        }
    }

    public void shuffle(){
        Collections.shuffle(tiles);
    }

    public TileObj extractFromBag(){
        this.shuffle();
        TileObj tempTile = new TileObj(tiles.get(0));
        tiles.remove(0);
        return tempTile;
    }

}
