package org.example.Model;

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
                if(tilePositions[i][j].getTile() != null) {
                    System.out.print(tilePositions[i][j].toString() + " ");
                } else {
                    System.out.print("[ ]");
                }
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
        return tilePositions[y][x];
    }

    public TilePositionShelves[][] showShelves() {
        return this.tilePositions;
    }

    public int getMaxRows(){
        return this.tilePositions.length;
    }

    public int getMaxColums(){
        return this.tilePositions[0].length;
    }


}