package org.example.Model;

import java.util.*;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 * 
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public class Game {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * 
     */
    private int playerNumber;

    /**
     * 
     */
    private Set<Player> giocatori;

    /**
     * 
     */
    private Player vincitore;

    /**
     * 
     */
    private int ranking;

    /**
     * @return
     */
    public void iniziaPartita() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void finePartita() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Game() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void getDealer() {
        // TODO implement here
    }

    /**
     *
     */
    public void getPlayers() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void start() {
        // TODO implement here
    }

    /**
     * qui richiamo calcola punteggi
     * @return
     */
    public void end() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void getPoints() {
        // TODO implement here
    }

    /**
     * @param id 
     * @return
     */
    private int calculatePoints(int id) {
        // TODO implement here
        return 0;
    }


    /**
     * @param mazziere
     */
    private void setMazziere(Player mazziere) {
        // TODO implement here
    }
}