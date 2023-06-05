package org.test;

import org.project.model.*;
import org.project.util.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TilePositionShelvesTest {

    private TilePositionShelves myTilePositionShelves;
    private TileObj tile;

    @Before
    public void setUp() {
        myTilePositionShelves = new TilePositionShelves(1, 1);
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(1, myTilePositionShelves.getX());
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(1, myTilePositionShelves.getY());
    }

    @Test
    public void testIsOccupied() {
        Assert.assertFalse(myTilePositionShelves.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assert.assertNull(myTilePositionShelves.getTile());
    }

    @Test
    public void testSetTile() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
        myTilePositionShelves.setTile(tile);
        Assert.assertTrue(myTilePositionShelves.isOccupied());
        Assert.assertEquals(tile.getType(), myTilePositionShelves.getTile().getType());
        Assert.assertEquals(tile.getVariant(), myTilePositionShelves.getTile().getVariant());
    }

    @Test(expected = PositionAlreadyOccupiedException.class)
    public void testSetTile_ThrowsPositionAlreadyOccupiedException() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO);
        myTilePositionShelves.setTile(tile);
        myTilePositionShelves.setTile(new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
    }

    @Test
    public void testSecondConstructor(){
        int localX = 3;
        int localY = 4;
        TileObj localTile = new TileObj(TileType.CAT, TileVariant.VARIANT_THREE);
        TilePositionShelves tempBoard = new TilePositionShelves(localX, localY, localTile);
        Assert.assertEquals(tempBoard.getX(), localX);
        Assert.assertEquals(tempBoard.getY(), localY);
        Assert.assertEquals(tempBoard.getTile().getType(), localTile.getType());
        Assert.assertEquals(tempBoard.getTile().getVariant(), localTile.getVariant());
        Assert.assertTrue(tempBoard.isOccupied());
    }

    @Test
    public void testThirdConstructor() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO);
        myTilePositionShelves.setTile(tile);
        TilePositionShelves localPosition = new TilePositionShelves(myTilePositionShelves);
        Assert.assertEquals(localPosition.getX(), myTilePositionShelves.getX());
        Assert.assertEquals(localPosition.getY(), myTilePositionShelves.getY());
        Assert.assertEquals(localPosition.getTile().getType(), myTilePositionShelves.getTile().getType());
        Assert.assertEquals(localPosition.getTile().getVariant(), myTilePositionShelves.getTile().getVariant());
        Assert.assertTrue(localPosition.isOccupied());
    }

}
