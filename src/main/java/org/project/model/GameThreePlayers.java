package org.project.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GameThreePlayers extends Game implements Serializable {
    public GameThreePlayers(int playerNumber, Player dealer){
        super(playerNumber, dealer);
    }

    @Override
    public void buildBoard() {
        ArrayList<TilePositionBoard> tempP = new ArrayList<TilePositionBoard>();
        tempP.add(new TilePositionBoard(0,5));
        tempP.add(new TilePositionBoard(2,2));
        tempP.add(new TilePositionBoard(2,6));
        tempP.add(new TilePositionBoard(3,0));
        tempP.add(new TilePositionBoard(5,8));
        tempP.add(new TilePositionBoard(6,2));
        tempP.add(new TilePositionBoard(6,6));
        tempP.add(new TilePositionBoard(8,3));

        setBoard(tempP);
    }


    @Override
    public void defineCommonCardScores(){
        int[] tempScores = new int[4];
        tempScores[0] = 0;
        for (int i = 1; i < 5; i++) {
            tempScores[i] = (i+1)*2;
        }
        setCommonCardScores(tempScores);
    }


}
