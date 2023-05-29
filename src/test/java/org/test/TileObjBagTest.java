package org.test;

import org.example.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TileObjBagTest {

    private TileObjBag tileObjBag;

    @Before
    public void setUp() {
        tileObjBag = new TileObjBag();
    }

    @Test
    public void testDefaultConstructor() {
        ArrayList<TileObj> tiles = tileObjBag.getTiles();
        Assert.assertEquals(132, tiles.size());
    }

    @Test
    public void testCopyConstructor() {
        TileObjBag copyBag = new TileObjBag(tileObjBag);
        ArrayList<TileObj> originalTiles = tileObjBag.getTiles();
        ArrayList<TileObj> copyTiles = copyBag.getTiles();
        Assert.assertEquals(originalTiles.size(), copyTiles.size());
        Assert.assertEquals(originalTiles, copyTiles);
    }

    @Test
    public void testBagSize() {
        Assert.assertEquals(132, tileObjBag.BagSize());
    }

    @Test
    public void testShuffleT() {
        ArrayList<TileObj> originalTiles = tileObjBag.getTiles();
        tileObjBag.shuffleT();
        ArrayList<TileObj> shuffledTiles = tileObjBag.getTiles();
        Assert.assertNotEquals(originalTiles, shuffledTiles);
    }

    @Test
    public void testExtractFromBag() {
        int initialSize = tileObjBag.BagSize();
        TileObj extractedTile = tileObjBag.extractFromBag();
        Assert.assertNotNull(extractedTile);
        Assert.assertEquals(initialSize - 1, tileObjBag.BagSize());
    }
}