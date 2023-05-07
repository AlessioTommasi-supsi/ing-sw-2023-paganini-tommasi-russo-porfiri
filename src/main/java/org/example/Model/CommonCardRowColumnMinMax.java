package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class CommonCardRowColumnMinMax {
    public boolean executeAlgorithm(int index, Player player) {
        int counterShape = 0;
        boolean objectiveAchieved = false;
        switch(index) {
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
            }
        }
        return objectiveAchieved;
    }
}
