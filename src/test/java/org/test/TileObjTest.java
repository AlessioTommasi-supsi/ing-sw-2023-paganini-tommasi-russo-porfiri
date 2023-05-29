package org.test;

import org.example.Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TileObjTest {

    private TileObj tileObj;

    @Before
    public void setUp() {
        TileType type = TileType.BOOK;
        TileVariant variant = TileVariant.VARIANT_ONE;
        tileObj = new TileObj(type, variant);
    }

    @Test
    public void testGetType() {
        Assert.assertEquals(TileType.BOOK, tileObj.getType());
    }

    @Test
    public void testGetVariant() {
        Assert.assertEquals(TileVariant.VARIANT_ONE, tileObj.getVariant());
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
        String expected = "TileObj{type=B, variant=1}";
        Assert.assertEquals(expected, tileObj.toString());
    }
}
