package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.*;

import java.io.Serializable;

public class Turn extends Observable<Turn.Event> implements Serializable {

    private Choice playerChoice;

    public String error = "";
    private MyShelfie myShelfie = null;

    public enum Event {
        PLAYER_CHOICE, CPU_CHOICE, OUTCOME
    }

    public void NotifyClient(){
        this.playerChoice.setState(Event.CPU_CHOICE);
        setChangedAndNotifyObservers(
                playerChoice
        );
    }

    //GETTER PART
    public MyShelfie getMyShelfie() {
        return myShelfie;
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
        this.error = "";
        playerChoice = null;
    }

    private void setChangedAndNotifyObservers(Choice arg) {
        setChanged();
        notifyObservers(arg);
    }

    @Override
    public String toString() {
        return "Turn{'\n'" +
                "'\n'playerChoice=" + playerChoice +
                "'\n', error='" + error + '\'' +
                "'\n', myShelfie=" + myShelfie +
                '}';
    }
}