package org.example.view;

import org.example.Model.TilePositionBoard;

import java.io.Serializable;
import java.util.ArrayList;

public class Draw_from_board_Message implements Serializable {
    public int columm_of_sheves;

    public ArrayList<TilePositionBoard> tilesToRemove;

    public int current_game_id;

    public int ordine[];


    public Draw_from_board_Message(ArrayList<TilePositionBoard> tilesToRemove, int columm_of_sheves, int current_game_id, int[] ordine) {
        this.columm_of_sheves = columm_of_sheves;
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

    public int getColumm_of_sheves() {
        return columm_of_sheves;
    }

    public ArrayList<TilePositionBoard> getTilesToRemove() {
        return tilesToRemove;
    }
}
