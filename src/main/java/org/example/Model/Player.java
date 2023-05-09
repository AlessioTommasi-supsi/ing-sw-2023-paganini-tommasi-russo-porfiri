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
        int tilesCounter;
        int totalPoints = 0;
        boolean[][] visited = new boolean[6][5];

        // Scansione delle tessere nello Shelf
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if(visited[row][col] == true) {
                    continue;
                }
                tilesCounter = calculateGroupCounter(row, col, visited, 0, true, 0, shelves.tilePosition[row][col].tileInSlot.type);
                if (tilesCounter == 3) {
                    return 2;
                } else if (tilesCounter == 4) {
                    return 3;
                } else if (tilesCounter == 5) {
                    return 5;
                } else if (tilesCounter >= 6) {
                    return 8;
                } else {
                    return 0;
                }
            }
        }
    }

    private int calculateGroupCounter(int row, int col, boolean[][] visited, int counter, boolean starter, int totCounter, TileType prevType) {
        if (row < 0 || row >= 5 || col < 0 || col >= 6 || visited[row][col] || shelves.tilePositions[row][col].tileInSlot.type.equals(prevType)) {
            return counter;
        }

        visited[row][col] = true;
        counter ++;
        TileObj currTile = shelves[row][col];

        if (row - 1 >= 0 && shelves.tilePositions[row - 1][col] != null && shelves.tilePositions[row - 1][col].type.equals(currentTile.type)) {
            totCounter += calculateGroupScore(row - 1, col, visited, counter, false, totCounter, prevType);
        }
        if (row + 1 < shelf.length && shelves.tilePositions[row + 1][col] != null && shelves.tilePositions[row + 1][col].type.equals(currentTile.type)) {
            totCounter += calculateGroupScore(row + 1, col, visited, counter, false, totCounter, prevType);
        }
        if (col - 1 >= 0 && shelves.tilePositions[row][col - 1] != null && shelves.tilePositions[row][col - 1].type.equals(currentTile.type)) {
            totCounter += calculateGroupScore(row, col - 1, visited, counter, false, totCounter, prevType);
        }
        if (col + 1 < shelf[row].length && shelves.tilePositions[row][col + 1] != null && shelves.tilePositions[row][col + 1].type.equals(currentTile.type)) {
            totCounter += calculateGroupScore(row, col + 1, visited, counter, false, totCounter, prevType);
        }

        if (starter == true) {
            return totCounter;
        }
    }

    public void calcOverallScore() {
        this.score = calculateCommonPoints() + calculatePersonalPoints() + calculateAdjacentPoints();
    }

}