package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.view;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

import java.util.ArrayList;
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
            Choice_my_shelfie c = askPlayer();
            setState(State.WAITING_FOR_OUTCOME);
            setChanged();/*NOTIFICO AL SERER che del client ha fatto scelta!!*/
            notifyObservers(c);
        }
    }

    public Choice_my_shelfie askPlayer() {
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
                return Choice_my_shelfie.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.err.println("I don't know this choiche: " + input);
                System.err.println("Try again...");
            }
        }
    }

    public void update(TurnView model, Turn.Event arg) {
        switch (arg) {
            case CPU_CHOICE -> showModel(model);
            case OUTCOME -> {
                showOutcome(model);
                this.setState(State.WAITING_FOR_PLAYER);
            }
            default -> System.err.println("Ignoring event from " + model + ": " + arg);
        }
    }

    private void showOutcome(TurnView model) {
        Outcome o = model.getOutcome();
        if (o == null) {
            return;
        }
        /* IN BASE AI MESSAGGI DESCRITTI IN OUTCOME DECIDO COSA VISUALIZZARE!!*/
        switch (o) {
            //cosa devo stampare in base alle scelte fatte e ai risultati del model contenuti in o!!
            case WIN -> System.out.println("You win! :)");
            case DRAW -> System.out.println("Draw... -.-");
            case LOSE -> System.out.println("You lose! :(");
            case ERROR -> System.out.println("AN EERROR HAVE OCCURRED! :'(");
        }
    }

    private void showModel(TurnView model) {
        System.out.println("in attesa di risposta dal server... ");
        try{

            ArrayList<TilePositionBoard> disp_board= model.getGame().getBoard().showBoard();

            for (int i = 0; i < disp_board.size(); i++) {
                System.out.println(disp_board.get(i).getTile().toString());
                System.out.println("X: "+disp_board.get(i).getX() + "Y: "+disp_board.get(i).getY());

            }

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("fine stampa model... ");

    }
}