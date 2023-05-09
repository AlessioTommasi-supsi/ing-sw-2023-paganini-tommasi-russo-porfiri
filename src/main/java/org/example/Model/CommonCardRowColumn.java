package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommonCardRowColumn extends CommonCard implements Serializable {

    public CommonCardRowColumn(int points, int index) {
        super(points, index);
    }

    @Override
    public boolean executeAlgorithm(Player player) {
        int counterShape = 0;
        boolean objectiveAchieved = false;
        switch(getIndex()) {
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
        }
        return objectiveAchieved;
    }
}
