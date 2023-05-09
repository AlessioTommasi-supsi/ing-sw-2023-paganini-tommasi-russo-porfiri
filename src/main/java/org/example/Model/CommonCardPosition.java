package org.example.Model;


import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CommonCardPosition extends CommonCard implements Serializable {

    public CommonCardPosition(int index) {
        super(index);
    }


    @Override
    public boolean executeAlgorithm(Player player) {
        boolean objectiveAchieved = false;
        int counterTile = 0;
        int counterShape = 0;
        switch (getIndex()) {
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
                TileType[] tileType = TileType.values();
                for (int k = 0; k < 5; k++) {
                    TileType tileTypeSingle = tileType[k];
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 6; j++) {
                            if ((player.getShelves().getTilePosition(i, j) != null) && (player.getShelves().getTilePosition(i, j).getTile().getType() == tileTypeSingle)) {
                                counterTile++;
                                if (counterTile == 8) {
                                    break;
                                }
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
        }
        return false;
    }
}
