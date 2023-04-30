package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;


import java.util.List;

public class CommonCardPosition implements CommonObjectiveInterface {

    int countTiles = 0;
    private Shelves shelf;
    boolean objectiveAchieved = false;

    public boolean executeAlgorithm(String nameOfCard) {
        int counterTile = 0;
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
        }
        return false;
    }
}