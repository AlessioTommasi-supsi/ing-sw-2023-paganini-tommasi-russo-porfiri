package org.example.Model;


import java.util.ArrayList;
import java.util.List;

public class CommonCardPosition implements CommonObjectiveInterface {

    private Shelves shelf;

    public boolean executeAlgorithm(String nameOfCard) {
        boolean objectiveAchieved = false;
        int counterTile = 0;
        int counterShape = 0;
        switch (nameOfCard) {
            case "Angles" -> {
                if ((shelf.getTilePosition(0, 0) != null)
                        && (shelf.getTilePosition(0, 5) != null)
                        && (shelf.getTilePosition(4, 0) != null)
                        && (shelf.getTilePosition(4, 5) != null)) {
                    objectiveAchieved = true;
                }
                return objectiveAchieved;
            }
            case "Eight tiles no restriction" -> {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (shelf.getTilePosition(i, j) != null) {
                            counterTile++;
                        }
                    }
                }
                if (counterTile == 8) {
                    return true;
                } else {
                    return false;
                }
            }
            case "Inferior diagonal" -> {
                int i, j = 0;
                int indexDecrescent = 6;
                for (i = 0; i < 5; i++) {
                    for (j = 0; j < indexDecrescent; j++) {
                        if (shelf.getTilePosition(i, j) == null) {
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
            case "Diagonal" -> {
                if (shelf.getTilePosition(0, 0) != null) {
                    TileType typeTile = shelf.getTilePosition(0, 0).getTile().getType();
                    if ((shelf.getTilePosition(1, 1) != null) && (shelf.getTilePosition(1, 1).getTile().getType() == typeTile)) {
                        if ((shelf.getTilePosition(2, 2) != null) && (shelf.getTilePosition(2, 2).getTile().getType() == typeTile)) {
                            if ((shelf.getTilePosition(3, 3) != null) && (shelf.getTilePosition(3, 3).getTile().getType() == typeTile)) {
                                if ((shelf.getTilePosition(4, 4) != null) && (shelf.getTilePosition(4, 4).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (shelf.getTilePosition(0, 1) != null) {
                    TileType typeTile = shelf.getTilePosition(1, 2).getTile().getType();
                    if ((shelf.getTilePosition(1, 2) != null) && (shelf.getTilePosition(1, 2).getTile().getType() == typeTile)) {
                        if ((shelf.getTilePosition(2, 3) != null) && (shelf.getTilePosition(2, 3).getTile().getType() == typeTile)) {
                            if ((shelf.getTilePosition(3, 4) != null) && (shelf.getTilePosition(3, 4).getTile().getType() == typeTile)) {
                                if ((shelf.getTilePosition(4, 5) != null) && (shelf.getTilePosition(4, 5).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (shelf.getTilePosition(4, 0) != null) {
                    TileType typeTile = shelf.getTilePosition(4, 0).getTile().getType();
                    if ((shelf.getTilePosition(3, 1) != null) && (shelf.getTilePosition(3, 1).getTile().getType() == typeTile)) {
                        if ((shelf.getTilePosition(2, 2) != null) && (shelf.getTilePosition(2, 2).getTile().getType() == typeTile)) {
                            if ((shelf.getTilePosition(1, 3) != null) && (shelf.getTilePosition(1, 3).getTile().getType() == typeTile)) {
                                if ((shelf.getTilePosition(0, 4) != null) && (shelf.getTilePosition(0, 4).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                if (shelf.getTilePosition(4, 1) != null) {
                    TileType typeTile = shelf.getTilePosition(4, 1).getTile().getType();
                    if ((shelf.getTilePosition(3, 2) != null) && (shelf.getTilePosition(3, 2).getTile().getType() == typeTile)) {
                        if ((shelf.getTilePosition(2, 3) != null) && (shelf.getTilePosition(2, 3).getTile().getType() == typeTile)) {
                            if ((shelf.getTilePosition(1, 4) != null) && (shelf.getTilePosition(1, 4).getTile().getType() == typeTile)) {
                                if ((shelf.getTilePosition(0, 5) != null) && (shelf.getTilePosition(0, 5).getTile().getType() == typeTile)) {
                                    objectiveAchieved = true;
                                }
                            }
                        }
                    }
                }
                return objectiveAchieved;
            }
            case "Vertical different six" -> {
                List<TileType> tileTypes = new ArrayList<TileType>();
                for(int i = 0; i < 5; i++) {
                    if (shelf.getTilePosition(i, 0) != null) {
                        tileTypes.add(shelf.getTilePosition(i, 0).getTile().getType());
                        if (shelf.getTilePosition(i, 1) != null) {
                            if (tileTypes.contains(shelf.getTilePosition(i, 1).getTile().getType())) {
                                continue;
                            } else {
                                tileTypes.add(shelf.getTilePosition(i, 1).getTile().getType());
                                if (shelf.getTilePosition(i, 2) != null) {
                                    if (tileTypes.contains(shelf.getTilePosition(i, 2).getTile().getType())) {
                                        continue;
                                    } else {
                                        tileTypes.add(shelf.getTilePosition(i, 2).getTile().getType());
                                        if (shelf.getTilePosition(i, 3) != null) {
                                            if (tileTypes.contains(shelf.getTilePosition(i, 3).getTile().getType())) {
                                                continue;
                                            } else {
                                                tileTypes.add(shelf.getTilePosition(i, 3).getTile().getType());
                                                if (shelf.getTilePosition(i, 4) != null) {
                                                    if (tileTypes.contains(shelf.getTilePosition(i, 4).getTile().getType())) {
                                                        continue;
                                                    } else {
                                                        tileTypes.add(shelf.getTilePosition(i, 4).getTile().getType());
                                                        if (shelf.getTilePosition(i, 5) != null) {
                                                            if (tileTypes.contains(shelf.getTilePosition(i, 5).getTile().getType())) {
                                                                continue;
                                                            } else {
                                                                tileTypes.add(shelf.getTilePosition(i, 5).getTile().getType());
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
            case "Row of 5 different tiles" -> {
                List<TileType> tileTypes = new ArrayList<TileType>();
                for(int i = 0; i < 6; i++) {
                    if (shelf.getTilePosition(0, i) != null) {
                        tileTypes.add(shelf.getTilePosition(0, i).getTile().getType());
                        if (shelf.getTilePosition(1, i) != null) {
                            if (tileTypes.contains(shelf.getTilePosition(1, i).getTile().getType())) {
                                continue;
                            } else {
                                tileTypes.add(shelf.getTilePosition(1, i).getTile().getType());
                                if (shelf.getTilePosition(2, i) != null) {
                                    if (tileTypes.contains(shelf.getTilePosition(2, i).getTile().getType())) {
                                        continue;
                                    } else {
                                        tileTypes.add(shelf.getTilePosition(2, i).getTile().getType());
                                        if (shelf.getTilePosition(3, i) != null) {
                                            if (tileTypes.contains(shelf.getTilePosition(3, i).getTile().getType())) {
                                                continue;
                                            } else {
                                                tileTypes.add(shelf.getTilePosition(3, i).getTile().getType());
                                                if (shelf.getTilePosition(4, i) != null) {
                                                    if (tileTypes.contains(shelf.getTilePosition(4, i).getTile().getType())) {
                                                        continue;
                                                    } else {
                                                        tileTypes.add(shelf.getTilePosition(4, i).getTile().getType());
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

        }
        return false;
    }
}
