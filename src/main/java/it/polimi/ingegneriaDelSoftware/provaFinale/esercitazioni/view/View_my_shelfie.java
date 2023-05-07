package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.view;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

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
                System.out.println("--- WELCOME TO MY SHELFIE! ---");
                /* Player chooses */
                Choice_my_shelfie pc = askPlayerChoicheMyShelfie();
                Object argument = askPlayerArgumentMyshelfie(pc);

                Choice c =new Choice(pc,player, argument);

                System.out.println("in attesa del server... ");

                setState(State.WAITING_FOR_OUTCOME);
                setChanged();/*NOTIFICO AL SERER che del client ha fatto scelta!!*/
                notifyObservers(c);
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
                        this.player.getShelves().displayShelves();
                        return askPlayerChoicheMyShelfie();
                }
                return Choice_my_shelfie.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.err.println("I don't know this choiche: " + input);
                System.err.println("Try again...");
            }
        }
    }

    public void update(TurnView model/*risposta dal server*/, Choice arg/*evento che il client ha scelto*/) {
        try {
            switch (model.getPlayerChoice().getStato()) {
                case CPU_CHOICE -> {
                    Choice_my_shelfie o = model.getPlayerChoice().getChoiche();
                    System.out.println("la scelta che hai fatto e': "+o.toString());
                    switch (model.getPlayerChoice().getChoiche()){
                        case IMMMETTI_IN_LIBRERIA:
                            //aggiorno la libreria del client!
                            this.player.setShelves(model.getCurrentPlayer().getShelves());
                            break;

                        case JOIN_GAME:
                        case GET_STATE:
                            if (
                                    model.getCurrentGame().getStato() != StatoPartita.IN_CORSO ||
                                            this.player.getId() != model.getCurrentPlayer().getId()
                            ) {
                                System.out.println("aspetta il tuo turno!  "+ model.getCurrentGame().toString() );


                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                Choice c =new Choice(Choice_my_shelfie.GET_STATE,player, null);

                                setState(State.WAITING_FOR_OUTCOME);
                                setChanged();/*NOTIFICO AL SERER che del client ha fatto scelta!!*/
                                notifyObservers(c);
                                return;
                            }
                    }
                }
                default -> System.err.println("Ignoring event from " + model.toString() + ": " + arg.toString());

            }
        }catch (Exception e){
            System.out.println("gioco che ha generato errore: "+model.getCurrentGame().toString());
            e.printStackTrace();
        }


        System.out.println("il server ha risposto!");
        this.setState(State.WAITING_FOR_PLAYER);

    }


}