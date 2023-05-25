package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCard3Types extends CommonCard implements Serializable {

    String form;
    public CommonCard3Types(int index) {
        super(index);
        if (index == 3) {
            this.form = "Horizontal 3 types";
        } else {
            this.form = "Vertical 3 types";
        }
    }

    public boolean executeAlgorithm(Player player) {
        int counter = 0;
        ArrayList<TileType> types = new ArrayList<>();
        switch(form) {
            case("Horizontal 3 types") : {
                for(int i=0;i<6;i++) {
                    if (checkHorizontal3Types(types, player.getShelves(), i, 0)) {
                        counter++;
                        if(counter == 4) {
                            return true;
                        }
                    }
                }
            }
            case("Vertical 3 types") : {
                for (int i=0; i < 5;i++) {
                    if (checkVertical3Types(types, player.getShelves(), 0, i)) {
                        counter++;
                        if(counter == 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkVertical3Types(ArrayList<TileType> types, Shelves shelf, int x, int y) {
        if (x==shelf.getMaxRows()) {
            return true;
        }
        if (shelf.getTilePosition(x, y) != null) {
            if(types.size() < 4) {
                if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                    types.add(shelf.getTilePosition(x, y).getTile().getType());
                    return checkVertical3Types(types, shelf, x + 1, y);
                }
            }
        }
        return false;
    }

    private boolean checkHorizontal3Types(ArrayList<TileType> types, Shelves shelf, int x, int y) {
        if(y == shelf.getMaxColums()) {
            return true;
        }
        if(shelf.getTilePosition(x, y) != null) {
            if(types.size() < 4) {
                if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                    types.add(shelf.getTilePosition(x, y).getTile().getType());
                    return checkHorizontal3Types(types, shelf, x, y + 1);
                }
            }
        }
        return false;
    }

}
