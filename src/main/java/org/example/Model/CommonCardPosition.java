package org.example.Model;

import java.sql.Array;

public class CommonCardPosition implements CommonObjectiveInterface {

    int countTiles = 0;
    private Shelves shelf;

    public boolean executeAlgorithm(String nameOfCard) {
        int counterTile = 0;
        if (nameOfCard == "Angles") {
            if ((shelf.getTilePosition(0,0) != null)
                || (shelf.getTilePosition(0, 5) != null)
                    || (shelf.getTilePosition(4, 0) != null)
                    || (shelf.getTilePosition(4, 5) != null)) { counterTile++;}
            if (counterTile == 4) {
                return true;
            } else { return false;}

        } else if (nameOfCard == "Eight tiles no restriction") {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5 ; j++) {
                    if (shelf.getTilePosition(i, j) != null) {
                        counterTile++;
                    }
                }
            }
            if (counterTile == 8) {
                return true;
            } else { return false; }
        } else if (nameOfCard == "Inferior diagonal") {
            int i, j = 0;
            int indexDecrescent = 5;
            for (i = 0; i < 6; i++) {
                for (j = 0; j < indexDecrescent; j++) {
                    if (shelf.getTilePosition(i, j) == null) {
                        break;
                    } else { counterTile++; }
                }
                indexDecrescent--;
            }
            if (counterTile == 15) { return true; }
            else { return false; }
        } else if (nameOfCard == "Diagonal") {

            if (counterTile == 1) { return true; }
            else { return false; }
        }
        return false;
    }
}
