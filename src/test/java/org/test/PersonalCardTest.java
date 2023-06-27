package org.test;

import com.almasb.fxgl.core.collection.Array;
import com.almasb.fxgl.entity.level.tiled.Tile;
import com.google.gson.Gson;
import org.project.model.*;
import org.junit.jupiter.api.Test;
import org.project.utils.PositionAlreadyOccupiedException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PersonalCardTest {

    @Test
    public void testSetPositionShelves() {
        PersonalCard personalCard = new PersonalCard();
        TilePositionShelves[] tilePositionShelves = new TilePositionShelves[1];
        tilePositionShelves[0] = new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE));
        personalCard.setPositionShelves(tilePositionShelves);
        assertSame(personalCard.getPositionShelves()[0].getTile().getType(), tilePositionShelves[0].getTile().getType());
    }

    @Test
    public void testPoints() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setPoints(8);
        assertEquals(8, personalCard.getPoints());
    }

    @Test
    public void testCatXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setCatXPosition(0);
        assertEquals(0, personalCard.getCatXPosition());
    }

    @Test
    public void testCatYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setCatYPosition(0);
        assertEquals(0, personalCard.getCatYPosition());
    }

    @Test
    public void testBookXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setBookXPosition(0);
        assertEquals(0, personalCard.getBookXPosition());
    }

    @Test
    public void testBookYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setBookYPosition(0);
        assertEquals(0, personalCard.getBookYPosition());
    }

    @Test
    public void testTrophyXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setTrophyXPosition(0);
        assertEquals(0, personalCard.getTrophyXPosition());
    }

    @Test
    public void testTrophyYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setTrophyYPosition(0);
        assertEquals(0, personalCard.getTrophyYPosition());
    }

    @Test
    public void testPlantXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setPlantXPosition(0);
        assertEquals(0, personalCard.getPlantXPosition());
    }

    @Test
    public void testPlantYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setPlantYPosition(0);
        assertEquals(0, personalCard.getPlantYPosition());
    }

    @Test
    public void testGamesXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setGamesXPosition(0);
        assertEquals(0, personalCard.getGamesXPosition());
    }

    @Test
    public void testGamesYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setGamesYPosition(0);
        assertEquals(0, personalCard.getGamesYPosition());
    }

    @Test
    public void testFrameXPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setFrameXPosition(0);
        assertEquals(0, personalCard.getFrameXPosition());
    }

    @Test
    public void testFrameYPosition() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setFrameYPosition(0);
        assertEquals(0, personalCard.getFrameYPosition());
    }
}
