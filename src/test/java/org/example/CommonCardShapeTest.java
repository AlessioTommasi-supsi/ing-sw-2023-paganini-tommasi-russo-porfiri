package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonCardShapeTest {

    @Test
    public void TestSmallRectangle() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,4, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.TROPHY, TileVariant.VARIANT_TWO)));

        CommonCard commonCard = new CommonCardShape(0);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to create 6 vertical rectangle formed of 2 tiles with the same type of tiles in your shelf ");
    }

    @Test
    public void TestLargeRectangle() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,1, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(3,2, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2,3, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3,3, new TileObj(TileType.PLANT, TileVariant.VARIANT_ONE)));

        CommonCard commonCard = new CommonCardShape(4);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to create 4 vertical rectangle formed of 4 tiles with the same type of tiles in your shelf");
    }

    @Test
    public void TestSquare() {
        Player player = new Player("Player1");

        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));

        CommonCard commonCard = new CommonCardShape(6);

        boolean result = commonCard.executeAlgorithm(player);
        assertTrue(result, "you have to create 2 squares formed of 4 tiles with the same type of tiles in your shelf");
    }
}
