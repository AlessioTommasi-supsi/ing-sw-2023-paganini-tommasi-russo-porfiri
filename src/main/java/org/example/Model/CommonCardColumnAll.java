package org.example.Model;

public class CommonCardColumnAll implements CommonObjectiveInterface {
    public boolean executeAlgorithm(String nameOfCard) {
        int counterLine = 0;
        if (nameOfCard == "Vertical different six") {
            if (counterLine == 2) { return true; }
            else { return false; }
        } else if (nameOfCard == "Row of 5 different tiles") {
            if (counterLine == 2) { return true; }
            else { return false; }
        }
        return false;}
}
