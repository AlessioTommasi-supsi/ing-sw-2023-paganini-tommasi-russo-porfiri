package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardDiagonalTest { /*da completare con altre diagonali*/

    @Test
    public void testExecuteAlgorithmDiagonalLeftFirst() {
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

    @Test
    public void testExecuteAlgorithmDiagonalLeftFalseFirst() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
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
        assertFalse(result, "you have to complete one of the possible diagonals with the same type of tiles");
    }

    @Test
    public void testExecuteAlgorithmDiagonalRightFirst() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0, 4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 3, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(3, 0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(4, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardDiagonal(1);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to complete one of the possible diagonals with the same type of tiles");
    }

    @Test
    public void testExecuteAlgorithmLeftSecond() {
        Player player = new Player("Player1");
        //first line
        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        //diagonal
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4,3, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(4,4, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(5,4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardDiagonal(1);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to complete one of the possible diagonals with the same type of tiles");
    }

    @Test
    public void testExecuteAlgorithmDiagonalRightSecond() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));

        player.getShelves().addTile(new TilePositionShelves(1, 4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1, 3, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2, 3, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(4, 0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(5, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardDiagonal(1);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to complete one of the possible diagonals with the same type of tiles");
    }
}
