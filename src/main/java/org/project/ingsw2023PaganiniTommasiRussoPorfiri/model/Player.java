package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.FullLibraryException;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.IllegalColumnException;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.IllegalSizeOfTilesException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Player implements Serializable {

    private int id;
    private String username;
    //USERNAME DEVE ESSERE UNIVOCO
    private boolean yourTurn;
    private Shelves shelves;
    private PersonalCard pC;
    private int score = 0;  //aggiornato a ogni turno per quanto riguarda obiettivi comuni
    private boolean isCommonCard1Completed = false;
    private boolean isCommonCard2Completed = false;
    private HashMap<Integer, Integer> givenAdjacencyPoints = new HashMap<>();

    public Player(Player p) {
        this.id = p.getId();
        this.username = p.getUsername();
        this.yourTurn = p.getTurn();
        this.shelves = p.getShelves();
        this.pC = p.getPC();
        this.score = p.getScore();
        defineAdjacencyPoints();
    }

    public Player(String username) {
        //this.id = Globals.incrementPlayerId();//non puo funzionare dara sempre 1 perché ogni client esegue un nuovo programma!
        this.id = -1;// -1 e poi viene assegnato id giusto da controller non appena si fa join_game!
        this.username = username;
        this.yourTurn = false;
        this.shelves = new Shelves();
        this.pC = null;
        this.score = 0;
        defineAdjacencyPoints();
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
        defineAdjacencyPoints();
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

    public void defineAdjacencyPoints() {
        // Inizializzazione dell'HashMap con le associazioni tra counter e punti
        givenAdjacencyPoints.put(3, 2);
        givenAdjacencyPoints.put(4, 3);
        givenAdjacencyPoints.put(5, 5);
        givenAdjacencyPoints.put(6, 8);
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

    public int checkPersonalCard(PersonalCard myPersonalCard) {
        int counter = 0;
        try {
            if ((getShelves().getTilePosition(myPersonalCard.CatXPosition, myPersonalCard.CatYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.CatXPosition, myPersonalCard.CatYPosition).getTile().getType() == TileType.CAT)) {
                counter++;
            }
            if ((getShelves().getTilePosition(myPersonalCard.BookXPosition, myPersonalCard.BookYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.BookXPosition, myPersonalCard.BookYPosition).getTile().getType() == TileType.BOOK)) {
                counter++;
            }
            if ((getShelves().getTilePosition(myPersonalCard.FrameXPosition, myPersonalCard.FrameYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.FrameXPosition, myPersonalCard.FrameYPosition).getTile().getType() == TileType.FRAME)) {
                counter++;
            }
            if ((getShelves().getTilePosition(myPersonalCard.TrophyXPosition, myPersonalCard.TrophyYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.TrophyXPosition, myPersonalCard.TrophyYPosition).getTile().getType() == TileType.TROPHY)) {
                counter++;
            }
            if ((getShelves().getTilePosition(myPersonalCard.GamesXPosition, myPersonalCard.GamesYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.GamesXPosition, myPersonalCard.GamesYPosition).getTile().getType() == TileType.GAMES )) {
                counter++;
            }
            if ((getShelves().getTilePosition(myPersonalCard.PlantXPosition, myPersonalCard.PlantYPosition).isOccupied()) &&
                    (getShelves().getTilePosition(myPersonalCard.PlantXPosition, myPersonalCard.PlantYPosition).getTile().getType() == TileType.PLANT)) {
                counter++;
            }
        }catch (NullPointerException e){
            System.err.println("Shelves not initialized.");
        }

        return counter;
    }

    public void addEndOfGamePoint(){
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

    /* non serve perché score aggiornato a ogni turno da Game!
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

    public int calculatePersonalPoints() {
        int counter;
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
        int tilesCounter = 0;
        int totalPoints = 0;
        boolean[][] visited = new boolean[6][5];

        // TODO verificare che sono false senza \/
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                visited[row][col] = false;
            }
        }

        // Scansione delle tessere nello Shelf
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if(visited[row][col]) {
                    continue;
                }

                try {
                    tilesCounter = calculateGroupCounter(row, col, visited, 1, true, shelves.getTilePosition(col, row).getTile().getType());
                }catch (Exception e){//succede quando tessere in shelves vuote
                    continue;
                }

                // Serve per la HashMap
                if(tilesCounter > 6) {
                    tilesCounter = 6;
                }

                totalPoints += givenAdjacencyPoints.get(tilesCounter);
            }

        }
        return totalPoints;
    }

    public boolean isValidPosition(int row, int col){
        if (row < 0 || row >= 6 || col < 0 || col >= 5) {
            return false;
        }
        else return true;
    }

    private int calculateGroupCounter(int row, int col, boolean[][] visited, int counter, boolean starter, TileType prevType) {
        TileObj currentTile;

        if (row < 0 || row >= 6 || col < 0 || col >= 5 || visited[row][col]) {
            counter = 0;
            return counter;
        }
        if(!(shelves.getTilePosition(row, col).getTile().getType().equals(prevType))){
            return counter;
        }

        visited[row][col] = true;
        counter ++;
        currentTile = this.shelves.getTilePosition(row, col).getTile();


        if (isValidPosition(row-1,col) && this.shelves.getTilePosition(row - 1, col).isOccupied() &&
                this.shelves.getTilePosition(row - 1, col).getTile().getType().equals(currentTile.getType()))
        {

            counter += calculateGroupCounter(row - 1, col, visited, counter, false, prevType);
        }
        if (isValidPosition(row+1,col) && shelves.getTilePosition(row + 1, col).getTile() != null && shelves.getTilePosition(row + 1, col).getTile().getType().equals(currentTile.getType())) {
            counter += calculateGroupCounter(row + 1, col, visited, counter, false, prevType);
        }
        if (isValidPosition(row,col-1) && shelves.getTilePosition(row, col-1).getTile() != null && shelves.getTilePosition(row, col-1).getTile().getType().equals(currentTile.getType())) {
            counter += calculateGroupCounter(row, col - 1, visited, counter, false, prevType);
        }
        if (isValidPosition(row,col+1) && shelves.getTilePosition(row, col+1).getTile() != null && shelves.getTilePosition(row, col+1).getTile().getType().equals(currentTile.getType())) {
            counter += calculateGroupCounter(row, col + 1, visited, counter, false, prevType);
        }

        /*
        if (starter) {
            return counter;
        }*/
        if(counter > 6) {
            counter = 6;
        }

        return  counter;


    }

    /*
    private int calculateGroupCounter(int row, int col, boolean[][] visited, int counter, boolean starter, int totCounter, TileType prevType) {
        if (row < 0 || row >= 6 || col < 0 || col >= 5 || visited[row][col] || !shelves.getTilePosition(row, col).getTile().getType().equals(prevType)) {
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

        System.out.println("TotCounter: " + totCounter);

        if (starter) {
            return totCounter;
        }
        return  0;
    }
    */




    //da chiamato in Game::end()!
    public void calcOverallScore() throws Exception {
        this.score +=  calculatePersonalPoints() + calculateAdjacentPoints();
    }

    // manca un putTyle in shelves che accetta solo la colonna in cui io devo aggiungere le tiles!
    // qualcosa che avevamo detto essere gravity?
    public void putTilesInShelf(ArrayList<TileObj> tilesToPut, int col, int ordine[]) throws Exception {
        /*TODO!
        * ricorda genera eccezione
        * se non riesce a mettere le tiles
            -> libreria piena, in questa colonna non ci possono stare quel numero di tiles   IllegalSizeOfTilesException
            -> colonna non giusta   IllegalColumnException
        * se riesce a mettere le tiles
        *   con le tiles immesse la libreria  diventa piena     FullLibraryException
        * */

        ArrayList<TileObj> orderedTilesToRemove = new ArrayList<>();
        //ordinamento per immissione in libreria
        for (int i = 0; i < tilesToPut.size(); i++) {
            orderedTilesToRemove.add(tilesToPut.get(ordine[i] - 1));
        }

        tilesToPut = orderedTilesToRemove;

        int countTilesInColumn = 0;
        for(int i = 0; i < 6;i++) {
            if (shelves.getTilePosition2(col, i).getTile() != null) {
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

        for (TileObj tileObj : tilesToPut) {
            shelves.getTilePosition2(col, countTilesInColumn).setTile(tileObj);
            countTilesInColumn++;
        }
        if (shelves.getFilledCounter() == 30) throw new FullLibraryException();
    }
}