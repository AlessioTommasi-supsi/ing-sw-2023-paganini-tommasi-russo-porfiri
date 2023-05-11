package org.example.Model;

import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

public class PersonalCard implements Serializable {
    private TilePositionShelves positionShelves[] ;
    private int points;

    public int CatXPosition;
    public int CatYPosition;
    public int BookXPosition;
    public int BookYPosition;
    public int FrameXPosition;
    public int FrameYPosition;
    public int TrophyXPosition;
    public int TrophyYPosition;
    public int GamesXPosition;
    public int GamesYPosition;
    public int PlantXPosition;
    public int PlantYPosition;

    public PersonalCard(int catXPosition, int catYPosition, int bookXPosition, int bookYPosition, int frameXPosition, int frameYPosition, int trophyXPosition, int trophyYPosition, int gamesXPosition, int gamesYPosition, int plantXPosition, int plantYPosition) {
        CatXPosition = catXPosition;
        CatYPosition = catYPosition;
        BookXPosition = bookXPosition;
        BookYPosition = bookYPosition;
        FrameXPosition = frameXPosition;
        FrameYPosition = frameYPosition;
        TrophyXPosition = trophyXPosition;
        TrophyYPosition = trophyYPosition;
        GamesXPosition = gamesXPosition;
        GamesYPosition = gamesYPosition;
        PlantXPosition = plantXPosition;
        PlantYPosition = plantYPosition;
    }


    /**
     * 
     */
    public void PersonalCard() {
        // TODO implement here
    }










}