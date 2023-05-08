package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 *
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public abstract class Game implements Serializable {

    private Player currentPlayer;
    private int currentGameId;

    private Board board;
    private ArrayList<Player> players;//ordinato in base all ordine nel quale i giocaori si sono uniti alla patrita e quindi anche in ordine di chi tocca a giocare!
    private int playerNumber;//numeri di giocatori che ci sono in questa partita!
    private Player dealer;
    private StatoPartita stato=StatoPartita.IN_ATTESA;
    private ArrayList<PersonalCardParser> personalCardDeck = new ArrayList<>();
    private int pointInitialization1 = 8;
    private int pointInitialization2 = 8;

    private int ranking[]=null;

    private ArrayList<Ranking> rank;

    public Game(int playerNumber, Player mazziere) {
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        rank= new ArrayList<Ranking>();
        this.currentGameId = Globals.increment_Game_id();
        players.add(mazziere);
        this.board = new Board();
    }

    public Board getInstanceBoard() {
        return board;
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Player getDealer() {
        return new Player(dealer);
    }

    public void addPlayer(Player p)throws Exception {
        if (this.stato != StatoPartita.IN_ATTESA){
            throw new Exception("non si possono aggiungere giocatori se la partita non e in attesa!");
        }

        players.add(p);

        if (this.playerNumber == this.players.size()) {
            this.stato = StatoPartita.IN_CORSO;
        }

    }

    public StatoPartita getStato() {
        return stato;
    }


    public void start_partita(){
        this.stato = StatoPartita.IN_CORSO;
    }
    public void end(){
        this.stato = StatoPartita.FINITA;

        //calcolo i punti di ogni giocatore e ne faccio il ranking
        //indice di ranking e Indice dei giocatori quando si sono uniti alla partita.

        int point[];

        //funzionalita ranking!
        point = new int[this.playerNumber];
        this.ranking = new int[this.playerNumber];

        for (int i = 0; i < players.size(); i++) {
            //point[i] = players.get(i).getShelves().getScore();
            rank.add(new Ranking(players.get(i), point[i]));
        }

        int index = -1;
        int max =point[0];

        for (int j = 0; j < this.playerNumber; j++) {
            for (int i = 1; i < players.size() ; i++) {
                if (point[i] > max) {
                    max = point[i];
                    index = i;
                }
            }
            point[index] = -1;
            this.ranking[j] = index;
        }
        //fine funzionalita ranking

    }

    public ArrayList<Ranking> getRanking() throws Exception{
        if(this.stato != StatoPartita.FINITA){
            throw new Exception("non puoi prendere i punteggi perche la partita non e'ancora finita!");
        }
        return new ArrayList<Ranking>(rank);
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", players=" + players.toString() +
                ", playerNumber=" + playerNumber +
                ", dealer=" + dealer +
                ", stato=" + stato +
                ", ranking=" + Arrays.toString(ranking) +
                ", rank=" + rank +
                '}';
    }
    public ArrayList<Ranking> getRank() {
        return rank;
    }

    public void setBoard(ArrayList<TilePositionBoard> extP){
        this.board.setPlacements(extP);
        this.board.addTiles();
    }

    public abstract void BuildBoard();  //Factory Method

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentGameId() {
        return currentGameId;
    }

    public Board getBoard() {
        return new Board(board);
    }

    public Player getPlayer(int id_player) {
        for (int i = 0; i < players.size(); i++) {
            if (id_player == players.get(i).getId()){
                return players.get(i);
            }
        }
        return null;
    }

    public void updatePointsCommon(int countPoints, boolean objectiveAchieved, int numOfPlayer, Player player) {
        int pointsToSub = 0;  //punti da sottrarre a ogni completamento
        if ((numOfPlayer == 4) || (numOfPlayer == 3)) {
            pointsToSub = 2;
        } else if (numOfPlayer == 2) {
            pointsToSub = 4;
        }
        if (!player.getIsCommonCard1Completed()) {   //se il player completa l'obiettivo aggiungi i punti altrimenti no
            if (objectiveAchieved) {
                countPoints = countPoints + this.pointInitialization1;   //aggiorna i punti
                pointInitialization1 = pointInitialization1 - pointsToSub; // sottrai i punti
            }
        }
        if (!player.getIsCommonCard2Completed()) {
            if (objectiveAchieved) {
                countPoints = this.pointInitialization2;
                pointInitialization2 = pointInitialization2 - pointsToSub;
            }
        }
    }

    /*NON FUNZIONANTE
    public ArrayList setRanking() {
        while(Player p : players){
            p.calcOverallScore();
        }

        Collections.sort(players, new Comparator<Player>()) {
            @Override
            public int compare(Player p1, Player p2) {
                return p2.getScore() - p1.getScore();
            }
        }

        this.rank.addAll(players);
    }

     */
}