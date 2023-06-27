package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCard8TilesTest {

    @Test
    public void testExecuteAlgorithm() {
        // Create a player object
        Player player = new Player("Player1");

        // Create a shelves object and add tiles to it
        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        // Add some other tiles to test the algorithm
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));

        // Set the shelves object for the player

        // Create an instance of CommonCard8Tiles
        CommonCard commonCard = new CommonCard8Tiles(10);

        // Execute the algorithm and check the result
        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "8 tiles of the same type should be present");
    }

    @Test
    public void testExecuteAlgorithmFalse() {
        // Create a player object
        Player player = new Player("Player1");

        // Create a shelves object and add tiles to it
        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        // Add some other tiles to test the algorithm
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));

        // Set the shelves object for the player

        // Create an instance of CommonCard8Tiles
        CommonCard commonCard = new CommonCard8Tiles(10);

        // Execute the algorithm and check the result
        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "8 tiles of the same type should be present");
    }
}
