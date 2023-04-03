package org.example;

import org.example.Model.TileObj;
import org.example.Model.TilePositionBoard;
import org.example.Model.TileType;
import org.example.Model.TileVariant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class TilePositionBoardTest {

    private TilePositionBoard tilePositionBoard;
    private TileObj tile;

    @BeforeEach
    public void setUp() {
        tilePositionBoard = new TilePositionBoard(1, 2);
        tile = new TileObj(org.example.Model.TileType.CAT, TileVariant.VARIANT_ONE);
    }

    @Test
    public void testGetX() {
        Assertions.assertEquals(1, tilePositionBoard.getX());
    }

    @Test
    public void testGetY() {
        Assertions.assertEquals(2, tilePositionBoard.getY());
    }

    @Test
    public void testIsOccupied() {
        Assertions.assertFalse(tilePositionBoard.isOccupied());
        try {
            tilePositionBoard.setTile(tile);
        }
        catch (Exception e){
            fail();
        }
        Assertions.assertTrue(tilePositionBoard.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assertions.assertThrows(NullPointerException.class, () -> tilePositionBoard.getTile());
        try {
            tilePositionBoard.setTile(tile);
        }
        catch (Exception e){
            fail();
        }
        Assertions.assertEquals(tile, tilePositionBoard.getTile());
    }

    @Test
    public void testSetTile() throws Exception {
        Assertions.assertDoesNotThrow(() -> tilePositionBoard.setTile(tile));
        TileObj anotherTile = new TileObj(TileType.CAT, TileVariant.VARIANT_TWO);
        Assertions.assertThrows(Exception.class, () -> tilePositionBoard.setTile(anotherTile));
    }

    @Test
    public void testRemoveTile() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> tilePositionBoard.removeTile());
        tilePositionBoard.setTile(tile);
        TileObj removedTile = tilePositionBoard.removeTile();
        Assertions.assertEquals(tile, removedTile);
        Assertions.assertFalse(tilePositionBoard.isOccupied());
    }
}