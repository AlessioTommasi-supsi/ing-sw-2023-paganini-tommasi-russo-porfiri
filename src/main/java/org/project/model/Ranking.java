package org.project.model;


import java.io.Serializable;

public class Ranking implements Serializable {
    private int points;
    private Player player;

    public Ranking(Player p, int points) {
        this.points = points;
        player =p;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "" +
                "punteggio:" + points +
                ", player=" + player ;
    }
}