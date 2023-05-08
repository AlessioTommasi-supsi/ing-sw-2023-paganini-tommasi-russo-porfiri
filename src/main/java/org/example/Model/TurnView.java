package org.example.Model;

import java.io.Serializable;
import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice playerChoice;
    private final MyShelfie myShelfie;

    private final String errore;


    //non avrebbe senso tornare solo la board????

    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        this.myShelfie = model.getMyShelfie();
        this.errore = model.errore;

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
