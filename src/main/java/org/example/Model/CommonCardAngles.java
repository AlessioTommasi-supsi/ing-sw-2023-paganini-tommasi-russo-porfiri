package org.example.Model;

public class CommonCardAngles {
    public boolean checkAngles(Player player) {
        int x = 0,y = 0;
        TileType type;
        if (player.getShelves().getTilePosition(x,y) != null) {
            type = player.getShelves().getTilePosition(x, y).getTile().getType();
            if (checkAnglesTiles(player.getShelves(), type, x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAnglesTiles(Shelves shelf, TileType type, int x, int y) {
        if (shelf.getTilePosition(x, y) != null) {
            if (x == shelf.getMaxRows() - 1) {
                if (y == shelf.getMaxColums() - 1) {
                    return checkAnglesTiles(shelf, type, 0, y);
                } else {
                    return checkAnglesTiles(shelf, type, x, shelf.getMaxColums() - 1);
                }
            } else {
                if (y == shelf.getMaxColums() - 1) {
                    return true;
                } else {
                    return checkAnglesTiles(shelf, type, shelf.getMaxRows() - 1, y);
                }
            }
        } else {
            return false;
        }
    }

}
