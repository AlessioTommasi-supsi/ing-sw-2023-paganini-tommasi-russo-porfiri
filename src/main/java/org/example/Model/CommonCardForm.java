package org.example.Model;

import java.io.Serializable;

public class CommonCardForm extends CommonCard implements Serializable {

    public CommonCardForm(int points, int index) {
        super(points, index);
    }

    @Override
    public boolean executeAlgorithm(Player player) {
        boolean objectiveAchieved = false;
        int counterShape = 0;
        switch (getIndex()) {
            case 1 -> {
                if (player.getShelves().getTilePosition(0, 0) != null) {
                    TileType typeTile = player.getShelves().getTilePosition(0, 0).getTile().getType();
                    if ((player.getShelves().getTilePosition(1, 1) != null) && (player.getShelves().getTilePosition(1, 1).getTile().getType() == typeTile)) {
                        if ((player.getShelves().getTilePosition(2, 2) != null) && (player.getShelves().getTilePosition(2, 2).getTile().getType() == typeTile)) {
                            if ((player.getShelves().getTilePosition(3, 3) != null) && (player.getShelves().getTilePosition(3, 3).getTile().getType() == typeTile)) {
                                if ((player.getShelves().getTilePosition(4, 4) != null) && (player.getShelves().getTilePosition(4, 4).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (player.getShelves().getTilePosition(0, 1) != null) {
                    TileType typeTile = player.getShelves().getTilePosition(1, 2).getTile().getType();
                    if ((player.getShelves().getTilePosition(1, 2) != null) && (player.getShelves().getTilePosition(1, 2).getTile().getType() == typeTile)) {
                        if ((player.getShelves().getTilePosition(2, 3) != null) && (player.getShelves().getTilePosition(2, 3).getTile().getType() == typeTile)) {
                            if ((player.getShelves().getTilePosition(3, 4) != null) && (player.getShelves().getTilePosition(3, 4).getTile().getType() == typeTile)) {
                                if ((player.getShelves().getTilePosition(4, 5) != null) && (player.getShelves().getTilePosition(4, 5).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (player.getShelves().getTilePosition(4, 0) != null) {
                    TileType typeTile = player.getShelves().getTilePosition(4, 0).getTile().getType();
                    if ((player.getShelves().getTilePosition(3, 1) != null) && (player.getShelves().getTilePosition(3, 1).getTile().getType() == typeTile)) {
                        if ((player.getShelves().getTilePosition(2, 2) != null) && (player.getShelves().getTilePosition(2, 2).getTile().getType() == typeTile)) {
                            if ((player.getShelves().getTilePosition(1, 3) != null) && (player.getShelves().getTilePosition(1, 3).getTile().getType() == typeTile)) {
                                if ((player.getShelves().getTilePosition(0, 4) != null) && (player.getShelves().getTilePosition(0, 4).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (player.getShelves().getTilePosition(4, 1) != null) {
                    TileType typeTile = player.getShelves().getTilePosition(4, 1).getTile().getType();
                    if ((player.getShelves().getTilePosition(3, 2) != null) && (player.getShelves().getTilePosition(3, 2).getTile().getType() == typeTile)) {
                        if ((player.getShelves().getTilePosition(2, 3) != null) && (player.getShelves().getTilePosition(2, 3).getTile().getType() == typeTile)) {
                            if ((player.getShelves().getTilePosition(1, 4) != null) && (player.getShelves().getTilePosition(1, 4).getTile().getType() == typeTile)) {
                                if ((player.getShelves().getTilePosition(0, 5) != null) && (player.getShelves().getTilePosition(0, 5).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
            }
            case 0 -> {
                boolean[][] alreadyPartOfShape = new boolean[5][6];
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 5; i++) {
                        alreadyPartOfShape[i][j] = false;
                    }
                }
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 5; i++) {
                        if ((player.getShelves().getTilePosition(i, j) != null) && (!alreadyPartOfShape[i][j])) {
                            TileType tileType = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if(j+1 < 6) {
                                if ((player.getShelves().getTilePosition(i, j + 1) != null) && (!alreadyPartOfShape[i][j + 1]) && (player.getShelves().getTilePosition(i, j + 1).getTile().getType() == tileType)) {
                                    counterShape++;
                                    if(counterShape == 6) {
                                        objectiveAchieved = true;
                                    }
                                    alreadyPartOfShape[i][j] = true;
                                    alreadyPartOfShape[i][j + 1] = true;
                                    if(i+1 < 5) {
                                        alreadyPartOfShape[i + 1][j + 1] = true;
                                        alreadyPartOfShape[i + 1][j] = true;
                                    }
                                    if (j+2 < 6) {
                                        alreadyPartOfShape[i][j+2] = true;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            case 4 -> {
                boolean[][] alreadyPartOfShape = new boolean[5][6];
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 5; i++) {
                        alreadyPartOfShape[i][j] = false;
                    }
                }
                for (int j = 0; j<6;j++) {
                    for (int i = 0;i<5;i++) {
                        if ((player.getShelves().getTilePosition(i, j) != null) && (!alreadyPartOfShape[i][j])) {
                            TileType tileType = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if (j + 1 < 6) {
                                if ((player.getShelves().getTilePosition(i, j + 1) != null) && (!alreadyPartOfShape[i][j + 1]) && (player.getShelves().getTilePosition(i, j + 1).getTile().getType() == tileType)) {
                                    if (j+2 < 6) {
                                        if ((player.getShelves().getTilePosition(i, j + 2) != null) && (!alreadyPartOfShape[i][j + 2]) && (player.getShelves().getTilePosition(i, j + 2).getTile().getType() == tileType)) {
                                            if (j + 3 < 6) {
                                                if ((player.getShelves().getTilePosition(i, j + 3) != null) && (!alreadyPartOfShape[i][j + 3]) && (player.getShelves().getTilePosition(i, j + 3).getTile().getType() == tileType)) {
                                                    counterShape++;
                                                    if(counterShape == 4) {
                                                        objectiveAchieved = true;
                                                        break;
                                                    }
                                                    alreadyPartOfShape[i][j] = true;
                                                    alreadyPartOfShape[i][j+1] = true;
                                                    alreadyPartOfShape[i][j+2] = true;
                                                    alreadyPartOfShape[i][j+3] = true;
                                                    if (i+1 < 5) {
                                                        alreadyPartOfShape[i+1][j] = true;
                                                        alreadyPartOfShape[i+1][j+1] = true;
                                                        alreadyPartOfShape[i+1][j+2] = true;
                                                        alreadyPartOfShape[i+1][j+3] = true;
                                                    }
                                                    if (j+4 < 6) {
                                                        alreadyPartOfShape[i][j+4] = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            case 6 -> {
                boolean[][] alreadyPartOfShape = new boolean[5][6];
                for (int j = 0; j < 6; j++) {
                    for (int i = 0; i < 5; i++) {
                        alreadyPartOfShape[i][j] = false;
                    }
                }
                for(int j = 0; j<6;j++) {
                    for (int i = 0;i<5;i++) {
                        if ((player.getShelves().getTilePosition(i, j) != null) && (!alreadyPartOfShape[i][j])) {
                            TileType tileType = player.getShelves().getTilePosition(i, j).getTile().getType();
                            if (j + 1 < 6) {
                                if ((player.getShelves().getTilePosition(i, j + 1) != null) && (!alreadyPartOfShape[i][j + 1]) && (player.getShelves().getTilePosition(i, j + 1).getTile().getType() == tileType)) {
                                    if (i+1< 5) {
                                        if ((player.getShelves().getTilePosition(i+1, j) != null) && (!alreadyPartOfShape[i+1][j]) && (player.getShelves().getTilePosition(i+1, j).getTile().getType() == tileType)) {
                                            if ((player.getShelves().getTilePosition(i+1, j+1) != null) && (!alreadyPartOfShape[i+1][j + 1]) && (player.getShelves().getTilePosition(i+1, j + 1).getTile().getType() == tileType)) {
                                                counterShape++;
                                                if (counterShape == 2) {
                                                    objectiveAchieved = true;
                                                    break;
                                                }
                                                alreadyPartOfShape[i][j] = true;
                                                alreadyPartOfShape[i][j+1] = true;
                                                alreadyPartOfShape[i+1][j] = true;
                                                alreadyPartOfShape[i+1][j+1] = true;
                                                if (i+2 < 5) {
                                                    alreadyPartOfShape[i+2][j] = true;
                                                    alreadyPartOfShape[i+2][j+1] = true;
                                                }
                                                if (j+2 < 6) {
                                                    alreadyPartOfShape[i][j+2] = true;
                                                    alreadyPartOfShape[i+1][j+2] = true;
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
            case 9 -> {
                for(int j = 0; j<6;j++) {
                    for (int i = 0; i < 5;i++) {
                        if (player.getShelves().getTilePosition(i,j) != null) {
                            TileType tileType = player.getShelves().getTilePosition(i,j).getTile().getType();
                            if(j<4) {
                                if(i<3) {
                                    if ((player.getShelves().getTilePosition(i + 1, j + 1) != null) && (player.getShelves().getTilePosition(i + 1, j + 1).getTile().getType() == tileType)) {
                                        if ((player.getShelves().getTilePosition(i + 2, j) != null) && (player.getShelves().getTilePosition(i + 2, j).getTile().getType() == tileType)) {
                                            if ((player.getShelves().getTilePosition(i, j + 2) != null) && (player.getShelves().getTilePosition(i, j + 2).getTile().getType() == tileType)) {
                                                if ((player.getShelves().getTilePosition(i + 2, j + 2) != null) && (player.getShelves().getTilePosition(i + 2, j + 2).getTile().getType() == tileType)) {
                                                    objectiveAchieved = true;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if ((player.getShelves().getTilePosition(i - 1, j + 1) != null) && (player.getShelves().getTilePosition(i - 1, j + 1).getTile().getType() == tileType)) {
                                        if ((player.getShelves().getTilePosition(i - 2, j) != null) && (player.getShelves().getTilePosition(i - 2, j).getTile().getType() == tileType)) {
                                            if ((player.getShelves().getTilePosition(i, j + 2) != null) && (player.getShelves().getTilePosition(i, j + 2).getTile().getType() == tileType)) {
                                                if ((player.getShelves().getTilePosition(i - 2, j + 2) != null) && (player.getShelves().getTilePosition(i - 2, j + 2).getTile().getType() == tileType)) {
                                                    objectiveAchieved = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                if(i<3) {
                                    if ((player.getShelves().getTilePosition(i + 1, j - 1) != null) && (player.getShelves().getTilePosition(i + 1, j - 1).getTile().getType() == tileType)) {
                                        if ((player.getShelves().getTilePosition(i + 2, j) != null) && (player.getShelves().getTilePosition(i + 2, j).getTile().getType() == tileType)) {
                                            if ((player.getShelves().getTilePosition(i, j - 2) != null) && (player.getShelves().getTilePosition(i, j - 2).getTile().getType() == tileType)) {
                                                if ((player.getShelves().getTilePosition(i + 2, j - 2) != null) && (player.getShelves().getTilePosition(i + 2, j - 2).getTile().getType() == tileType)) {
                                                    objectiveAchieved = true;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if ((player.getShelves().getTilePosition(i - 1, j - 1) != null) && (player.getShelves().getTilePosition(i - 1, j - 1).getTile().getType() == tileType)) {
                                        if ((player.getShelves().getTilePosition(i - 2, j) != null) && (player.getShelves().getTilePosition(i - 2, j).getTile().getType() == tileType)) {
                                            if ((player.getShelves().getTilePosition(i, j - 2) != null) && (player.getShelves().getTilePosition(i, j - 2).getTile().getType() == tileType)) {
                                                if ((player.getShelves().getTilePosition(i - 2, j - 2) != null) && (player.getShelves().getTilePosition(i - 2, j - 2).getTile().getType() == tileType)) {
                                                    objectiveAchieved = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return objectiveAchieved;
    }
}
