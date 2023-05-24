package org.example.Model;

public class CommonCardX {

    public boolean checkX (Player player) {
        for (int i = 0; i<6;i++) {
            for (int j=0;j<5;j++) {
                if(player.getShelves().getTilePosition(i, j)!= null) {
                    TileType type = player.getShelves().getTilePosition(i, j).getTile().getType();
                    if(checkXForm(player.getShelves(), type, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkXForm(Shelves shelf, TileType type, int x, int y, int countInteractions) {
        if(countInteractions < 5) {
            if(countInteractions < 4) {
                if(countInteractions < 3) {
                    if(shelf.getTilePosition(x, y) != null) {
                        if(shelf.getTilePosition(x, y).getTile().getType() == type) {
                            countInteractions++;
                            return checkXForm(shelf, type,  x+1, y+1, countInteractions);
                        }
                    }
                } else {
                    if(shelf.getTilePosition(x, y) != null) {
                        if(shelf.getTilePosition(x, y).getTile().getType() == type) {
                            countInteractions++;
                            return checkXForm(shelf, type,  x-2, y, countInteractions);
                        }
                    }
                }
            } else {
                if(shelf.getTilePosition(x, y) != null) {
                    if(shelf.getTilePosition(x, y).getTile().getType() == type) {
                        countInteractions++;
                        return checkXForm(shelf, type, x+2, y-2, countInteractions);
                    }
                }

            }
            if(shelf.getTilePosition(x, y) != null) {
                if(shelf.getTilePosition(x, y).getTile().getType() == type) {
                    return true;
                }
            }
        }
        return false;
    }
}
