package org.example.Model;
import java.util.*;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 * 
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public class Partita {

	/**
	 * Default constructor
	 */
	public Partita() {
	}

	/**
	 * 
	 */
	private int numeroGiocatori;

	/**
	 * 
	 */
	private Set<Giocatore> giocatori;

	/**
	 * 
	 */
	private Giocatore vincitore;

	/**
	 * 
	 */
	private Set<int> classifica;

	/**
	 * @return
	 */
	public void iniziaPartita() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public void finePartita() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public void Partita() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Giocatore getMazziere() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Set<Giocatore> getGiocatori() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public void inizia() {
		// TODO implement here
		return null;
	}

	/**
	 * qui richiamo calcola punteggi
	 * @return
	 */
	public void termina() {
		// TODO implement here
		return null;
	}

	/**
	 * @return
	 */
	public Set<int> getPunteggi() {
		// TODO implement here
		return null;
	}

	/**
	 * @param g 
	 * @return
	 */
	private int calcolaPunteggio(Giocatore g) {
		// TODO implement here
		return 0;
	}

}