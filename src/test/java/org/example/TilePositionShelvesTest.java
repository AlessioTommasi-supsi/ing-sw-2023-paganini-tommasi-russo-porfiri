package org.example;

import org.example.Model.TileObj;
import org.example.Model.TilePositionShelves;
import org.example.Model.TileType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;

import static org.junit.Assert.*;

public class TilePositionShelvesTest {

    private TilePositionShelves tilePosition;

    @Before
    public void setUp() {
        tilePosition = new TilePositionShelves(1, 2);
    }

    @After
    public void tearDown() {
        tilePosition = null;
    }

    @Test
    public void testGetX() {
        assertEquals(1, tilePosition.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(2, tilePosition.getY());
    }

    @Test
    public void testIsOccupied() throws Exception {
        assertFalse(tilePosition.isOccupied());
        tilePosition.setTile(new TileObj(TileType.CAT));
        assertTrue(tilePosition.isOccupied());
    }

    @Test
    public void testGetTile() throws Exception {
        assertNull(tilePosition.getTile());
        tilePosition.setTile(new TileObj(TileType.CAT));
        assertNotNull(tilePosition.getTile());
        assertEquals(TileType.CAT, tilePosition.getTile().getType());
    }

    @Test
    public void testSetTile() throws Exception {
        assertNull(tilePosition.getTile());
        TileObj tile = new TileObj(TileType.TROPHY);
        tilePosition.setTile(tile);
        assertNotNull(tilePosition.getTile());
        assertEquals(TileType.TROPHY, tilePosition.getTile().getType());
    }
}
