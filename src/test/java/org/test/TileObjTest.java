package org.test;

import org.example.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TileObjTest {

    private TileObj myTileObj;

    @Before
    public void setUp() {
        TileType type = TileType.BOOK;
        TileVariant variant = TileVariant.VARIANT_ONE;
        myTileObj = new TileObj(type, variant);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(TileType.BOOK, myTileObj.getType());
    }

    @Test
    public void testGetVariant() {
        Assert.assertEquals(TileVariant.VARIANT_ONE, myTileObj.getVariant());
    }

    public void testCopyConstructor() {
        TileType type = TileType.GAMES;
        TileVariant variant = TileVariant.VARIANT_TWO;
        TileObj originalTile = new TileObj(type, variant);
        TileObj copiedTile = new TileObj(originalTile);

        Assert.assertEquals(originalTile.getType(), copiedTile.getType());
        Assert.assertEquals(originalTile.getVariant(), copiedTile.getVariant());
    }

    @Test
    public void testToString() {
        String expected = " B 1";
        Assert.assertEquals(expected, myTileObj.toString());
    }
}
