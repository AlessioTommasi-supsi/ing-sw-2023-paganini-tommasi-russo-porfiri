package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

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
            System.out.print("\n");
        }
    }

    public boolean isFull() {
        return filledCounter == 30;
    }

    public void addTile(TilePositionShelves p) {
        int x = p.getX();
        int y = p.getY();
        this.tilePositions[x][y] = new TilePositionShelves(p);
        this.filledCounter ++;
    }

    public int getFilledCounter() {
        return filledCounter;
    }

    public TilePositionShelves getTilePosition(int x, int y){
        return tilePositions[x][y];
    }

    public TilePositionShelves getTilePosition2(int x, int y){
        return tilePositions[y][x];
    }


    public TilePositionShelves[][] showShelves() {
        return this.tilePositions;
    }

    public int getMaxRows(){
        return this.tilePositions.length;
    }

    public int getMaxColumns(){
        return this.tilePositions[0].length;
    }


}