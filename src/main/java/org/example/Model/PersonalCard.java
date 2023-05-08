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


/**
 * compra gioco fisico per mapparlo
 * (chiedi martedi a prof!!!!) se supponiamo posiz random o dobbiamo usare quelle del gioco fisico!!
 */
public class PersonalCard implements Serializable {
    private TilePositionShelves positionShelves[] ;
    private int points;
    /**
     * Default constructor
     */
    public PersonalCard(TilePositionShelves positionShelves[]) {
        this.points = 0;
        this.positionShelves = positionShelves;
    }

    /**
     * 
     */
    private int punti;

    /**
     * 
     */

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


    public void GsonParse(ArrayList<PersonalCardParser> personalCardParsers) {
        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));

            // convert a JSON string to a User object
            PersonalCardParser[] user = gson.fromJson(reader,PersonalCardParser[].class);

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

    private PersonalCardParser drawPersonal(Player player, ArrayList<PersonalCardParser> personalCards) {
        Random rand = new Random();
        int num = rand.nextInt(personalCards.size());
        PersonalCardParser personalCard = personalCards.get(num);
        personalCards.remove(num);
        return personalCard;
    }

    public int checkPersonalCard(PersonalCardParser personalCardParser, Player player) throws PositionEmptyException {
        int counter = 0;
        if ((player.getShelves().getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition).getTile().getType().equals("CAT"))) {
            counter++;
        }
        if ((player.getShelves().getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition).getTile().getType().equals("BOOK"))) {
            counter++;
        }
        if ((player.getShelves().getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition).getTile().getType().equals("FRAME"))) {
            counter++;
        }
        if ((player.getShelves().getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition).getTile().getType().equals("TROPHY"))) {
            counter++;
        }
        if ((player.getShelves().getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition).getTile().getType().equals("GAMES") )) {
            counter++;
        }
        if ((player.getShelves().getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition) != null) &&
                (player.getShelves().getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition).getTile().getType().equals("PLANT"))) {
            counter++;
        }
        return counter;
    }

}