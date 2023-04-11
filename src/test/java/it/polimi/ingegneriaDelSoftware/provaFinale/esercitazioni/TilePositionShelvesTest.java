package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileObj;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TilePositionShelves;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileType;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileVariant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TilePositionShelvesTest {

    private TilePositionShelves tilePositionShelves;
    private TileObj tile;

    @BeforeEach
    public void setUp() {
        tilePositionShelves = new TilePositionShelves(1, 2);
        tile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
    }

    @Test
    public void testGetX() {
        Assertions.assertEquals(1, tilePositionShelves.getX());
    }

    @Test
    public void testGetY() {
        Assertions.assertEquals(2, tilePositionShelves.getY());
    }

    @Test
    public void testIsOccupied() {
        Assertions.assertFalse(tilePositionShelves.isOccupied());
        try {
            tilePositionShelves.setTile(tile);
        }
        catch (Exception e){
            //fail();
        }
        Assertions.assertTrue(tilePositionShelves.isOccupied());
    }

    @Test
    public void testGetTile() {
        Assertions.assertThrows(NullPointerException.class, () -> tilePositionShelves.getTile());
        try {
            tilePositionShelves.setTile(tile);
        }
        catch (Exception e){
            //fail();
        }
        Assertions.assertEquals(tile, tilePositionShelves.getTile());
    }

    @Test
    public void testSetTile() throws Exception {
        Assertions.assertDoesNotThrow(() -> tilePositionShelves.setTile(tile));
        TileObj anotherTile = new TileObj(TileType.CAT, TileVariant.VARIANT_TWO);
        Assertions.assertThrows(Exception.class, () -> tilePositionShelves.setTile(anotherTile));
    }
}