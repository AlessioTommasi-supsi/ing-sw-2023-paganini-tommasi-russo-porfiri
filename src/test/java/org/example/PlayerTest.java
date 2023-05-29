package org.example;


import org.example.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerTest {

    private Player player;
    private PersonalCard personalCard;
    private Shelves shelves;
    private Set<org.example.model.TilePositionShelves> tilePositions;

    @Before
    public void setUp() {
        player = new Player("Egidio");
        // personalCard = new PersonalCard(1, );

        shelves = new Shelves();
        tilePositions = new HashSet<org.example.model.TilePositionShelves>();
        tilePositions.add(new TilePositionShelves(1, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        tilePositions.add(new TilePositionShelves(2, 1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        // player.setPC(personalCard);


    }

    @After
    public void tearDown(){
        player = null;
    }

    @Test
    public void testPutTile() {
        player.putTile(tilePositions);
        assertEquals(2, player.getShelves().getFilledCounter());
    }

    @Test
    public void testAddPoints() {
        player.addPoints(10);
        assertEquals(10, player.getScore());
    }

    @Test
    public void testGetShelves() {
        assertNotNull(player.getShelves());
    }

    @Test
    public void testGetUsername() {
        assertEquals("Egidio", player.getUsername());
    }

    @Test
    public void testGetPC() {
        assertEquals(personalCard, player.getPC());
    }

    @Test
    public void testConstructor() {
        Player newPlayer = new Player(player);
        assertEquals(player.getId(), newPlayer.getId());
        assertEquals(player.getUsername(), newPlayer.getUsername());
        assertEquals(player.getTurn(), newPlayer.getTurn());
        assertEquals(player.getShelves(), newPlayer.getShelves());
        assertEquals(player.getPC(), newPlayer.getPC());
        assertEquals(player.getScore(), newPlayer.getScore());
    }
}
