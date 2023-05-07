package org.example.Model;


import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CommonCardPosition implements Serializable {

    public boolean executeAlgorithm(int index, Player player) {
        boolean objectiveAchieved = false;
        int counterTile = 0;
        int counterShape = 0;
        switch (index) {
            case 2 -> {
                if (player.getShelves().getTilePosition(0, 0) != null) {
                    TileType tileType = player.getShelves().getTilePosition(0,0).getTile().getType();
                    if (player.getShelves().getTilePosition(0,5) != null) {
                        if (player.getShelves().getTilePosition(0,5).getTile().getType() == tileType) {
                            if (player.getShelves().getTilePosition(4,0) != null) {
                                if (player.getShelves().getTilePosition(4,0).getTile().getType() == tileType) {
                                    if (player.getShelves().getTilePosition(4,5) != null) {
                                        if (player.getShelves().getTilePosition(4,5).getTile().getType() == tileType) {
                                            objectiveAchieved=true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return objectiveAchieved;
            }
            case 10 -> {
                TileType tileType = null;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (tileType == null) {
                            if (player.getShelves().getTilePosition(i, j) != null) {
                                tileType = player.getShelves().getTilePosition(i, j).getTile().getType();
                                counterTile++;
                            }
                        } else {
                            if ((player.getShelves().getTilePosition(i, j) != null) && (player.getShelves().getTilePosition(i,j).getTile().getType() == tileType)) {
                                counterTile++;
                            }
                        }
                    }
                }
                if (counterTile == 8) {
                    return true;
                } else {
                    return false;
                }
            }
            case 11 -> {
                int i, j;
                int indexDecrescent = 6;
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < indexDecrescent; j++) {
                        if (player.getShelves().getTilePosition(i, j) == null) {
                            break;
                        } else {
                            counterTile++;
                        }
                    }
                    indexDecrescent--;
                }
                if (counterTile == 15) {
                    return true;
                } else {
                    counterTile = 0;
                    indexDecrescent = 6;
                    for (i = 4; i >=0; i--) {
                        for (j = 0; j < indexDecrescent; j++) {
                            if (player.getShelves().getTilePosition(i, j) == null) {
                                break;
                            } else {
                                counterTile++;
                            }
                        }
                        indexDecrescent--;
                    }
                    if (counterTile == 15) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
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
                return objectiveAchieved;
            }
            case 5 -> {
                for(int i = 0; i < 5; i++) {
                    List<TileType> tileTypes = new ArrayList<TileType>();
                    if (player.getShelves().getTilePosition(i, 0) != null) {
                        tileTypes.add(player.getShelves().getTilePosition(i, 0).getTile().getType());
                        if (player.getShelves().getTilePosition(i, 1) != null) {
                            if (tileTypes.contains(player.getShelves().getTilePosition(i, 1).getTile().getType())) {
                                continue;
                            } else {
                                tileTypes.add(player.getShelves().getTilePosition(i, 1).getTile().getType());
                                if (player.getShelves().getTilePosition(i, 2) != null) {
                                    if (tileTypes.contains(player.getShelves().getTilePosition(i, 2).getTile().getType())) {
                                        continue;
                                    } else {
                                        tileTypes.add(player.getShelves().getTilePosition(i, 2).getTile().getType());
                                        if (player.getShelves().getTilePosition(i, 3) != null) {
                                            if (tileTypes.contains(player.getShelves().getTilePosition(i, 3).getTile().getType())) {
                                                continue;
                                            } else {
                                                tileTypes.add(player.getShelves().getTilePosition(i, 3).getTile().getType());
                                                if (player.getShelves().getTilePosition(i, 4) != null) {
                                                    if (tileTypes.contains(player.getShelves().getTilePosition(i, 4).getTile().getType())) {
                                                        continue;
                                                    } else {
                                                        tileTypes.add(player.getShelves().getTilePosition(i, 4).getTile().getType());
                                                        if (player.getShelves().getTilePosition(i, 5) != null) {
                                                            if (tileTypes.contains(player.getShelves().getTilePosition(i, 5).getTile().getType())) {
                                                                continue;
                                                            } else {
                                                                tileTypes.add(player.getShelves().getTilePosition(i, 5).getTile().getType());
                                                                counterShape++;
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
                    if (counterShape == 2) {
                        objectiveAchieved = true;
                    }
                }
                return objectiveAchieved;
            }
            case 7 -> {
                for(int i = 0; i < 6; i++) {
                    List<TileType> tileTypes = new ArrayList<TileType>();
                    if (player.getShelves().getTilePosition(0, i) != null) {
                        tileTypes.add(player.getShelves().getTilePosition(0, i).getTile().getType());
                        if (player.getShelves().getTilePosition(1, i) != null) {
                            if (tileTypes.contains(player.getShelves().getTilePosition(1, i).getTile().getType())) {
                                continue;
                            } else {
                                tileTypes.add(player.getShelves().getTilePosition(1, i).getTile().getType());
                                if (player.getShelves().getTilePosition(2, i) != null) {
                                    if (tileTypes.contains(player.getShelves().getTilePosition(2, i).getTile().getType())) {
                                        continue;
                                    } else {
                                        tileTypes.add(player.getShelves().getTilePosition(2, i).getTile().getType());
                                        if (player.getShelves().getTilePosition(3, i) != null) {
                                            if (tileTypes.contains(player.getShelves().getTilePosition(3, i).getTile().getType())) {
                                                continue;
                                            } else {
                                                tileTypes.add(player.getShelves().getTilePosition(3, i).getTile().getType());
                                                if (player.getShelves().getTilePosition(4, i) != null) {
                                                    if (tileTypes.contains(player.getShelves().getTilePosition(4, i).getTile().getType())) {
                                                        continue;
                                                    } else {
                                                        tileTypes.add(player.getShelves().getTilePosition(4, i).getTile().getType());
                                                                counterShape++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (counterShape == 2) {
                        objectiveAchieved = true;
                    }
                }
                return objectiveAchieved;
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
                return objectiveAchieved;
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
                return objectiveAchieved;
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
                return objectiveAchieved;
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
                return objectiveAchieved;
            }
            case 8 -> {
                for (int i = 0; i<6;i++) {
                    List<TileType> tileTypes = new ArrayList<TileType>();
                    if (player.getShelves().getTilePosition(i, 0) != null) {
                        tileTypes.add(player.getShelves().getTilePosition(i, 0).getTile().getType());
                        if((player.getShelves().getTilePosition(i, 1) != null) && (tileTypes.size() < 4)) {
                            if (!tileTypes.contains(player.getShelves().getTilePosition(i,1).getTile().getType())) {
                                tileTypes.add(player.getShelves().getTilePosition(i,1).getTile().getType());
                            }
                            if((player.getShelves().getTilePosition(i, 2) != null) && (tileTypes.size() < 4)) {
                                if (!tileTypes.contains(player.getShelves().getTilePosition(i, 2).getTile().getType())) {
                                    tileTypes.add(player.getShelves().getTilePosition(i, 2).getTile().getType());
                                }
                                if((player.getShelves().getTilePosition(i, 3) != null) && (tileTypes.size() < 4)) {
                                    if (!tileTypes.contains(player.getShelves().getTilePosition(i, 3).getTile().getType())) {
                                        tileTypes.add(player.getShelves().getTilePosition(i, 3).getTile().getType());
                                    }
                                    if((player.getShelves().getTilePosition(i, 4) != null) && (tileTypes.size() < 4)) {
                                        if (!tileTypes.contains(player.getShelves().getTilePosition(i, 4).getTile().getType())) {
                                            tileTypes.add(player.getShelves().getTilePosition(i, 4).getTile().getType());
                                        }
                                        if (tileTypes.size() < 4) {
                                            counterShape++;
                                        }
                                        if (counterShape == 3) {
                                            objectiveAchieved = true;
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return objectiveAchieved;
            }
            case 3 -> {
                for (int j = 0; j < 6; j++) {
                    List<TileType> tileTypes = new ArrayList<TileType>();
                    if (player.getShelves().getTilePosition(0, j) != null) {
                        tileTypes.add(player.getShelves().getTilePosition(0, j).getTile().getType());
                        if((player.getShelves().getTilePosition(1, j) != null) && (tileTypes.size() < 4)) {
                            if (!tileTypes.contains(player.getShelves().getTilePosition(1, j).getTile().getType())) {
                                tileTypes.add(player.getShelves().getTilePosition(1, j).getTile().getType());
                            }
                            if((player.getShelves().getTilePosition(2, j) != null) && (tileTypes.size() < 4)) {
                                if (!tileTypes.contains(player.getShelves().getTilePosition(2, j).getTile().getType())) {
                                    tileTypes.add(player.getShelves().getTilePosition(2, j).getTile().getType());
                                }
                                if((player.getShelves().getTilePosition(3, j) != null) && (tileTypes.size() < 4)) {
                                    if (!tileTypes.contains(player.getShelves().getTilePosition(3, j).getTile().getType())) {
                                        tileTypes.add(player.getShelves().getTilePosition(3, j).getTile().getType());
                                    }
                                    if((player.getShelves().getTilePosition(4, j) != null) && (tileTypes.size() < 4)) {
                                        if (!tileTypes.contains(player.getShelves().getTilePosition(4, j).getTile().getType())) {
                                            tileTypes.add(player.getShelves().getTilePosition(4, j).getTile().getType());
                                        }
                                        if((player.getShelves().getTilePosition(5, j) != null) && (tileTypes.size() < 4)) {
                                            if (!tileTypes.contains(player.getShelves().getTilePosition(5, j).getTile().getType())) {
                                                tileTypes.add(player.getShelves().getTilePosition(5, j).getTile().getType());
                                            }
                                            if (tileTypes.size() < 4) {
                                                counterShape++;
                                            }
                                            if (counterShape == 4) {
                                                objectiveAchieved = true;
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return objectiveAchieved;
            }
        }
        return false;
    }
}
