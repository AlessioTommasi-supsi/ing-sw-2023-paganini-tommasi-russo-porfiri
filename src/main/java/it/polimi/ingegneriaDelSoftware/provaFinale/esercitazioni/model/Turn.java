package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

public class Turn extends Observable<Turn.Event> {

    private Choice_my_shelfie playerChoice;
    private Choice cpuChoice;
    private Outcome outcome;

    private MyShelfie myShelfie;


    private Game game;//viene assegnato per la prima volta dopo aver chiamato Myshelfie.join!

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public MyShelfie getMyShelfie() {
        return myShelfie;
    }

    public void setMyShelfie(MyShelfie myShelfie) {
        this.myShelfie = myShelfie;
    }

    public enum Event {
        PLAYER_CHOICE, CPU_CHOICE, OUTCOME
    }
    public Choice_my_shelfie getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Choice_my_shelfie playerChoice) {
        this.playerChoice = playerChoice;
        setChangedAndNotifyObservers(Event.PLAYER_CHOICE);
    }

    public Choice getCpuChoice() {
        return cpuChoice;
    }

    public void setCpuChoice(Choice cpuChoice) {
        this.cpuChoice = cpuChoice;
        setChangedAndNotifyObservers(Event.CPU_CHOICE);
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
        cpuChoice = null;
        playerChoice = null;
        myShelfie = null;
    }

    private void setChangedAndNotifyObservers(Event arg) {
        setChanged();
        notifyObservers(arg);
    }



}