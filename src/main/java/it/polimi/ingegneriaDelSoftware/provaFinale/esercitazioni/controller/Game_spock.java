package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.controller;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed.Client;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;

import java.util.ArrayList;
import java.util.Random;

public class Game_spock {
    private final Turn model;
    private final Client client;

    private final Random RAND = new Random();

    public Game_spock(Turn model, Client client) {
        this.model = model;
        this.client = client;
    }

    private void play() {
        /* CPU chooses */
        //elaborazioni sul model part
        model.setCpuChoice(askCpu());
        /* Compute Outcome */
        //scelta del messaggio di uscita!
        model.setOutcome(computeOutcome());
        /* Clean State */
        model.clear();
    }

    private Choice askCpu() {  /*parte elaborativa fatta dal server*/
        Choice[] choices = Choice.values();
        return choices[RAND.nextInt(choices.length)];
    }

    private Outcome computeOutcome() { /*parte elaborativa fatta dal client*/

        /*qui devo fare computazione e ritornare qualcosa alla view!!
        * ovvero qui prima veniva chiamato computate outcome in  base a cio che ricevo in input scelgo cosa fare!!
        *

        if (model.getPlayerChoice() == model.getCpuChoice()) {
            return Outcome.DRAW;
        }

        return switch (model.getPlayerChoice()) {
            case ROCK -> Outcome.testWin(model.getCpuChoice() == Choice.LIZARD || model.getCpuChoice() == Choice.SCISSORS);
            case PAPER -> Outcome.testWin(model.getCpuChoice() == Choice.ROCK || model.getCpuChoice() == Choice.SPOCK);
            case SCISSORS -> Outcome.testWin(model.getCpuChoice() == Choice.PAPER || model.getCpuChoice() == Choice.LIZARD);
            case LIZARD -> Outcome.testWin(model.getCpuChoice() == Choice.SPOCK || model.getCpuChoice() == Choice.PAPER);
            case SPOCK -> Outcome.testWin(model.getCpuChoice() == Choice.SCISSORS || model.getCpuChoice() == Choice.ROCK);
        };

         */
        return Outcome.ERROR;
    }

    public void update(Client o, Choice_my_shelfie arg) {
        if (!o.equals(client)) {
            System.err.println("Discarding notification from " + o);
            return;
        }
        model.setPlayerChoice(arg);
        play();
    }

    /**------------------MYSHELFIE PART -----------------------*/
    private Board board;
    private ArrayList<Player> players;//ordinato in base all ordine nel quale i giocaori si sono uniti alla patrita e quindi anche in ordine di chi tocca a giocare!
    private int playerNumber;//numeri di giocatori che ci sono in questa partita!
    private Player dealer;
    private StatoPartita stato;

    private int ranking[]=null;

    //mi serve per dire a che giocaore tocca in questo turno!!
    private int turno;

    private ArrayList<Ranking> rank;

    public void Game(int playerNumber, Player mazziere) {
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        rank= new ArrayList<Ranking>();

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
}