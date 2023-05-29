package org.example.model;

import java.io.Serializable;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice playerChoice;
    private final MyShelfie myShelfie; //MI SERVE NON FINAL PER FARE OPERAZIONI E VEDERE ECCEZIONI GENERATE SENZA PASSARE DAL CONTROLLER!

    private final String errore;


    //non avrebbe senso tornare solo la board????

    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        this.myShelfie = model.getMyShelfie();
        this.errore = model.errore;

    }

    public String getErrore() {
        return errore;
    }

    public Choice getPlayerChoice() {
        return this.playerChoice;
    }

    public MyShelfie getMyShelfie() {
        return myShelfie;
    }

    @Override
    public String toString() {
        return "TurnView{" +
                "playerChoice=" + playerChoice +
                ", myShelfie=" + myShelfie +
                ", errore=" + errore +
                '}';
    }
}
