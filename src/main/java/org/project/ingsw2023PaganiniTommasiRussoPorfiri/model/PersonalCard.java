package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import java.io.Serializable;

public class PersonalCard implements Serializable {
    public TilePositionShelves positionShelves[] ;
    private int points;
    public int PersonalCardNumber;
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


    public PersonalCard() {
    }

    public void setPositionShelves(TilePositionShelves[] positionShelves) {
        this.positionShelves = positionShelves;
    }

    public int getPersonalCardNumber() {
        return PersonalCardNumber;
    }

    public void setPersonalCardNumber(int personalCardNumber) {
        PersonalCardNumber = personalCardNumber;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCatXPosition(int catXPosition) {
        CatXPosition = catXPosition;
    }

    public void setCatYPosition(int catYPosition) {
        CatYPosition = catYPosition;
    }

    public void setBookXPosition(int bookXPosition) {
        BookXPosition = bookXPosition;
    }

    public void setBookYPosition(int bookYPosition) {
        BookYPosition = bookYPosition;
    }

    public void setFrameXPosition(int frameXPosition) {
        FrameXPosition = frameXPosition;
    }

    public void setFrameYPosition(int frameYPosition) {
        FrameYPosition = frameYPosition;
    }

    public void setTrophyXPosition(int trophyXPosition) {
        TrophyXPosition = trophyXPosition;
    }

    public void setTrophyYPosition(int trophyYPosition) {
        TrophyYPosition = trophyYPosition;
    }

    public void setGamesXPosition(int gamesXPosition) {
        GamesXPosition = gamesXPosition;
    }

    public void setGamesYPosition(int gamesYPosition) {
        GamesYPosition = gamesYPosition;
    }

    public void setPlantXPosition(int plantXPosition) {
        PlantXPosition = plantXPosition;
    }

    public void setPlantYPosition(int plantYPosition) {
        PlantYPosition = plantYPosition;
    }

    public TilePositionShelves[] getPositionShelves() {
        return positionShelves;
    }

    public int getPoints() {
        return points;
    }

    public int getCatXPosition() {
        return CatXPosition;
    }

    public int getCatYPosition() {
        return CatYPosition;
    }

    public int getBookXPosition() {
        return BookXPosition;
    }

    public int getBookYPosition() {
        return BookYPosition;
    }

    public int getFrameXPosition() {
        return FrameXPosition;
    }

    public int getFrameYPosition() {
        return FrameYPosition;
    }

    public int getTrophyXPosition() {
        return TrophyXPosition;
    }

    public int getTrophyYPosition() {
        return TrophyYPosition;
    }

    public int getGamesXPosition() {
        return GamesXPosition;
    }

    public int getGamesYPosition() {
        return GamesYPosition;
    }

    public int getPlantXPosition() {
        return PlantXPosition;
    }

    public int getPlantYPosition() {
        return PlantYPosition;
    }


    @Override
    public String toString() {
        return "PersonalCard{\n" +
                " PersonalCardNumber =" + PersonalCardNumber +
                " CatXPosition =" + CatXPosition +
                ", CatYPosition =" + CatYPosition +
                ", BookXPosition =" + BookXPosition +
                ", BookYPosition =" + BookYPosition +
                ", FrameXPosition =" + FrameXPosition +
                ", FrameYPosition =" + FrameYPosition +
                ", TrophyXPosition =" + TrophyXPosition +
                ", TrophyYPosition =" + TrophyYPosition +
                ", GamesXPosition =" + GamesXPosition +
                ", GamesYPosition =" + GamesYPosition +
                ", PlantXPosition =" + PlantXPosition +
                ", PlantYPosition =" + PlantYPosition +
                 "\n}";
    }
}