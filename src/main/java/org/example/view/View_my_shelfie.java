package org.example.view;

import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View_my_shelfie extends Observable<Choice_my_shelfie> implements Runnable {

    private enum State {
        WAITING_FOR_PLAYER,
        WAITING_FOR_OUTCOME
    }

    private State state = State.WAITING_FOR_PLAYER;
    private final Object lock = new Object();

    private Player player;
    private Game current_game= null;

    private int current_game_id = -1; //verra assegnato dopo aver fatto join_game!!

    private State getState() {
        synchronized (lock) {
            return state;
        }
    }

    private void setState(State state) {
        synchronized (lock) {
            this.state = state;
            lock.notifyAll();
        }
    }
    //PRIMA ESECUZIONE
    @Override
    public void run() {
        try {
            //creazione del giocatore
            System.out.println("BENVENUTO NUOVO GIOCATORE! per iniziare a giocare devi immettere i tuoi dati");
            System.out.println("username: ");
            Scanner s = new Scanner(System.in);
            this.player = new Player(s.next());

            //fine creazione
            //noinspection InfiniteLoopStatement
            while (true) {
                while (getState() == State.WAITING_FOR_OUTCOME) {
                    synchronized (lock) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.err.println("Interrupted while waiting for server: " + e.getMessage());
                        }
                    }
                }
                if (this.current_game == null) {
                    System.out.println("--- WELCOME TO MY SHELFIE! ---");
                    /* Player chooses  POSSIBLE ONLY JOINGAME! */
                    Choice_my_shelfie pc = Choice_my_shelfie.JOIN_GAME;
                    Object argument = askPlayerArgumentMyshelfie(pc);

                    Choice c =new Choice(pc,player, argument);

                    System.out.println("in attesa del server... ");

                    setState(State.WAITING_FOR_OUTCOME);
                    setChanged();/*NOTIFICO AL SERER che del client ha fatto scelta!!*/
                    notifyObservers(c);
                }else {
                    Choice_my_shelfie pc = askPlayerChoicheMyShelfie();
                    Object argument = askPlayerArgumentMyshelfie(pc);

                    Choice c =new Choice(pc,player, argument);

                    System.out.println("in attesa del server... ");

                    setState(State.WAITING_FOR_OUTCOME);
                    setChanged();/*NOTIFICO AL SERER che del client ha fatto scelta!!*/
                    notifyObservers(c);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Object askPlayerArgumentMyshelfie(Choice_my_shelfie pc) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        switch (pc){
            case JOIN_GAME:
                System.out.println("insreisci numero di giocatori della partita: ");
            return  Integer.parseInt(s.next());
            case TERMINA_TURNS:
            return this.current_game_id;//oggetto da passare come argomento e' l'id della partita corrente.

        }
        return null;
    }
    public Choice_my_shelfie askPlayerChoicheMyShelfie() {
        Scanner s = new Scanner(System.in);
        System.out.println("is your turn! Make your choice: ");
        System.out.println(
                "Signs: " +
                        Arrays.stream(Choice_my_shelfie.values())
                                .map(Choice_my_shelfie::name)
                                .collect(
                                        Collectors.joining(",", "[", "]")));
        while (true) {
            String input = s.next();
            try {
                switch (Choice_my_shelfie.valueOf(input)){
                    case SHOW_MY_SHELVS:
                        System.out.println("your current shelves is: ");
                        System.out.println("");
                        try {
                            this.player.getShelves().displayShelves();
                        }catch (Exception e){
                            System.err.println("Error occurred displayng your shelvs! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoicheMyShelfie();
                }
                return Choice_my_shelfie.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.err.println("I don't know this choiche: " + input);
                System.err.println("Try again...");
            }
        }
    }

    public void update(TurnView model/*risposta dal server*/, Choice arg/*evento che il client remoto ha scelto*/) {



        if (current_game_id == -1){ //inizializzazione di tutte le variabili di gioco
            joining_part(model,arg);
        }else {
            //ho gia fatto join!
            choiche_part( model, arg);
        }

        /* //.DEBUG
        System.err.println(this.toString());
        */
    }


    public void joining_part(TurnView model,Choice arg) {
        //USERNAME DEVE ESSERE UNIVOCO
        if (this.player != null) {
            if(arg.getPlayer().getUsername().equals( this.player.getUsername())){
                switch (model.getPlayerChoice().getStato()) {
                    case CPU_CHOICE -> {
                        switch (model.getPlayerChoice().getChoice()) {
                            case JOIN_GAME:
                                this.player.setId(arg.getPlayer().getId());
                                //aggiorno la variabile this.current_game_id e current_game
                                for (int i = 0; i < model.getMyShelfie().getGames().size(); i++) {
                                    boolean is_player_in_this_game = false;
                                    for (int j = 0; j < model.getMyShelfie().getGames().get(i).getPlayers().size(); j++) {
                                        if (model.getMyShelfie().getGames().get(i).getPlayers().get(j).getId() == this.player.getId()) {
                                            is_player_in_this_game = true;
                                            break;
                                        }
                                    }
                                    if (is_player_in_this_game == true){
                                        switch (model.getMyShelfie().getGames().get(i).getStato()) {//le partite saranno o in attesa o in corso!
                                            case IN_CORSO://non dovrebbe mai arrivarci!
                                                System.out.println();
                                                System.out.println("ti sei unito ad una partita e la partita e' in corso!");
                                                System.err.println("partita a cui ti sei unito in corso: "+model.getMyShelfie().getGames().get(i).toString());
                                                System.out.println();
                                                this.current_game_id = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                this.current_game = model.getMyShelfie().getGames().get(i);
                                                break;
                                            case IN_ATTESA://siccome non esiste una partita di un solo giocatore entrero sempre qui!
                                                System.out.println("ti sei unito ad una partita e la partita e' in attesa di altri giocatori!");
                                                System.err.println("partita a cui ti sei unito in corso: "+model.getMyShelfie().getGames().get(i).toString());
                                                System.out.println();
                                                this.current_game_id = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                this.current_game = model.getMyShelfie().getGames().get(i);
                                                break;
                                        }
                                    }
                                }
                                //stampo i dati della partita a cui mi sono unito.
                                break;
                            default:
                                System.err.println("devi prima unirti al gioco!");
                        }
                    }
                    default -> System.err.println("errore stato! Ignoring event from " + model.toString() + ": " + arg.toString());
                }

                System.out.println("il server ha risposto!");
                //this.setState(State.WAITING_FOR_PLAYER);
            }
        }

    }

    public void choiche_part(TurnView model, Choice arg) {
        if (model.getMyShelfie().getGame(this.current_game_id).getCurrentPlayer() != null) {
            if (model.getMyShelfie().getGame(this.current_game_id).getCurrentPlayer().getId() == this.player.getId()) {//versione corretta
                try {
                    switch (model.getPlayerChoice().getStato()) {
                        case CPU_CHOICE -> {
                            switch (model.getPlayerChoice().getChoice()) {
                                case IMMMETTI_IN_LIBRERIA:
                                    //aggiorno client!
                                    this.current_game =model.getMyShelfie().getGame(this.current_game_id);
                                    this.player= this.current_game.getPlayer(this.player.getId());
                                break;

                                case TERMINA_TURNS:
                                    System.out.println("hai terminato il tuo turno!");
                                    System.out.println("ora tocca a: " + model.getMyShelfie().getGame(this.current_game_id).getCurrentPlayer().getUsername());
                                break;

                                case JOIN_GAME://non devo far nulla!
                                break;

                                default:
                                    System.err.println("not implemented yet");
                            }
                        }
                        default -> System.err.println("errore stato! Ignoring event from " + model.toString() + ": " + arg.toString());
                    }
                } catch (Exception e) {
                    System.out.println("gioco che ha generato errore: " + model.getMyShelfie().getGame(this.current_game_id).toString());
                    e.printStackTrace();
                }
                System.out.println("il server ha risposto!");
                this.setState(State.WAITING_FOR_PLAYER);
            }
        }



    }


    @Override
    public String toString() {
        return "View_my_shelfie{" +
                "\nstate=" + state +
                ",\n lock=" + lock +
                ",\n player=" + player +
                ",\n current_game=" + current_game +
                ",\n current_game_id=" + current_game_id +
                "\n}";
    }



}

