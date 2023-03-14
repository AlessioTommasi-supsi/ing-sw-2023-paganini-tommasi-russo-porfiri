package org.example.Model;
import java.util.*;

/**
 * Con getPartita inserisco la mia preferenza di giocatori in cui la partita non è ancora attivata. Se non ce ne sono, creo una nuova istanza di partita in cui sono il mazziere. In tal caso, si usa un factory pattern che mi crea un'istanza di partita tramite il metodo privato createPartita, che setta il mazziere.
 */
public class MyShelfie extends Giocatore {

	/**
	 * Default constructor
	 */
	public MyShelfie() {
	}

	/**
	 * @param numeroGiocatori 
	 * @return
	 */
	public Partita joinPartita(int numeroGiocatori) {
		// TODO implement here
		return null;
	}

	/**
	 * @param mazziere
	 */
	private void setMazziere(Giocatore mazziere) {
		// TODO implement here
	}

}