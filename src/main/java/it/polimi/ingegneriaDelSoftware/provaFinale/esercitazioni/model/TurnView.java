package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice playerChoice;
    private final MyShelfie myShelfie;
    private final Outcome outcome;

    private final Game game;
    public Game getGame() {
        return game;
    }
;

    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        this.outcome = model.getOutcome();
        this.myShelfie = model.getMyShelfie();
        this.game = model.getGame();

    }

    public Choice getPlayerChoice() {
        return this.playerChoice;
    }

    public MyShelfie getMyShelfie() {
        return myShelfie;
    }

    public Outcome getOutcome() {
        return this.outcome;
    }
}
