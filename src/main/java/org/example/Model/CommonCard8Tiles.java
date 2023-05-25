package org.example.Model;

import java.util.ArrayList;

public class CommonCard8Tiles {

    public boolean check8Tiles(Player player) {

        ArrayList<TilePositionShelves> listOfCats = new ArrayList<TilePositionShelves>();
        ArrayList<TilePositionShelves> listOfBooks = new ArrayList<TilePositionShelves>();
        ArrayList<TilePositionShelves> listOfFrames = new ArrayList<TilePositionShelves>();
        ArrayList<TilePositionShelves> listOfGames = new ArrayList<TilePositionShelves>();
        ArrayList<TilePositionShelves> listOfPlants = new ArrayList<TilePositionShelves>();
        ArrayList<TilePositionShelves> listOfTrophies = new ArrayList<TilePositionShelves>();

        for(int i = 0; i < 6; i++) {
            for (int j=0;j<5;j++) {
                if (player.getShelves().getTilePosition(i, j) != null) {
                    switch (player.getShelves().getTilePosition(i, j).getTile().getType().toString()) {
                        case "CAT":
                            listOfCats.add(player.getShelves().getTilePosition(i, j));
                            if (listOfCats.size() == 8) {
                                return true;
                            }
                        case "BOOK":
                            listOfBooks.add(player.getShelves().getTilePosition(i, j));
                            if (listOfBooks.size() == 8) {
                                return true;
                            }
                        case "FRAME":
                            listOfFrames.add(player.getShelves().getTilePosition(i, j));
                            if (listOfFrames.size() == 8) {
                                return true;
                            }
                        case "PLANT":
                            listOfPlants.add(player.getShelves().getTilePosition(i, j));
                            if (listOfPlants.size() == 8) {
                                return true;
                            }
                        case "TROPHY":
                            listOfTrophies.add(player.getShelves().getTilePosition(i, j));
                            if (listOfTrophies.size() == 8) {
                                return true;
                            }
                        case "GAMES":
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
