package org.test;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.project.model.*;
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

    private Game game;
    private Player player;
    private Player dealer;
    private PersonalCard personalCard;
    private Shelves shelves;

    Set<TilePositionShelves> tilePositions;

    @Before
    public void setUp() {
        dealer = new Player("Emidio");
        player = new Player("Egidio");
        game = new GameTwoPlayers(2, dealer);
        // Adding only one cc for testing purposes
        game.setCommon1(new CommonCardShape(5));
        // Adding only one player for testing purposes
        game.setCurrentPlayer(player);
        try {
            game.addPlayer(player);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<PersonalCard> personalCardParsers = new ArrayList<>();
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));
            PersonalCard[] parser = gson.fromJson(reader,PersonalCard[].class);
            personalCardParsers.add(parser[0]);
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        player.setPC(personalCardParsers.get(0));
        shelves = new Shelves();
        personalCard = new PersonalCard();

        player.setShelves(shelves);
        player.getShelves().addTile(new TilePositionShelves(1, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(2, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));

        player.getShelves().addTile(new TilePositionShelves(3, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(3, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(4, 1, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        player.setShelves(shelves);
    }

    @After
    public void tearDown() {
        player = null;
    }

    @Test
    public void testPutTile() {
        tilePositions = new HashSet<>();
        tilePositions.add(new TilePositionShelves(4, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_THREE)));
        player.putTile(tilePositions);
        Assertions.assertEquals(8, player.getShelves().getFilledCounter());
    }

    @Test
    public void testAddPoints() {
        player.addPoints(1);
        Assertions.assertEquals(1, player.getScore());
    }

    @Test
    public void testSetScore() {
        player.setScore(0);
        Assertions.assertEquals(0, player.getScore());
    }


    @Test
    public void testCheckPersonalCard() {
        int counter = player.checkPersonalCard(personalCard);
        // Assuming the pc isn't fully completed
        assertEquals(1, counter);
    }

    @Test
    public void testCheckCommonCard() {
        game.updatePointsCommon();
        Assertions.assertEquals(4, game.getPointCommonCard1());
    }

    @Test
    public void testAddEndOfGamePoint() {
        player.addEndOfGamePoint();
        assertEquals(9, player.getScore());
    }

    @Test
    public void testCalculatePersonalPoints() throws Exception {
        int points = player.calculatePersonalPoints();
        assertEquals(1, points);
    }

    // TODO aggiustare il punteggio totale
    @Test
    public void testCalculateTotalPoints() {
        // 1 end of game + 1 pc + 8 cc + 3
        int points = 0;
        try {
            player.calcOverallScore();
            points = player.getScore();
        } catch (Exception e) {
            fail();
        }

        Assertions.assertEquals(13, points);
    }

    /* @Test
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
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));
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
    } */
}