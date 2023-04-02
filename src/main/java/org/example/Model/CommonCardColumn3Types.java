package org.example.Model;

import java.awt.*;

public class CommonCardColumn3Types implements CommonObjectiveInterface {
    public boolean executeAlgorithm(String nameOfCard) {
        int counterShape = 0;
        if (nameOfCard == "Four rows different types") {
            if (counterShape == 4) {
                return true;
            } else {
                return false;
            }
        }
        else if (nameOfCard == "Three columns different types") {
            if (counterShape == 3) {
                return true;
            } else {
                return false;
            }
        }
        return false;}
}
