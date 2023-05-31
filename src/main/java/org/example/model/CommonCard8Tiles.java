package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCard8Tiles extends CommonCard implements Serializable {

    public CommonCard8Tiles(int index) {
        super(index, "check if 8 tiles of the same type are present in your shelf");
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
                    switch (player.getShelves().getTilePosition(i, j).getTile().getType().toString()) {
                        case "C":
                            listOfCats.add(player.getShelves().getTilePosition(i, j));
                            if (listOfCats.size() == 8) {
                                return true;
                            }
                        case "B":
                            listOfBooks.add(player.getShelves().getTilePosition(i, j));
                            if (listOfBooks.size() == 8) {
                                return true;
                            }
                        case "F":
                            listOfFrames.add(player.getShelves().getTilePosition(i, j));
                            if (listOfFrames.size() == 8) {
                                return true;
                            }
                        case "P":
                            listOfPlants.add(player.getShelves().getTilePosition(i, j));
                            if (listOfPlants.size() == 8) {
                                return true;
                            }
                        case "T":
                            listOfTrophies.add(player.getShelves().getTilePosition(i, j));
                            if (listOfTrophies.size() == 8) {
                                return true;
                            }
                        case "G":
                            listOfGames.add(player.getShelves().getTilePosition(i, j));
                            if (listOfGames.size() == 8) {
                                return true;
                            }
                    }
                }
            }
        }
        return false;
    }
}
