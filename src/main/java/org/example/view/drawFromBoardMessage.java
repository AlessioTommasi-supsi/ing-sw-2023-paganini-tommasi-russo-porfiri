package org.example.view;

import org.example.Model.TilePositionBoard;

import java.io.Serializable;
import java.util.ArrayList;

public class drawFromBoardMessage implements Serializable {
    public int columnOfShelves;

    public ArrayList<TilePositionBoard> tilesToRemove;

    public int current_game_id;

    public int ordine[];


    public drawFromBoardMessage(ArrayList<TilePositionBoard> tilesToRemove, int columnOfShelves, int current_game_id, int[] ordine) {
        this.columnOfShelves = columnOfShelves;
        this.tilesToRemove = tilesToRemove;
        this.current_game_id = current_game_id;
        this.ordine = ordine;
    }

    public int[] getOrdine() {
        return ordine;
    }

    public int getCurrent_game_id() {
        return current_game_id;
    }

    public int getColumnOfShelves() {
        return columnOfShelves;
    }

    public ArrayList<TilePositionBoard> getTilesToRemove() {
        return tilesToRemove;
    }
}
