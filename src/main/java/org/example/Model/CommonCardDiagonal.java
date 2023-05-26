package org.example.Model;

import java.io.Serializable;

public class CommonCardDiagonal extends CommonCard implements Serializable {

    public CommonCardDiagonal(int index) {
        super(index);
    }

    public boolean executeAlgorithm(Player player) {
        int x, y;
        x = 0;
        y = 0;
        TileType type;
        if (player.getShelves().getTilePosition(x, y) != null) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileRight(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 1;
        if (player.getShelves().getTilePosition(x, y) != null) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileRight(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 0;
        y = 4;
        if (player.getShelves().getTilePosition(x, y) != null) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileLeft(x, y, player.getShelves(), type)){
                return true;
            }
        }
        x = 1;
        if (player.getShelves().getTilePosition(x, y) != null) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if(checkTypeOfTileLeft(x, y, player.getShelves(), type)){
                return true;
            }
        }
        return false;
    }

    private boolean checkTypeOfTileRight (int x, int y, Shelves shelf, TileType type) {
        if (y== shelf.getMaxColums()){
            return true;
        }
        if((shelf.getTilePosition(x,y) != null) && (shelf.getTilePosition(x, y).getTile().getType() == type)) {
            return checkTypeOfTileRight(x + 1, y + 1, shelf, type);
        }
        return false;

    }

    private boolean checkTypeOfTileLeft (int x, int y, Shelves shelf, TileType type) {
        if (y == -1){
            return true;
        }
        if((shelf.getTilePosition(x, y) != null) && (shelf.getTilePosition(x, y).getTile().getType() == type)) {
                return checkTypeOfTileLeft(x + 1, y - 1, shelf, type);
        }
        return false;

    }
}
