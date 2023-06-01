package org.test;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardXTest {

    @Test
    public void testExecuteAlgorithm() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));

        CommonCard commonCard = new CommonCardX(9);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create an X with the same tile type in your shelf");
    }

    @Test
    public void testExecuteAlgorithmFalse() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));

        CommonCard commonCard = new CommonCardX(9);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create an X with the same tile type in your shelf");
    }
}
