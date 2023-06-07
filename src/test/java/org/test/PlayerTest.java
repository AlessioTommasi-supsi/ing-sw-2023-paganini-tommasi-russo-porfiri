package org.test;

import com.google.gson.Gson;
import org.project.model.*;
import org.project.utils.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private PersonalCard personalCard;
    private Shelves shelves;
    private Set<TilePositionShelves> tilePositions;

    @Before
    public void setUp() {
        player = new Player("Egidio");
        shelves = new Shelves();
        tilePositions = new HashSet<>();
        tilePositions.add(new TilePositionShelves(1, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        tilePositions.add(new TilePositionShelves(2, 1, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        player.setShelves(shelves);
    }

    @After
    public void tearDown() {
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
    public void testSetScore() {
        player.setScore(20);
        assertEquals(20, player.getScore());
    }

    @Test
    public void testSetShelves() {
        Shelves newShelves = new Shelves();
        player.setShelves(newShelves);
        assertEquals(newShelves, player.getShelves());
    }

    @Test
    public void testCheckPersonalCard() throws PositionEmptyException {
        TileObj catTile = new TileObj(TileType.CAT, TileVariant.VARIANT_ONE);
        TileObj bookTile = new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO);
        shelves.addTile(new TilePositionShelves(1, 1, catTile));
        shelves.addTile(new TilePositionShelves(2, 2, bookTile));
        // TODO true value, personal card parser
        int counter = player.checkPersonalCard(personalCard);
        assertEquals(1, counter);
    }

    @Test
    public void testCheckPersonalCardException() {
        try {
            // TODO true value
            int counter = player.checkPersonalCard(personalCard);
            fail("Expected PositionEmptyException to be thrown.");
        } catch (PositionEmptyException e) {
            // Exception is expected
        }
    }

    @Test
    public void testAddEndOfGamePoint() {
        player.addEndOfGamePoint();
        assertEquals(1, player.getScore());
    }

    @Test
    public void testToString() {
        String expected = "Player{id=-1, username='Egidio', yourTurn=false, shelves=" + shelves.toString() + ", pC=null, score=0}";
        String actual = player.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculatePersonalPoints() throws Exception {
        // TODO personal card setup
        personalCard = new PersonalCard();
        player.setPC(personalCard);
        int points = player.calculatePersonalPoints();
        assertEquals(1, points);
    }

    @Test
    public void testCalculateAdjacentPointsNoAdjacency() {
        TileObj tile1 = new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE);
        TileObj tile2 = new TileObj(TileType.CAT, TileVariant.VARIANT_TWO);
        TileObj tile3 = new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE);
        TileObj tile4 = new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE);

        shelves.addTile(new TilePositionShelves(1, 1, tile1));
        shelves.addTile(new TilePositionShelves(3, 3, tile2));
        shelves.addTile(new TilePositionShelves(2, 1, tile3));
        shelves.addTile(new TilePositionShelves(4, 4, tile4));

        int points = player.calculateAdjacentPoints();
        assertEquals(0, points);
    }

    @Test
    public void testCalculateTotalPoints() {
        TileObj tile1 = new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE);
        TileObj tile2 = new TileObj(TileType.CAT, TileVariant.VARIANT_TWO);
        TileObj tile3 = new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE);
        TileObj tile4 = new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE);

        shelves.addTile(new TilePositionShelves(1, 1, tile1));
        shelves.addTile(new TilePositionShelves(1, 2, tile2));
        shelves.addTile(new TilePositionShelves(2, 1, tile3));
        shelves.addTile(new TilePositionShelves(2, 2, tile4));

        int points = 0;
        try {
            player.calcOverallScore();
            points = player.getScore();
        } catch (Exception e) {
            fail();
        }

        // TODO true points
        assertEquals(6, points);
    }

    @Test
    public void testCheckPersonalCardFalse() {
        ArrayList<PersonalCard> personalCardParsers = new ArrayList<>();
        try {
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));

            // convert a JSON string to a User object
            PersonalCard[] user = gson.fromJson(reader,PersonalCard[].class);

            personalCardParsers.add(user[0]);
            personalCardParsers.add(user[1]);
            personalCardParsers.add(user[2]);
            personalCardParsers.add(user[3]);
            personalCardParsers.add(user[4]);
            personalCardParsers.add(user[5]);
            personalCardParsers.add(user[6]);
            personalCardParsers.add(user[7]);
            personalCardParsers.add(user[8]);
            personalCardParsers.add(user[9]);
            personalCardParsers.add(user[10]);
            personalCardParsers.add(user[11]);

            // close reader
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        PersonalCard personalCardTest = personalCardParsers.get(0);
        Player player = new Player("Player1");
        int counterTilesPersonal = -1;
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        try {
            counterTilesPersonal = player.checkPersonalCard(personalCardTest);
        } catch (PositionEmptyException ex) {
            System.out.println("position null");
        }
        boolean returnCondition = false;
        if (counterTilesPersonal == 1) {returnCondition = true;}
        assertFalse(returnCondition);
    }

    @Test
    public void testCheckPersonalCardTrue() {
        ArrayList<PersonalCard> personalCardParsers = new ArrayList<>();
        try {
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));

            // convert a JSON string to a User object
            PersonalCard[] user = gson.fromJson(reader,PersonalCard[].class);

            personalCardParsers.add(user[0]);
            personalCardParsers.add(user[1]);
            personalCardParsers.add(user[2]);
            personalCardParsers.add(user[3]);
            personalCardParsers.add(user[4]);
            personalCardParsers.add(user[5]);
            personalCardParsers.add(user[6]);
            personalCardParsers.add(user[7]);
            personalCardParsers.add(user[8]);
            personalCardParsers.add(user[9]);
            personalCardParsers.add(user[10]);
            personalCardParsers.add(user[11]);

            // close reader
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        PersonalCard personalCardTest = personalCardParsers.get(0);
        Player player = new Player("Player1");
        int counterTilesPersonal = 0;
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        try {
            counterTilesPersonal = player.checkPersonalCard(personalCardTest);
        } catch (PositionEmptyException ex) {
            System.out.println("position null");
        }
        boolean returnCondition = false;
        if (counterTilesPersonal == 1) {returnCondition = true;}
        assertTrue(returnCondition);
    }

}