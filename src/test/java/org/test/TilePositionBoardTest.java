package org.test;

import org.example.model.*;
import org.example.util.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TilePositionBoardTest {

    private TilePositionBoard tilePositionBoard;
    private TileObj tile;

    @Before
    public void setUp() {
        tilePositionBoard = new TilePositionBoard(1, 1);
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(1, tilePositionBoard.getX());
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(1, tilePositionBoard.getY());
    }

    @Test
    public void testIsOccupied() {
        Assert.assertFalse(tilePositionBoard.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assert.assertNull(tilePositionBoard.getTile());
    }

    @Test
    public void testSetTile() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
        tilePositionBoard.setTile(tile);
        Assert.assertTrue(tilePositionBoard.isOccupied());
        Assert.assertEquals(tile.getType(), tilePositionBoard.getTile().getType());
        Assert.assertEquals(tile.getVariant(), tilePositionBoard.getTile().getVariant());
    }

    @Test(expected = PositionAlreadyOccupiedException.class)
    public void testSetTile_ThrowsPositionAlreadyOccupiedException() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO);
        tilePositionBoard.setTile(tile);
        tilePositionBoard.setTile(new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
    }

    @Test
    public void testRemoveTile() throws PositionEmptyException, PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE);
        tilePositionBoard.setTile(tile);
        TileObj removedTile = tilePositionBoard.removeTile();
        Assert.assertFalse(tilePositionBoard.isOccupied());
        Assert.assertEquals(tile.getType(), removedTile.getType());
        Assert.assertEquals(tile.getVariant(), removedTile.getVariant());
        Assert.assertNull(tilePositionBoard.getTile());
    }

    @Test(expected = PositionEmptyException.class)
    public void testRemoveTile_ThrowsPositionEmptyException() throws PositionEmptyException {
        tilePositionBoard.removeTile();
    }

    @Test
    public void testEquals() {
        TilePositionBoard tilePositionBoard1 = new TilePositionBoard(1, 1);
        TilePositionBoard tilePositionBoard2 = new TilePositionBoard(1, 2);
        TilePositionBoard tilePositionBoard3 = new TilePositionBoard(2, 1);

        Assert.assertEquals(tilePositionBoard, tilePositionBoard1);
        Assert.assertNotEquals(tilePositionBoard, tilePositionBoard2);
        Assert.assertNotEquals(tilePositionBoard, tilePositionBoard3);
    }

    @Test
    public void testHashCode() {
        TilePositionBoard tilePositionBoard1 = new TilePositionBoard(1, 1);
        TilePositionBoard tilePositionBoard2 = new TilePositionBoard(1, 2);

        Assert.assertEquals(tilePositionBoard.hashCode(), tilePositionBoard1.hashCode());
        Assert.assertNotEquals(tilePositionBoard.hashCode(), tilePositionBoard2.hashCode());
    }


}