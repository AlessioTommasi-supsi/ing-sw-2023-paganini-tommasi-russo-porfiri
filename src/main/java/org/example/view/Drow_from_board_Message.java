package org.example.view;

import org.example.Model.TilePositionBoard;

import java.util.ArrayList;

public class Drow_from_board_Message {
    public int columm_of_sheves;

    public ArrayList<TilePositionBoard> tilesToRemove;

    public Drow_from_board_Message( ArrayList<TilePositionBoard> tilesToRemove,int columm_of_sheves) {
        this.columm_of_sheves = columm_of_sheves;
        this.tilesToRemove = tilesToRemove;
    }

    public int getColumm_of_sheves() {
        return columm_of_sheves;
    }

    public ArrayList<TilePositionBoard> getTilesToRemove() {
        return tilesToRemove;
    }
}
