package org.project.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCard8Tiles extends CommonCard implements Serializable {

    public CommonCard8Tiles(int index) {
        super(index, "Check if 8 tiles of the same type are present in your shelf");
    }

    public boolean executeAlgorithm(Player player) {

        ArrayList<TilePositionShelves> listOfCats = new ArrayList<>();
        ArrayList<TilePositionShelves> listOfBooks = new ArrayList<>();
        ArrayList<TilePositionShelves> listOfFrames = new ArrayList<>();
        ArrayList<TilePositionShelves> listOfGames = new ArrayList<>();
        ArrayList<TilePositionShelves> listOfPlants = new ArrayList<>();
        ArrayList<TilePositionShelves> listOfTrophies = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            for (int j=0;j<5;j++) {
                if (player.getShelves().getTilePosition(i, j).isOccupied()) {
                    System.out.println("Book size");
                    System.out.println(listOfBooks.size());
                    System.out.println("Cat size");
                    System.out.println(listOfCats.size());
                    System.out.println("Frame size");
                    System.out.println(listOfFrames.size());
                    System.out.println("Plant size");
                    System.out.println(listOfPlants.size());
                    System.out.println("Trophy size");
                    System.out.println(listOfTrophies.size());
                    System.out.println("Games size");
                    System.out.println(listOfGames.size());
                    System.out.println("Position: " + player.getShelves().getTilePosition(i, j).getX() + " " + player.getShelves().getTilePosition(i, j).getY());
                    System.out.println("Type: " + player.getShelves().getTilePosition(i, j).getTile().getType());
                    System.out.println("------");
                    TileType type = player.getShelves().getTilePosition(i, j).getTile().getType();
                    switch (type) {

                        case CAT -> {
                            listOfCats.add(player.getShelves().getTilePosition(i, j));
                            if (listOfCats.size() == 8) {
                                return true;
                            }
                        }
                        case BOOK -> {
                            listOfBooks.add(player.getShelves().getTilePosition(i, j));
                            if (listOfBooks.size() == 8) {
                                return true;
                            }
                        }
                        case FRAME -> {
                            listOfFrames.add(player.getShelves().getTilePosition(i, j));
                            if (listOfFrames.size() == 8) {
                                return true;
                            }
                        }
                        case PLANT -> {
                            listOfPlants.add(player.getShelves().getTilePosition(i, j));
                            if (listOfPlants.size() == 8) {
                                return true;
                            }
                        }
                        case TROPHY -> {
                            listOfTrophies.add(player.getShelves().getTilePosition(i, j));
                            if (listOfTrophies.size() == 8) {
                                return true;
                            }
                        }
                        case GAMES -> {
                            listOfGames.add(player.getShelves().getTilePosition(i, j));
                            if (listOfGames.size() == 8) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
