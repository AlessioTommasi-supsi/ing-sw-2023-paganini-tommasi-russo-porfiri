package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileObj;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileType;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.TileVariant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
  public class TileObjTest {

        private TileType type;
        private TileVariant variant;
        private TileObj tile;

        @BeforeEach
        public void setUp() {
            type = TileType.CAT;
            variant = TileVariant.VARIANT_ONE;
            tile = new TileObj(type, variant);
        }

        @Test
        public void testGetType() {
            Assertions.assertEquals(type, tile.getType());
        }

        @Test
        public void testGetVariant() {
            Assertions.assertEquals(variant, tile.getVariant());
        }
    }

