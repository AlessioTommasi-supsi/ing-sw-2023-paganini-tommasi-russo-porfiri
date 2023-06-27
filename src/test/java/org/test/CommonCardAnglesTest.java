package org.test;

import org.project.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardAnglesTest {

    @Test
    public void testExecuteAlgorithm() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));

        CommonCard commonCard = new CommonCardAngles(2);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "check if angles in your shelf are present and with the same type of tiles");
    }

    @Test
    public void testExecuteAlgorithmFalse() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));

        CommonCard commonCard = new CommonCardAngles(2);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "check if angles in your shelf are present and with the same type of tiles");
    }
}