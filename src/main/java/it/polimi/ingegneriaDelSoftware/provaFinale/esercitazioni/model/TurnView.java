package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice_my_shelfie playerChoice;
    private final Choice cpuChoice;
    private final Outcome outcome;

    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        this.cpuChoice = model.getCpuChoice();
        this.outcome = model.getOutcome();
    }

    public Choice_my_shelfie getPlayerChoice() {
        return this.playerChoice;
    }

    public Choice getCpuChoice() {
        return this.cpuChoice;
    }

    public Outcome getOutcome() {
        return this.outcome;
    }
}
