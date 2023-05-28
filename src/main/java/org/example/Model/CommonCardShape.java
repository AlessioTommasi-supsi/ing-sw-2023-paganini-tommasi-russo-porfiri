package org.example.Model;

import java.io.Serializable;

public class CommonCardShape extends CommonCard implements Serializable {
    int counter = 0;
    boolean[][] arrayBool;
    String form;

    public CommonCardShape(int index) {
        super(index);
        if(index==0) {
            form = "SmallRectangle";
            super.setDescription("you have to create 6 vertical rectangle formed of 2 tiles with the same type of tiles in your shelf ");
        } else if (index == 4) {
            form = "LargeRectangle";
            super.setDescription("you have to create 4 vertical rectangle formed of 4 tiles with the same type of tiles in your shelf");
        } else {
            form = "Square";
            super.setDescription("you have to create 2 squares formed of 4 tiles with the same type of tiles in your shelf");
        }
    }

    public boolean executeAlgorithm(Player player) {
        switch(form) {
            case "Square" : {
                this.arrayBool = new boolean[5][4];
                for(int i=0;i<5;i++) {
                    for (int j = 0;j<4;j++) {
                        arrayBool[i][j] = false;
                    }
                }
                for(int i=0;i<5;i++) {
                    for (int j=0;j<4;j++) {
                        if((player.getShelves().getTilePosition(i,j).isOccupied()) && (!arrayBool[i][j])) {
                            TileType type = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if(checkSquare(player.getShelves(), i, j, type)) {
                                counter++;
                                if (counter == 2) {
                                    return true;
                                }
                                arrayBool[i][j] = true;
                                if(i+1 < 5) {
                                    arrayBool[i + 1][j] = true;
                                    if (j + 1 < 4) {
                                        arrayBool[i + 1][j + 1] = true;
                                    }
                                }
                                if(j+1 < 4) {
                                    arrayBool[i][j + 1] = true;
                                }
                            }
                        }
                    }
                }
            }
            case "SmallRectangle" : {
                this.arrayBool = new boolean[5][5];
                for(int i = 0;i<5;i++) {
                    for (int j=0;j<5;j++) {
                        arrayBool[i][j] = false;
                    }
                }
                for(int i = 0;i<5;i++) {
                    for(int j=0;j<5;j++) {
                        if((player.getShelves().getTilePosition(i,j).isOccupied()) && (!arrayBool[i][j])) {
                            TileType type = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if (checkSmallRectangle(player.getShelves(), i, j, 0, type)) {
                                counter++;
                                if (counter==6) {
                                    return true;
                                }
                                arrayBool[i][j] = true;
                                if (i+1 < 5) {
                                    arrayBool[i + 1][j] = true;
                                }
                            }
                        }
                    }
                }
            }
            case "LargeRectangle" : {
                this.arrayBool = new boolean[3][5];
                for(int i=0;i<3;i++) {
                    for(int j=0;j<5;j++) {
                        arrayBool[i][j] = false;
                    }
                }
                for(int i=0;i<3;i++) {
                    for(int j=0;j<5;j++) {
                        if((player.getShelves().getTilePosition(i,j).isOccupied()) && (!arrayBool[i][j])) {
                            TileType type = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if (checkLargeRectangle(player.getShelves(), i, j, type)) {
                                counter++;
                                if (counter == 4) {
                                    return true;
                                }
                                arrayBool[i][j] = true;
                                if(i+1<3) {
                                    arrayBool[i+1][j] = true;
                                }
                                if(i+2 < 3) {
                                    arrayBool[i + 2][j] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean checkSquare(Shelves shelf, int x, int y, TileType type) {
        if((checkSmallRectangle(shelf, x, y, 0, type)) && (checkSmallRectangle(shelf, x, y+1, 0, type))) {
            return true;
        }
        return false;
    }

    private boolean checkSmallRectangle(Shelves shelf, int x, int y, int countInteractions, TileType type) {
        if((shelf.getTilePosition(x, y).isOccupied()) && (shelf.getTilePosition(x, y).getTile().getType() == type)) {
            if (countInteractions < 2) {
                countInteractions++;
                return checkSmallRectangle(shelf, x+1, y, countInteractions, type);
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean checkLargeRectangle(Shelves shelf, int x, int y, TileType type) {
        if(checkSmallRectangle(shelf, x, y, 0, type) && (checkSmallRectangle(shelf, x+2, y, 0, type))) {
            return true;
        }
        return false;
    }
}
