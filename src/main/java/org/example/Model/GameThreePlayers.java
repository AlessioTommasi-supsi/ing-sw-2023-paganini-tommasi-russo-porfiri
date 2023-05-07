package org.example.Model;

import java.util.ArrayList;

public class GameThreePlayers extends Game {
    public GameThreePlayers(int playerNumber, Player dealer){
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

        this.board.setPlacements(tempP);
        this.board.addTiles();
    }
}
