package org.example.Model;

import java.io.Serializable;

public class GameTwoPlayers extends Game implements Serializable {
    public GameTwoPlayers(int playerNumber, Player dealer){
        super(playerNumber, dealer);
    }

    @Override
    public void buildBoard() {
        return;
    }


    @Override
    public void defineCommonCardScores(){
        int[] tempScores = new int[3];
        tempScores[0] = 0;
        tempScores[1] = 4;
        tempScores[2] = 8;
        setCommonCardScores(tempScores);
    }




}
