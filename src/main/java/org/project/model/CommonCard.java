package org.project.model;

import java.io.Serializable;


public abstract class CommonCard  implements Serializable {
    private int index ;
    private int score;
    private String description = "Not assigned";

    public int getIndex() {
        return index;
    }

    public int getScore() {
        return score;
    }

    public CommonCard(int extIndex){
        this.index = extIndex;
        this.score=8;
    }


    public CommonCard(int extIndex, String description){
        this.index = extIndex;
        this.description = description;
        this.score = 8;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract boolean executeAlgorithm(Player player);

    public void setScore(int i) {
        this.score = i;
    }
}