package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

public class CommonCardShape implements CommonObjectiveInterface{
    public boolean executeAlgorithm(String nameOfCard) {
        int counterShape = 0;
        if (nameOfCard == "Six Double Objective") {
            if (counterShape == 6) { return true; }
            else { return false; }
        }
        else if (nameOfCard == "Vertical four") {
            if (counterShape == 4) { return true; }
            else { return false; }
        }
        else if (nameOfCard == "Group of 4 tiles") {
            if (counterShape == 2) { return true; }
            else { return false; }
        }

        return false;}
}
