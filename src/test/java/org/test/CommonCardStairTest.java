package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionAlreadyOccupiedException;

import static org.junit.jupiter.api.Assertions.*;

public class CommonCardStairTest {

    @Test
    public void testExecuteAlgorithmLeftStair() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0, 3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0, 4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 4, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(3, 4, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(4, 4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));

        CommonCard commonCard = new CommonCardStair(11);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "check if the tiles on your shelf are in stair form");
    }

    @Test
    public void testExecuteAlgorithmLeftStairFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0, 3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0, 4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 4, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(3, 4, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE));

        CommonCard commonCard = new CommonCardStair(11);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "check if the tiles on your shelf are in stair form");
    }

    @Test
    public void testExecuteAlgorithmRightStairFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 3, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE));

        CommonCard commonCard = new CommonCardStair(11);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "check if the tiles on your shelf are in stair form");
    }

    @Test
    public void testExecuteAlgorithmRightStair() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(1, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1, 3, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE));

        CommonCard commonCard = new CommonCardStair(11);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "check if the tiles on your shelf are in stair form");
    }


}
