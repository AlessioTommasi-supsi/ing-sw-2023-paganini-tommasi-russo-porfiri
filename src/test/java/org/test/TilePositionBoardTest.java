package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TilePositionBoardTest {

    private TilePositionBoard myTilePositionBoard;
    private TileObj tile;

    @Before
    public void setUp() {
        myTilePositionBoard = new TilePositionBoard(1, 1);
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(1, myTilePositionBoard.getX());
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(1, myTilePositionBoard.getY());
    }

    @Test
    public void testIsOccupied() {
        Assert.assertFalse(myTilePositionBoard.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assert.assertNull(myTilePositionBoard.getTile());
    }

    @Test
    public void testSetTile() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
        myTilePositionBoard.setTile(tile);
        Assert.assertTrue(myTilePositionBoard.isOccupied());
        Assert.assertEquals(tile.getType(), myTilePositionBoard.getTile().getType());
        Assert.assertEquals(tile.getVariant(), myTilePositionBoard.getTile().getVariant());
    }

    @Test(expected = PositionAlreadyOccupiedException.class)
    public void testSetTile_ThrowsPositionAlreadyOccupiedException() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO);
        myTilePositionBoard.setTile(tile);
        myTilePositionBoard.setTile(new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
    }

    @Test
    public void testRemoveTile() throws PositionEmptyException, PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.FRAME, TileVariant.VARIANT_ONE);
        myTilePositionBoard.setTile(tile);
        TileObj removedTile = myTilePositionBoard.removeTile();
        Assert.assertFalse(myTilePositionBoard.isOccupied());
        Assert.assertEquals(tile.getType(), removedTile.getType());
        Assert.assertEquals(tile.getVariant(), removedTile.getVariant());
        Assert.assertNull(myTilePositionBoard.getTile());
    }

    @Test(expected = PositionEmptyException.class)
    public void testRemoveTile_ThrowsPositionEmptyException() throws PositionEmptyException {
        myTilePositionBoard.removeTile();
    }

    @Test
    public void testEquals() {
        TilePositionBoard tilePositionBoard1 = new TilePositionBoard(1, 1);
        TilePositionBoard tilePositionBoard2 = new TilePositionBoard(1, 2);
        TilePositionBoard tilePositionBoard3 = new TilePositionBoard(2, 1);

        Assert.assertEquals(myTilePositionBoard, tilePositionBoard1);
        Assert.assertNotEquals(myTilePositionBoard, tilePositionBoard2);
        Assert.assertNotEquals(myTilePositionBoard, tilePositionBoard3);
    }

    @Test
    public void testHashCode() {
        TilePositionBoard tilePositionBoard1 = new TilePositionBoard(1, 1);
        TilePositionBoard tilePositionBoard2 = new TilePositionBoard(1, 2);

        Assert.assertEquals(myTilePositionBoard.hashCode(), tilePositionBoard1.hashCode());
        Assert.assertNotEquals(myTilePositionBoard.hashCode(), tilePositionBoard2.hashCode());
    }

    @Test
    public void testSecondConstructor(){
        int localX = 3;
        int localY = 4;
        TileObj localTile = new TileObj(TileType.CAT, TileVariant.VARIANT_THREE);
        TilePositionBoard tempBoard = new TilePositionBoard(localX, localY, localTile);
        Assert.assertEquals(tempBoard.getX(), localX);
        Assert.assertEquals(tempBoard.getY(), localY);
        Assert.assertEquals(tempBoard.getTile().getType(), localTile.getType());
        Assert.assertEquals(tempBoard.getTile().getVariant(), localTile.getVariant());
        Assert.assertTrue(tempBoard.isOccupied());
    }

    @Test
    public void testThirdConstructor() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO);
        myTilePositionBoard.setTile(tile);
        TilePositionBoard localPosition = new TilePositionBoard(myTilePositionBoard);
        Assert.assertEquals(localPosition.getX(), myTilePositionBoard.getX());
        Assert.assertEquals(localPosition.getY(), myTilePositionBoard.getY());
        Assert.assertEquals(localPosition.getTile().getType(), myTilePositionBoard.getTile().getType());
        Assert.assertEquals(localPosition.getTile().getVariant(), myTilePositionBoard.getTile().getVariant());
        Assert.assertTrue(localPosition.isOccupied());
    }

    @Test
    public void testIsMe() {
        int localX = 3;
        int localY = 4;
        TileObj localTile = new TileObj(TileType.CAT, TileVariant.VARIANT_THREE);
        TilePositionBoard tempBoard = new TilePositionBoard(localX, localY, localTile);
        tempBoard.isMe(3, 4);
    }


}