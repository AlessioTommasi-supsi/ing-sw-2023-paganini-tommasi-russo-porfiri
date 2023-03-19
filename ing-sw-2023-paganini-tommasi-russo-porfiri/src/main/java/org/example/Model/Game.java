package org.example.Model;

import java.util.*;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 * 
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public class Game{

    private Board board;
    private ArrayList<Player> players;
    private int playerNumber;
    private Player dealer;
    private StatoPartita stato;

    private int ranking[]=null;


    public Game(int playerNumber, Player mazziere) {
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        players.add(mazziere);
        this.board = new Board();
    }

    public Board getBoard() {
        return new Board(board);
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


    public void end(){
        this.stato = StatoPartita.FINITA;

        //calcolo i punti di ogni giocatore e ne faccio il ranking
        //indice di ranking e endice dei giocatori quando si sono uniti alla partita.

        int point[];
        //funzionalita ranking!
        point = new int[this.playerNumber];
        this.ranking = new int[this.playerNumber];

        for (int i = 0; i < players.size(); i++) {
            point[i] = players.get(i).getShelves().calculatePoints();
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


}