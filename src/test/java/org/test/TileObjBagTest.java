package org.test;

import org.example.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TileObjBagTest {

    private TileObjBag myTileObjBag;

    @Before
    public void setUp() {
        myTileObjBag = new TileObjBag();
    }

    @Test
    public void testDefaultConstructor() {
        ArrayList<TileObj> tiles = myTileObjBag.getTiles();
        Assert.assertEquals(132, tiles.size());
    }

    @Test
    public void testCopyConstructor() {
        TileObjBag copyBag = new TileObjBag(myTileObjBag);
        ArrayList<TileObj> originalTiles = myTileObjBag.getTiles();
        ArrayList<TileObj> copyTiles = copyBag.getTiles();
        Assert.assertEquals(originalTiles.size(), copyTiles.size());
        for(int i=0; i< originalTiles.size(); i++){
            Assert.assertEquals(originalTiles.get(i).getType(), copyTiles.get(i).getType());
            Assert.assertEquals(originalTiles.get(i).getVariant(), copyTiles.get(i).getVariant());
        }
    }

    @Test
    public void testBagSize() {
        Assert.assertEquals(132, myTileObjBag.BagSize());
    }

    @Test
    public void testShuffleT() {
        ArrayList<TileObj> originalTiles = myTileObjBag.getTiles();
        myTileObjBag.shuffleT();
        ArrayList<TileObj> shuffledTiles = myTileObjBag.getTiles();
        Assert.assertNotEquals(originalTiles, shuffledTiles);
    }

    @Test
    public void testExtractFromBag() {
        int initialSize = myTileObjBag.BagSize();
        TileObj extractedTile = myTileObjBag.extractFromBag();
        Assert.assertNotNull(extractedTile);
        Assert.assertEquals(initialSize - 1, myTileObjBag.BagSize());
    }
}