package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

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
        for (int i = 1; i < 4; i++) {
            tempScores[i] = (i+1)*2;
        }
        setCommonCardScores(tempScores);
    }

    @Override
    public void updatePointsCommon() {
        int pointsToSub = 2;  //punti da sottrarre a ogni completamento
        CommonCard cc1 = this.getCommon1();
        CommonCard cc2 = this.getCommon2();
        Player currentPlayer = this.getCurrentPlayer();
        //se il player non ha ancora completato la commonCard
        if (!(currentPlayer.isCommonCard1Completed())) {
            //se il player completa l'obiettivo aggiungi i punti altrimenti no
            if (cc1.executeAlgorithm(currentPlayer)) {
                if (cc1.getScore()>=4){
                    currentPlayer.setScore(currentPlayer.getScore() + cc1.getScore());   //aggiorna i punti
                    cc1.setScore(cc1.getScore() - pointsToSub); // sottrai i punti
                    currentPlayer.setCommonCard1Completed(true);
                }

            }
        }
        if (!currentPlayer.isCommonCard2Completed()) {
            if (cc2.executeAlgorithm(currentPlayer)) {
                if (cc2.getScore()>=4){
                    currentPlayer.setScore(currentPlayer.getScore() + cc2.getScore());
                    cc2.setScore(cc2.getScore() - pointsToSub);
                    currentPlayer.setCommonCard2Completed(true);
                }
            }
        }
    }
}
