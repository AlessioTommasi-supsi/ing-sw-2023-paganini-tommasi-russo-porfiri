package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 *
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public abstract class Game implements Serializable {

    private Player current_player;
    private int current_game_id;

    protected Board board;
    protected ArrayList<Player> players;//ordinato in base all ordine nel quale i giocaori si sono uniti alla patrita e quindi anche in ordine di chi tocca a giocare!
    protected int playerNumber;//numeri di giocatori che ci sono in questa partita!
    protected Player dealer;
    protected StatoPartita stato;

    protected int ranking[]=null;

    protected ArrayList<Ranking> rank;

    public Game(int playerNumber, Player mazziere) {
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        rank= new ArrayList<Ranking>();

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
        //indice di ranking e endice dei giocatori quando si sono uniti alla partita.

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

    public Player getCurrent_player() {
        return current_player;
    }

    public int getCurrent_game_id() {
        return current_game_id;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer(int id_player) {
        for (int i = 0; i < players.size(); i++) {
            if (id_player == players.get(i).getId()){
                return players.get(i);
            }
        }
        return null;
    }
}