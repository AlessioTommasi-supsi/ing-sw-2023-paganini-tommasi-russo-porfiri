package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

public class Turn extends Observable<Turn.Event> {

    private Choice playerChoice;

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
        this.playerChoice.setStato(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );
    }
    public void setGame(Game game) {
        this.game = game;
        this.playerChoice.setStato(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );
    }


    public void setMyShelfie(MyShelfie myShelfie) {
        this.myShelfie = myShelfie;
        this.playerChoice.setStato(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );
    }

    //OLD
    public Choice getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Choice playerChoice) {
        this.playerChoice = playerChoice;

        this.playerChoice.setStato(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );


    }




    public void clear() {
        //outcome = null;
        playerChoice = null;
    }

    private void setChangedAndNotifyObservers(Choice arg) {
        setChanged();
        notifyObservers(arg);
    }



}