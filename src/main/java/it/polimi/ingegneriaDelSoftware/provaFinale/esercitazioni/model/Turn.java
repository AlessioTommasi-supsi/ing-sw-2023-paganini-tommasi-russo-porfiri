package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.util.Observable;

public class Turn extends Observable<Turn.Event> {

    private Choice playerChoice;

    public String errore = "";
    private MyShelfie myShelfie = null;

    private Player current_player;

    private Game game = null;//viene assegnato per la prima volta dopo aver chiamato Myshelfie.join!

    public enum Event {
        PLAYER_CHOICE, CPU_CHOICE, OUTCOME
    }

    public void NotifyClient(){
        this.playerChoice.setStato(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );
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

    }
    public void setGame(Game game) {
        this.game = game;
    }


    public void setMyShelfie(MyShelfie myShelfie) {
        this.myShelfie = myShelfie;
    }

    //OLD
    public Choice getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(Choice playerChoice) {
        this.playerChoice = playerChoice;
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