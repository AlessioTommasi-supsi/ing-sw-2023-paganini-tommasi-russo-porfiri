package org.test;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionAlreadyOccupiedException;

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
    public void testAddTile() throws PositionAlreadyOccupiedException {
        int x = 0;
        int y = 0;
        TileObj tObj = new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE);

        shelves.addTile(0,0,tObj);

        assertEquals(tObj.getType(), shelves.getTilePosition(0,0).getTile().getType());
        assertEquals(tObj.getVariant(), shelves.getTilePosition(0,0).getTile().getVariant());
        assertTrue(shelves.getTilePosition(0,0).isOccupied());
        assertEquals(1, shelves.getFilledCounter());
    }

    @Test
    public void testIsFull() throws PositionAlreadyOccupiedException {
        assertFalse(shelves.isFull());
        for (int i = 0; i < 6; i++) {
            for(int j = 0; j < 5; j++) {
                shelves.addTile(i, j, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO));
            }
        }
        assertTrue(shelves.isFull());
    }

    @Test
    public void testGetFilledCounter() throws PositionAlreadyOccupiedException {
        assertEquals(0, shelves.getFilledCounter());
        shelves.addTile(0, 0, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));
        assertEquals(1, shelves.getFilledCounter());
    }

    @Test
    public void testDisplayShelves() {
        shelves.displayShelves();
    }

    @Test
    public void testShowShelf() {
        shelves.showShelves();
    }
}
