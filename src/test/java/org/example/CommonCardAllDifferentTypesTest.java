package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardAllDifferentTypesTest {

    @Test
    public void testExecuteAlgorithmHorizontal() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardAllDifferentTypes(7);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 2 rows with all different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVertical() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardAllDifferentTypes(5);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 2 columns with all different tile types in your shelf");
    }
}
