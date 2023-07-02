package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCard3Types extends CommonCard implements Serializable {

    String form;
    public CommonCard3Types(int index) {
        super(index);
        if (index == 3) {
            this.form = "Horizontal 3 types";
            super.setDescription("Create 4 rows with a maximum of 3 different tile types in your shelf");
        } else if (index == 8) {
            this.form = "Vertical 3 types";
            super.setDescription("Create 3 columns with a maximum of 3 different tile types in your shelf");
        } else if(index==7) {
            this.form = "Horizontal";
            super.setDescription("Create 2 rows with all different tile types in your shelf");
        } else {
            this.form = "Vertical";
            super.setDescription("Create 2 columns with all different tile types in your shelf");
        }
    }

    public boolean executeAlgorithm(Player player) {
        int counter = 0;
        switch(form) {
            case("Horizontal 3 types") -> {
                for(int i=0;i<6;i++) {
                    ArrayList<TileType> types = new ArrayList<>();
                    if (checkHorizontal3Types(types, player.getShelves(), i, 0)) {
                        counter++;
                        if(counter == 4) {
                            return true;
                        }
                    }
                }
            }
            case("Vertical 3 types") -> {
                for (int i=0; i < 5;i++) {
                    ArrayList<TileType> types = new ArrayList<>();
                    if (checkVertical3Types(types, player.getShelves(), 0, i)) {
                        counter++;
                        if(counter == 3) {
                            return true;
                        }
                    }
                }
            }
            case ("Horizontal") -> {
                for(int i=0;i<6;i++) {
                    ArrayList<TileType> types = new ArrayList<>();
                    if (checkHorizontal(types, player.getShelves(), i, 0)) {
                        counter++;
                        if (counter == 2) {
                            return true;
                        }
                    }
                }
            }
            case ("Vertical") -> {
                for (int i=0; i < 5;i++) {
                    ArrayList<TileType> types = new ArrayList<>();
                    if (checkVertical(types, player.getShelves(), 0, i)) {
                        counter++;
                        if (counter == 2) {
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
        if (shelf.getTilePosition(x, y).isOccupied()) {
            if(types.size() < 4) {
                if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                    types.add(shelf.getTilePosition(x, y).getTile().getType());
                }
                return checkVertical3Types(types, shelf, x + 1, y);
            }
        }
        return false;
    }

    private boolean checkHorizontal3Types(ArrayList<TileType> types, Shelves shelf, int x, int y) {
        if(y == shelf.getMaxColumns()) {
            return true;
        }
        if(shelf.getTilePosition(x, y).isOccupied()) {
            if(types.size() < 4) {
                if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                    types.add(shelf.getTilePosition(x, y).getTile().getType());
                }
                return checkHorizontal3Types(types, shelf, x, y + 1);
            }
        }
        return false;
    }

    private boolean checkHorizontal (ArrayList<TileType> types, Shelves shelf,int x, int y) {
        if(y == shelf.getMaxColumns()) {
            return true;
        }
        if(shelf.getTilePosition(x, y).isOccupied()) {
            if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                types.add(shelf.getTilePosition(x, y).getTile().getType());
                return checkHorizontal(types, shelf, x, y + 1);
            }
        }
        return false;
    }

    private boolean checkVertical(ArrayList<TileType> types, Shelves shelf, int x, int y) {
        if (x==shelf.getMaxRows()) {
            return true;
        }
        if (shelf.getTilePosition(x, y).isOccupied()) {
            if (!types.contains(shelf.getTilePosition(x, y).getTile().getType())) {
                types.add(shelf.getTilePosition(x, y).getTile().getType());
                return checkVertical(types, shelf, x + 1, y);
            }
        }
        return false;
    }

}
