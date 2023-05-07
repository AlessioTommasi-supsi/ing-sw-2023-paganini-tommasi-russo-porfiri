package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class GameFourPlayers extends Game implements Serializable {
    public GameFourPlayers(int playerNumber, Player dealer){
        super(playerNumber, dealer);
    }

    @Override
    public void BuildBoard() {
        ArrayList<TilePositionBoard> tempP = new ArrayList<TilePositionBoard>();
        tempP.add(new TilePositionBoard(0,5));
        tempP.add(new TilePositionBoard(2,2));
        tempP.add(new TilePositionBoard(2,6));
        tempP.add(new TilePositionBoard(3,0));
        tempP.add(new TilePositionBoard(5,8));
        tempP.add(new TilePositionBoard(6,2));
        tempP.add(new TilePositionBoard(6,6));
        tempP.add(new TilePositionBoard(8,3));

        tempP.add(new TilePositionBoard(0,4));
        tempP.add(new TilePositionBoard(1,3));
        tempP.add(new TilePositionBoard(3,7));
        tempP.add(new TilePositionBoard(4,0));
        tempP.add(new TilePositionBoard(4,8));
        tempP.add(new TilePositionBoard(5,1));
        tempP.add(new TilePositionBoard(7,5));
        tempP.add(new TilePositionBoard(8,4));

        this.board.setPlacements(tempP);
        this.board.addTiles();
    }
}
