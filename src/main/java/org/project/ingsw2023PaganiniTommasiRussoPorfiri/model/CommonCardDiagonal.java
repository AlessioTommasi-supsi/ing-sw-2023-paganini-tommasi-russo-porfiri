package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import java.io.Serializable;

public class CommonCardDiagonal extends CommonCard implements Serializable {

    public CommonCardDiagonal(int index) {
        super(index,"You have to complete one of the possible diagonals with the same type of tiles");
    }

    public boolean executeAlgorithm(Player player) {
        int x, y;
        x = 0;
        y = 0;
        TileType type;
        if (player.getShelves().getTilePosition(x, y).isOccupied()) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileRight(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 1;
        if (player.getShelves().getTilePosition(x, y).isOccupied()) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileRight(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 0;
        y = 4;
        if (player.getShelves().getTilePosition(x, y).isOccupied()) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileLeft(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 1;
        if (player.getShelves().getTilePosition(x, y).isOccupied()) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileLeft(x, y, player.getShelves(), type)){
                return true;
            }
        }
        return false;
    }

    private boolean checkTypeOfTileRight (int x, int y, Shelves shelf, TileType type) {
        if (y== shelf.getMaxColumns()){
            return true;
        }
        if((shelf.getTilePosition(x, y).isOccupied()) && (shelf.getTilePosition(x, y).getTile().getType() == type)) {
            return checkTypeOfTileRight(x + 1, y + 1, shelf, type);
        }
        return false;

    }

    private boolean checkTypeOfTileLeft (int x, int y, Shelves shelf, TileType type) {
        if (y == -1){
            return true;
        }
        if((shelf.getTilePosition(x, y).isOccupied()) && (shelf.getTilePosition(x, y).getTile().getType() == type)) {
                return checkTypeOfTileLeft(x + 1, y - 1, shelf, type);
        }
        return false;

    }
}
