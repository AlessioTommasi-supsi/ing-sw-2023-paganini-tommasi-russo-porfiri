package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class Shelves implements Serializable {

    private int filledCounter;
    private TilePositionShelves[][] tilePositions;

    public Shelves() {
        this.tilePositions = new TilePositionShelves[6][5];
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 5; j++){
                tilePositions[i][j] = new TilePositionShelves(i, j);
            }
        }
    }

    public void displayShelves() {
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(tilePositions[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean isFull() {
       if(filledCounter == 30) {
           return true;
       }
       return false;
    }

    public void addTile(TilePositionShelves p) {
        int x = p.getX();
        int y = p.getY();
        tilePositions[x][y] = p;
        this.filledCounter ++;
    }

    public int getFilledCounter() {
        return filledCounter;
    }

    public TilePositionShelves getTilePosition(int x, int y){
        return tilePositions[x][y];
    }

}