package org.example.Model;

public class CommonCardStair {
    public boolean checkStair(Player player) {
        int x=0;
        int y=0;
        int maxRowActual=5;
        if(checkStairForm(player.getShelves(), x, y, maxRowActual)) {
            return true;
        }
        x=0;
        y=4;
        maxRowActual =5;
        if(checkStairFormInverse(player.getShelves(), x, y, maxRowActual)) {
            return true;
        }
        return false;
    }

    private boolean checkStairForm(Shelves shelf, int x, int y, int maxRowActual) {
        if(y==shelf.getMaxColums()) {
            return true;
        }
        if(shelf.getTilePosition(x, y) != null) {
            if(x==maxRowActual) {
                y++;
                x=0;
                maxRowActual--;
            }
            return checkStairForm(shelf, x++, y, maxRowActual);
        }
        return false;
    }
    private boolean checkStairFormInverse(Shelves shelf, int x, int y, int maxRowActual) {
        if(y==-1) {
            return true;
        }
        if(shelf.getTilePosition(x, y) != null) {
            if(x==maxRowActual) {
                y--;
                x=0;
                maxRowActual--;
            }
            return checkStairForm(shelf, x++, y, maxRowActual);
        }
        return false;
    }
}
