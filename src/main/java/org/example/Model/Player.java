package org.example.Model;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {

    private int id;
    private String username;
    private boolean yourTurn;
    private Shelves shelves;
    private PersonalCard pC;
    private CommonCard commonCard1;
    private CommonCard commonCard2;
    private int score;
    private boolean isCommonCard1Completed = false;
    private boolean isCommonCard2Completed = false;

    public Player(Player p) {
        this.id = p.getId();
        this.username = p.getUsername();
        this.yourTurn = p.getTurn();
        this.shelves = p.getShelves();
        this.pC = p.getPC();
        this.score = p.getScore();
    }

    public Player(String username) {
        this.id = Globals.incrementPlayerId();
        this.username = username;
        this.yourTurn = false;
        this.shelves = new Shelves();
        this.pC = null;
        this.score = 0;
    }

    public boolean getIsCommonCard1Completed() {
        return isCommonCard1Completed;
    }

    public boolean getIsCommonCard2Completed() {
        return isCommonCard2Completed;
    }

    public PersonalCard getPC() {
        return pC;
    }

    public boolean getTurn() {
        return yourTurn;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public Shelves getShelves() {
        return shelves;
    }

    public Player(int id, String username) {
        this.id = id;
        this.username = username;
        this.yourTurn = false;
        this.shelves = new Shelves();
        this.pC = null;
    }

    public CommonCard getCommonCard1() {
        return commonCard1;
    }

    public CommonCard getCommonCard2() {
        return commonCard2;
    }

    // Da inserire nel costruttore se ritenuto necessario
    public void setPC(PersonalCard pc) {
        this.pC = pc;
    }

    public void putTile(Set<TilePositionShelves> pt) {
        for (TilePositionShelves p : pt) {
            shelves.addTile(p);
        }
    }

    public void addPoints(int add) {
        this.score += add;
    }

    public int getScore() {
        return score;
    }

    public void setShelves(Shelves shelves) {
        this.shelves = shelves;
    }

    private void addPointsPersonal(int counterCondition, int countPoints) {         //in base a quante condizioni si soddisfanno aggiungi tot punti
        if ((counterCondition == 1) || (counterCondition == 2)) {
            countPoints++;                                                  //incrementi dei valori scritti sulle personalCard, vanno chiamati solo quando viene aggiunta una condizione soddisfatta
        } else if ((counterCondition == 3) || (counterCondition == 4)) {
            countPoints = countPoints + 2;
        } else if ((counterCondition == 5) || (counterCondition == 6)) {
            countPoints = countPoints + 3;
        }
    }

    public void updatePoints(int counterConditionBefore, int counterConditionAfter, int countPoints) {
        if (counterConditionAfter == counterConditionBefore + 1) {             //controllo se il numero di condizioni è aumentato, se si aggiungo
            addPointsPersonal(counterConditionAfter, countPoints);
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yourTurn=" + yourTurn +
                ", shelves=" + shelves +
                ", pC=" + pC +
                ", score=" + score +
                '}';
    }

    public int calculateCommonPoints() {
        return -1;
    }

    public int calculatePersonalPoints() {
        //TODO
        //return pC.checkPersonalCard(new PersonalCardParser(), this);
        return -1;
    }

    public int calculateAdjacentPoints() {
        return -1;
    }

    public void calcOverallScore() {
        this.score = calculateCommonPoints() + calculatePersonalPoints() + calculateAdjacentPoints();
    }

}