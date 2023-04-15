package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

public class Turn extends Observable<Turn.Event> {

    private Choice playerChoice;
    private Outcome outcome;

    private MyShelfie myShelfie;

    private Player current_player;

    private Game game = null;//viene assegnato per la prima volta dopo aver chiamato Myshelfie.join!

    public enum Event {
        PLAYER_CHOICE, CPU_CHOICE, OUTCOME
    }


    //GETTER PART
    public MyShelfie getMyShelfie() {
        return myShelfie;
    }

    public Player getCurrent_player() {
        return current_player;
    }



    public Game getGame() {
        return game;
    }

    //SETTER PART
    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
        setChangedAndNotifyObservers(Event.CPU_CHOICE);
    }
    public void setGame(Game game) {
        this.game = game;
        setChangedAndNotifyObservers(Event.CPU_CHOICE);
    }


    public void setMyShelfie(MyShelfie myShelfie) {
        this.myShelfie = myShelfie;
        setChangedAndNotifyObservers(Event.CPU_CHOICE);
    }

    //OLD
    public Choice getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Choice playerChoice) {
        this.playerChoice = playerChoice;
        setChangedAndNotifyObservers(Event.PLAYER_CHOICE);
    }


    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
        setChangedAndNotifyObservers(Event.OUTCOME);
    }

    public void clear() {
        outcome = null;
        playerChoice = null;
    }

    private void setChangedAndNotifyObservers(Event arg) {
        setChanged();
        notifyObservers(arg);
    }



}