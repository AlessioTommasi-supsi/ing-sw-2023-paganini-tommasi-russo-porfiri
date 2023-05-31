package org.test;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardDiagonalTest { /*da completare con altre diagonali*/

    @Test
    public void testExecuteAlgorithm() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(3,4, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(4,4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardDiagonal(1);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to complete one of the possible diagonals with the same type of tiles");
    }
}
