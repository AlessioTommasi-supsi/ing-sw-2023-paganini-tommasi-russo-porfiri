package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionAlreadyOccupiedException;

import static org.junit.jupiter.api.Assertions.*;

public class CommonCardXTest {

    @Test
    public void testExecuteAlgorithm() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));


        CommonCard commonCard = new CommonCardX(9);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create an X with the same tile type in your shelf");
    }

    @Test
    public void testExecuteAlgorithmFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));

        CommonCard commonCard = new CommonCardX(9);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create an X with the same tile type in your shelf");
    }
}
