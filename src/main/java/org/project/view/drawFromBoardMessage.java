package org.project.view;

import org.project.model.TilePositionBoard;

import java.io.Serializable;
import java.util.ArrayList;

public class drawFromBoardMessage implements Serializable {
    public int columnOfShelves;

    public ArrayList<TilePositionBoard> tilesToRemove;

    public int currentGameId;

    public int ordine[];


    public drawFromBoardMessage(ArrayList<TilePositionBoard> tilesToRemove, int columnOfShelves, int currentGameId, int[] ordine) {
        this.columnOfShelves = columnOfShelves;
        this.tilesToRemove = tilesToRemove;
        this.currentGameId = currentGameId;
        this.ordine = ordine;
    }

    public int[] getOrdine() {
        return ordine;
    }

    public int getCurrentGameId() {
        return currentGameId;
    }

    public int getColumnOfShelves() {
        return columnOfShelves;
    }

    public ArrayList<TilePositionBoard> getTilesToRemove() {
        return tilesToRemove;
    }
}
