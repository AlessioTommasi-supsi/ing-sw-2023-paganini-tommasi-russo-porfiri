package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionAlreadyOccupiedException;

import static org.junit.jupiter.api.Assertions.*;

public class CommonCard3TypesTest {

    @Test
    public void testExecuteAlgorithmHorizontal3Types() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,3, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));

        CommonCard commonCard = new CommonCard3Types(3);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 4 rows with a maximum of 3 different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmHorizontal3TypesFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(0,3, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,3, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(3,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));

        CommonCard commonCard = new CommonCard3Types(3);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create 4 rows with a maximum of 3 different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVertical3Types() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(3,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(5,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(4,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));

        CommonCard commonCard = new CommonCard3Types(8);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 3 columns with a maximum of 3 different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVertical3TypesFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(3,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(5,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(2,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(4,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO));
        player.getShelves().addTile(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(2,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE));
        player.getShelves().addTile(4,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE));

        CommonCard commonCard = new CommonCard3Types(8);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create 3 columns with a maximum of 3 different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmHorizontal() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));

        CommonCard commonCard = new CommonCard3Types(7);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 2 rows with all different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmHorizontalFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 4, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 3, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 4, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));


        CommonCard commonCard = new CommonCard3Types(7);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create 2 rows with all different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVertical() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(4, 0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5, 0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(4, 1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));


        CommonCard commonCard = new CommonCard3Types(5);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 2 columns with all different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVerticalFalse() throws PositionAlreadyOccupiedException {
        Player player = new Player("Player1");

        player.getShelves().addTile(0, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 0, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 0, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(4, 0, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5, 0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(0, 1, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(1, 1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(2, 1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(3, 1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(4, 1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE));
        player.getShelves().addTile(5, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));


        CommonCard commonCard = new CommonCard3Types(5);

        boolean result = commonCard.executeAlgorithm(player);
        assertFalse(result, "create 2 columns with all different tile types in your shelf");
    }
}
