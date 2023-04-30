package org.example.Model;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;


/**
 * compra gioco fisico per mapparlo
 * (chiedi martedi a prof!!!!) se supponiamo posiz random o dobbiamo usare quelle del gioco fisico!!
 */
public class PersonalCard {
    private TilePositionShelves positionShelves[] ;
    private int points;
    /**
     * Default constructor
     */
    public PersonalCard(int points, TilePositionShelves positionShelves[]) {
        this.points = points;
        this.positionShelves = positionShelves;
    }

    /**
     * 
     */
    private int punti;

    /**
     * 
     */
    private PersonalObjective personalCardGoal;

    /**
     * @return
     */
    public void updatePunti() {
        // TODO implement here
    }

    /**
     * @return
     */
    private int getPunti() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void PersonalCard() {
        // TODO implement here
    }

    /**
     * @return
     */
    public PersonalObjective getGoal() {
        // TODO implement here
        return null;
    }

    public void GsonParse() {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));

            // convert a JSON string to a User object
            PersonalCardParser[] user = gson.fromJson(reader,PersonalCardParser[].class);

            ArrayList<PersonalCardParser> personalCardParsers = new ArrayList<PersonalCardParser>();
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

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int checkPersonalCard(PersonalCardParser personalCardParser, Shelves shelf) throws PositionEmptyException {
        int counter = 0;
        if ((shelf.getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition).getTile().getType().equals("CAT"))) {
            counter++;
        }
        if ((shelf.getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition).getTile().getType().equals("BOOK"))) {
            counter++;
        }
        if ((shelf.getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition).getTile().getType().equals("FRAME"))) {
            counter++;
        }
        if ((shelf.getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition).getTile().getType().equals("TROPHY"))) {
            counter++;
        }
        if ((shelf.getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition).getTile().getType().equals("GAMES") )) {
            counter++;
        }
        if ((shelf.getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition) != null) &&
                (shelf.getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition).getTile().getType().equals("PLANT"))) {
            counter++;
        }
        return counter;
    }

}