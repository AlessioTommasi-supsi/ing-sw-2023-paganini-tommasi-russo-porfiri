package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

public enum Outcome {
    WIN, LOSE, DRAW,ERROR;

    public static Outcome testWin(boolean winCondition) {
        return winCondition ? WIN : LOSE;
    }
}
