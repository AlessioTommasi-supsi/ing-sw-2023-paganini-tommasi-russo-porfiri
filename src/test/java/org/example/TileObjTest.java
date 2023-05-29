package org.example;

import org.example.model.TileObj;
import org.example.model.TileType;
import org.example.model.TileVariant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

