package org.example.model;

import java.io.Serializable;

public class CommonCardStair extends CommonCard implements Serializable {

    public CommonCardStair(int index) {
        super(index,"check if the tiles on your shelf are in stair form");
    }



    public boolean executeAlgorithm(Player player) {
        int x=0;
        int y=0;
        int maxRowActual=4;
        if(checkStairForm(player.getShelves(), x, y, maxRowActual)) {
            return true;
        }
        x=0;
        y=4;
        maxRowActual =4;
        if(checkStairFormInverse(player.getShelves(), x, y, maxRowActual)) {
            return true;
        }
        return false;
    }

    private boolean checkStairForm(Shelves shelf, int x, int y, int maxRowActual) {
        if(y==shelf.getMaxColums()) {
            return true;
        }
        if(shelf.getTilePosition(x, y).isOccupied()) {
            if (x == maxRowActual) {
                y++;
                x = 0;
                maxRowActual--;
                return checkStairForm(shelf, x, y, maxRowActual);
            }
            return checkStairForm(shelf, x + 1, y, maxRowActual);
        }
        return false;
    }
    private boolean checkStairFormInverse(Shelves shelf, int x, int y, int maxRowActual) {
        if(y==-1) {
            return true;
        }
        if(shelf.getTilePosition(x, y).isOccupied()) {
                if (x == maxRowActual) {
                    y--;
                    x = 0;
                    maxRowActual--;
                    return checkStairForm(shelf, x, y, maxRowActual);
                }
                return checkStairForm(shelf, x + 1, y, maxRowActual);
            }
        return false;
    }
}
