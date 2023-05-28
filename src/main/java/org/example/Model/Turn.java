package org.example.Model;

import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

import java.io.Serializable;

public class Turn extends Observable<Turn.Event> implements Serializable {

    private Choice playerChoice;

    public String errore = "";
    private MyShelfie myShelfie = null;



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
        this.errore = "";
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
                "'\n', errore='" + errore + '\'' +
                "'\n', myShelfie=" + myShelfie +
                '}';
    }
}