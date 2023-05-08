package org.example.Model;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {

    private int id;
    private String username;
    private boolean yourTurn;
    private Shelves shelves;
    private PersonalCard pC;
    private int score;

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

    public int calculateCommonPoints(CommonCard cC) {
        //TODO implementare variabili e metodi per common card
        int points = cC.getPoints();
        if(points > 3) {
            cC.updatePoints(points - 2);
            return points;
        }
        return 0;
    }

    public int calculatePersonalPoints() {
        //TODO funzionamento del parser?
        return pC.checkPersonalCard(new PersonalCardParser(), this);
    }

    public int calculateAdjacentPoints() {
        int counter;
        boolean stopCycle;
        List<Integer> validGroups = new ArrayList<>();
        TileObj prevTile = null;

        for (int i = 0; i < 6; i++) {
            counter = 0;
            stopCycle = false;

            for (int j = 0; j < 5 && !stopCycle; j++) {
                if (!Shelves.TilePositionShelves[i][j].occupied) {
                    continue;
                } else if (counter == 0) {
                    prevTile = Shelves.TilePositionShelves[i][j].TileObj;
                    counter++;
                    continue;
                }

                if (Shelves.TilePositionShelves[i][j].TileObj.type.equals(prevTile.type)) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter > 0) {
                    validGroups.add(counter);
                }
            }
        }

        //TODO La parte del calcolo punteggio. Verificare fattibilità algoritmo
    }

    public void calcOverallScore() {
        this.score = calculateCommonPoints() + calculatePersonalPoints() + calculateAdjacentPoints();
    }

}