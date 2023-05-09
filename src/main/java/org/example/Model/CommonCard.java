package org.example.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public abstract class CommonCard  implements Serializable {

    private int points;
    private int index;
    private boolean objectiveAlreadyCompleted;

    public int getPoints() {
        return points;
    }

    public int getIndex() {
        return index;
    }


    public boolean isObjectiveAlreadyCompleted() {
        return objectiveAlreadyCompleted;  //cos'è?
    }


    public CommonCard(int extPoints, int extIndex){
        this.points = extPoints;
        this.index = extIndex;
    }


    public abstract boolean executeAlgorithm(Player player);
}