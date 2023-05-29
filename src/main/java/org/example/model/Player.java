package org.example.model;

import org.example.util.FullLibraryException;
import org.example.util.IllegalColumnException;
import org.example.util.IllegalSizeOfTilesException;
import org.example.util.PositionEmptyException;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {

    private int id;
    private String username;
    //USERNAME DEVE ESSERE UNIVOCO
    private boolean yourTurn;
    private Shelves shelves;
    private PersonalCard pC;
    private int score = 0;  //aggiornato ad ogni turno per quanto riguarda obiettivi comuni
    private boolean isCommonCard1Completed = false;
    private boolean isCommonCard2Completed = false;
    private int countCondition = 0;

    public Player(Player p) {
        this.id = p.getId();
        this.username = p.getUsername();
        this.yourTurn = p.getTurn();
        this.shelves = p.getShelves();
        this.pC = p.getPC();
        this.score = p.getScore();
    }

    public Player(String username) {
        //this.id = Globals.incrementPlayerId();//non puo funzionare dara sempre 1 perche ogni client esegue un nuovo programma!
        this.id = -1;// -1 e poi viene assegnato id giusto da controller non appena si fa join_game!

        this.username = username;
        this.yourTurn = false;
        this.shelves = new Shelves();
        //da modificare!!
        this.pC = null;
        this.score = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCommonCard1Completed() {
        return isCommonCard1Completed;
    }

    public boolean isCommonCard2Completed() {
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

    public Player(int id, String username, PersonalCard pC) {
        this.id = id;
        this.username = username;
        this.yourTurn = false;
        this.shelves = new Shelves();
        this.pC = pC;
    }

    // Da inserire nel costruttore se ritenuto necessario
    public void setPC(PersonalCard pc) {
        this.pC = pc;
    }

    public void setCommonCard1Completed(boolean commonCard1Completed) {
        isCommonCard1Completed = commonCard1Completed;
    }

    public void setCommonCard2Completed(boolean commonCard2Completed) {
        isCommonCard2Completed = commonCard2Completed;
    }


    public void putTile(Set<TilePositionShelves> pt) {
        for (TilePositionShelves p : pt) {
            shelves.addTile(p);
        }
    }

    public void addPoints(int add) {
        this.score += add;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setShelves(Shelves shelves) {
        this.shelves = shelves;
    }

    private int checkPersonalCard(PersonalCard personalCardParser) throws PositionEmptyException {
        int counter = 0;
        try {
            if ((getShelves().getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.CatXPosition, personalCardParser.CatYPosition).getTile().getType().equals("CAT"))) {
                counter++;
            }
            if ((getShelves().getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.BookXPosition, personalCardParser.BookYPosition).getTile().getType().equals("BOOK"))) {
                counter++;
            }
            if ((getShelves().getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.FrameXPosition, personalCardParser.FrameYPosition).getTile().getType().equals("FRAME"))) {
                counter++;
            }
            if ((getShelves().getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.TrophyXPosition, personalCardParser.TrophyYPosition).getTile().getType().equals("TROPHY"))) {
                counter++;
            }
            if ((getShelves().getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.GamesXPosition, personalCardParser.GamesYPosition).getTile().getType().equals("GAMES") )) {
                counter++;
            }
            if ((getShelves().getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition) != null) &&
                    (getShelves().getTilePosition(personalCardParser.PlantXPosition, personalCardParser.PlantYPosition).getTile().getType().equals("PLANT"))) {
                counter++;
            }
        }catch (Exception e){
            //si puo verificare quando in quella posizione della libreria e'vuota, in quel caso non devo dolo eseguire il prossimo if!
        }

        return counter;
    }

    public void add_end_of_game_point(){
        this.score+=1;
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

    // da qui in poi non funzionante

    /* non serve perche score aggiornato a ogni turno da Game!
    public int calculateCommonPoints(CommonCard cC) {
        //TODO implementare variabili e metodi per common card
        int points = cC.getPoints();
        if(points > 3) {
            updatePoints(points - 2);
            return points;
        }
        return 0;
    }
    */

    public int calculatePersonalPoints() throws Exception {
        int counter = 0;
        int pointAdded = 0;
        counter = this.checkPersonalCard(getPC());
        if (counter == 1) {
            pointAdded++;
        } else if (counter == 2) {
            pointAdded = 2;
        } else if (counter == 3) {
            pointAdded = 4;
        } else if (counter == 4) {
            pointAdded = 6;
        } else if (counter == 5) {
            pointAdded = 9;
        } else if (counter == 6) {
            pointAdded = 12;
        }
        return pointAdded;
        //return pC.checkPersonalCard(new PersonalCardParser(), this);
    }

    public int calculateAdjacentPoints() {
        int tilesCounter=0;
        int totalPoints = 0;
        boolean[][] visited = new boolean[6][5];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                visited[row][col] = false;
            }
        }

        // Scansione delle tessere nello Shelf
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if(visited[row][col] == true) {
                    continue;
                }
                try {
                    tilesCounter = calculateGroupCounter(row, col, visited, 0, true, 0, shelves.getTilePosition(row, col).getTile().getType());
                }catch (Exception e){//succede quando tessere in shelves vuote
                    continue;
                }

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

        return 0;
    }

    private int calculateGroupCounter(int row, int col, boolean[][] visited, int counter, boolean starter, int totCounter, TileType prevType) {
        if (row < 0 || row >= 5 || col < 0 || col >= 6 || visited[row][col] || !shelves.getTilePosition(row, col).getTile().getType().equals(prevType)) {
            return counter;
        }

        visited[row][col] = true;
        counter ++;

        TileObj currentTile;
        currentTile = this.shelves.getTilePosition(row, col).getTile();

        if (row - 1 >= 0 && this.shelves.getTilePosition(row - 1, col).getTile()!= null &&
                this.shelves.getTilePosition(row - 1, col).getTile().getType().equals(currentTile.getType()))
        {
            totCounter += calculateGroupCounter(row - 1, col, visited, counter, false, totCounter, prevType);
        }
        if (row + 1 < shelves.getMaxRows() && shelves.getTilePosition(row + 1, col).getTile() != null && shelves.getTilePosition(row + 1, col).getTile().getType().equals(currentTile.getType())) {
            totCounter += calculateGroupCounter(row + 1, col, visited, counter, false, totCounter, prevType);
        }
        if (col - 1 >= 0 && shelves.getTilePosition(row, col-1).getTile() != null && shelves.getTilePosition(row, col-1).getTile().getType().equals(currentTile.getType())) {
            totCounter += calculateGroupCounter(row, col - 1, visited, counter, false, totCounter, prevType);
        }
        if (col + 1 < shelves.getMaxColums() && shelves.getTilePosition(row, col+1).getTile() != null && shelves.getTilePosition(row, col+1).getTile().getType().equals(currentTile.getType())) {
            totCounter += calculateGroupCounter(row, col + 1, visited, counter, false, totCounter, prevType);
        }

        if (starter == true) {
            return totCounter;
        }
        return  0;
    }


    //da chiamato in Game::end()!
    public void calcOverallScore() throws Exception {
        this.score +=  calculatePersonalPoints() + calculateAdjacentPoints();
    }

    // manca un put_tyle in shelves che accetta solo la colonna in cui io devo aggiungere le tiles!
    // qualcosa che avevamo detto essere gravitY?
    public void putTilesInShelf(ArrayList<TileObj> tilesToPut, int col, int ordine[]) throws Exception {
        /*TODO!
        * ricorda genera eccezione
        * se non riesce a mettere le tiles
            -> libreria piena, in questa colonna non ci possono stare quel numero di tiles   IllegalSizeOfTilesException
            -> colonna non giusta   IllegalColumnException
        * se riesce a mettere le tiles
        *   con le tiles immesse la libreria  diventa piena     FullLibraryException
        * */

        ArrayList<TileObj> orderedTilesToRemove = new ArrayList<TileObj>();
        //ordinamento per immissione in libreria
        for (int i = 0; i < tilesToPut.size(); i++) {
            orderedTilesToRemove.add(tilesToPut.get(ordine[i] - 1));
        }

        tilesToPut = orderedTilesToRemove;

        int countTilesInColumn = 0;
        for(int i = 0; i < 6;i++) {
            if (shelves.getTilePosition(col, i).getTile() != null) {
                countTilesInColumn++;
            } else {
                break;
            }
        }

        //.DEBUG
        //System.out.println("countTilesInColumn: " + countTilesInColumn + " col: " + col);
        //for(int i = 0; i < tilesToPut.size();i++) {
        //    System.out.println("tile: " + tilesToPut.get(i));
        //}

        if((col > 4)  || (col < 0))
            throw new IllegalColumnException();
        if(tilesToPut.size() > shelves.getMaxRows() - countTilesInColumn)
            throw new IllegalSizeOfTilesException(tilesToPut.size());

        for(int j = 0; j < tilesToPut.size();j++) {
            shelves.getTilePosition(col,countTilesInColumn).setTile(tilesToPut.get(j));
            countTilesInColumn++;
        }
        if (shelves.getFilledCounter() == 30) throw new FullLibraryException();
    }
}























