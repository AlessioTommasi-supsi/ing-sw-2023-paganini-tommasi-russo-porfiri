package org.example;

import org.example.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShelvesTest {

    private Shelves shelves;

    @Before
    public void setUp() {
        shelves = new Shelves();
    }

    @After
    public void tearDown() {
        shelves = null;
    }

    @Test
    public void testAddTile() {
        TileObj tObj = new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE);
        TilePositionShelves position = new TilePositionShelves(0, 0, tObj);
        shelves.addTile(position);
        assertEquals(position, shelves.getTilePosition(0,0));
        assertEquals(1, shelves.getFilledCounter());
    }

    @Test
    public void testIsFull() {
        assertFalse(shelves.isFull());
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 5; j++) {
                shelves.addTile(new TilePositionShelves(i, j, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
            }
        }
        assertTrue(shelves.isFull());
    }

    @Test
    public void testGetFilledCounter() {
        assertEquals(0, shelves.getFilledCounter());
        shelves.addTile(new TilePositionShelves(0, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        assertEquals(1, shelves.getFilledCounter());
    }

    @Test
    public void testDisplayShelves() {
        shelves.displayShelves();
    }

}
