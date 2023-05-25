package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCardAllDifferentTiles extends CommonCard implements Serializable {

    String form;
    public CommonCardAllDifferentTiles(int index) {
        super(index);
        if(index==3) {
            this.form = "Horizontal";
        } else {
            this.form = "Vertical";
        }
    }

    public boolean executeAlgorithm(Player player) {
        int counter = 0;
        ArrayList<TileType> types = new ArrayList<>();
        switch(form) {
            case ("Horizontal") : {
                for(int i=0;i<6;i++) {
                    if(player.getShelves().getTilePosition(i, 0) != null) {
                        if (checkHorizontal(types, player.getShelves(), i, 0)) {
                            counter++;
                            if (counter == 2) {
                                return true;
                            }
                        }
                    }
                }
            }
            case ("Vertical") : {
                for (int i=0; i < 5;i++) {
                    if(player.getShelves().getTilePosition(0, i) != null) {
                        if (checkVertical(types, player.getShelves(), 0, i)) {
                            counter++;
                            if (counter == 2) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal (ArrayList<TileType> types, Shelves shelf,int x, int y) {
        if(y == shelf.getMaxColums()) {
            return true;
        }
        if(shelf.getTilePosition(x, y) != null) {
            if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                types.add(shelf.getTilePosition(x, y).getTile().getType());
                return checkHorizontal(types, shelf, x, y + 1);
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean checkVertical(ArrayList<TileType> types, Shelves shelf, int x, int y) {
        if (x==shelf.getMaxRows()) {
            return true;
        }
        if (shelf.getTilePosition(x, y) != null) {
            if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                types.add(shelf.getTilePosition(x, y).getTile().getType());
                return checkVertical(types, shelf, x + 1, y);
            } else {
                return false;
            }
        }
        return false;
    }
}
