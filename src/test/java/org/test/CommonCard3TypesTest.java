package org.test;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCard3TypesTest {

    @Test
    public void testExecuteAlgorithmHorizontal3Types() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2,3, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,4, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,2, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,4, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));

        CommonCard commonCard = new CommonCard3Types(3);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 4 rows with a maximum of 3 different tile types in your shelf");
    }

    @Test
    public void testExecuteAlgorithmVertical3Types() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(4,0, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(5,0, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(4,1, new TileObj(TileType.GAMES, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,1, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(2,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(4,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(5,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_THREE)));

        CommonCard commonCard = new CommonCard3Types(8);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 3 columns with a maximum of 3 different tile types in your shelf");
    }

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

        CommonCard commonCard = new CommonCard3Types(7);

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

        CommonCard commonCard = new CommonCard3Types(5);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "create 2 columns with all different tile types in your shelf");
    }
}
