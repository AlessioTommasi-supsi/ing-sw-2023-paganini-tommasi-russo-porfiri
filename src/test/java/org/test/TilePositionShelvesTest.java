package org.test;

import org.example.model.*;
import org.example.util.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TilePositionShelvesTest {

    private TilePositionShelves tilePositionShelves;
    private TileObj tile;

    @Before
    public void setUp() {
        tilePositionShelves = new TilePositionShelves(1, 1);
    }

    @Test
    public void testGetX() {
        Assert.assertEquals(1, tilePositionShelves.getX());
    }

    @Test
    public void testGetY() {
        Assert.assertEquals(1, tilePositionShelves.getY());
    }

    @Test
    public void testIsOccupied() {
        Assert.assertFalse(tilePositionShelves.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assert.assertNull(tilePositionShelves.getTile());
    }

    @Test
    public void testSetTile() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
        tilePositionShelves.setTile(tile);
        Assert.assertTrue(tilePositionShelves.isOccupied());
        Assert.assertEquals(tile.getType(), tilePositionShelves.getTile().getType());
        Assert.assertEquals(tile.getVariant(), tilePositionShelves.getTile().getVariant());
    }

    @Test(expected = PositionAlreadyOccupiedException.class)
    public void testSetTile_ThrowsPositionAlreadyOccupiedException() throws PositionAlreadyOccupiedException {
        tile = new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO);
        tilePositionShelves.setTile(tile);
        tilePositionShelves.setTile(new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
    }

}
