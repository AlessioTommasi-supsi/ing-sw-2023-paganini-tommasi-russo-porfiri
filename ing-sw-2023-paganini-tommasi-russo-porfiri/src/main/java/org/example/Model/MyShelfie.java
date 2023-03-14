package org.example.Model;

import java.util.*;

/**
 * Con getPartita inserisco la mia preferenza di giocatori in cui la partita non è ancora attivata. Se non ce ne sono, creo una nuova istanza di partita in cui sono il mazziere. In tal caso, si usa un factory pattern che mi crea un'istanza di partita tramite il metodo privato createPartita, che setta il mazziere.
 */
public class MyShelfie extends Player {

    /**
     * Default constructor
     */

    public void MyShelfie() {
        // TODO implement here
    }

    /**
     * @param playerNumber 
     * @return
     */
    public Game joinGame(int playerNumber) {
        // TODO implement here
        return null;
    }

}