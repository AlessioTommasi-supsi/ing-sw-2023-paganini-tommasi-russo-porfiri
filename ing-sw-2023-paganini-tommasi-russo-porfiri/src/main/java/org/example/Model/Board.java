package org.example.Model;

import java.util.*;

/**
 * 
 */
public class Board {
    private TilePosition placement[];
    private TileObjBag bag;
    private CommonDeck commonDeck;


    //sara il gioco a creare i placement giusti in base a quante persone ho!!
    public Board(TilePosition[] placement, TileObjBag bag, CommonDeck commonDeck) {
        this.placement = placement;
        this.bag = bag;
        this.commonDeck = commonDeck;
    }

    public TilePosition[] getPlacement() {
        return placement;
    }

    public void setPlacement(TilePosition[] placement) {
        this.placement = placement;
    }

    public TileObjBag getBag() {
        return bag;
    }

    public void setBag(TileObjBag bag) {
        this.bag = bag;
    }

    public CommonDeck getCommonDeck() {
        return commonDeck;
    }

    public void setCommonDeck(CommonDeck commonDeck) {
        this.commonDeck = commonDeck;
    }




    public Set<TilePosition> displayBoard() {
        // TODO implement here
        return null;
    }


    public void deleteTiles(Set<TilePosition> p) {
        // TODO implement here
    }

    public void setTile(TileObj t, int x, int y) {
        // TODO implement here
    }

}