package org.example;

import org.example.Model.TileObj;
import org.example.Model.TileObjBag;
import org.example.Model.TileType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TileObjBagTest {

    private TileObjBag tileObjBag;

    @BeforeEach
    public void setUp() {
        tileObjBag = new TileObjBag();
    }

    @Test
    public void testExtractFromBag() {
        ArrayList<TileObj> extractedTiles = new ArrayList<>();
        for (int i = 0; i < 132; i++) {
            extractedTiles.add(tileObjBag.extractFromBag());
        }
        Assertions.assertEquals(132, extractedTiles.size());
        // verifica che ogni oggetto TileObj sia stato estratto correttamente dal sacchetto
        Assertions.assertTrue(extractedTiles.stream()
                .allMatch(tile -> TileType.values()[0].equals(tile.getType())
                        || TileType.values()[1].equals(tile.getType())
                        || TileType.values()[2].equals(tile.getType())
                        || TileType.values()[3].equals(tile.getType())
                        || TileType.values()[4].equals(tile.getType())
                        || TileType.values()[5].equals(tile.getType())));
    }

    @Test
    public void testShuffleT() {
        ArrayList<TileObj> initialTiles = new ArrayList<>();
        ArrayList<TileObj> shuffledTiles = new ArrayList<>();

        // estrai i primi 10 TileObj dal sacchetto non mischiato
        for (int i = 0; i < 10; i++) {
            initialTiles.add(tileObjBag.extractFromBag());
        }

        tileObjBag.shuffleT();

        // estrai i primi 10 TileObj dal sacchetto mischiato
        for (int i = 0; i < 10; i++) {
            shuffledTiles.add(tileObjBag.extractFromBag());
        }

        // verifica che i TileObj nei primi 10 elementi siano diversi tra sacchetto mischiato e sacchetto originale
        Assertions.assertFalse(initialTiles.equals(shuffledTiles));
    }
}