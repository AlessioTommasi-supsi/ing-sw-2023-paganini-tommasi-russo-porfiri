package org.example.model;


import java.io.Serializable;

public class Ranking implements Serializable {
    private int punteggio;
    private Player player;

    public Ranking(Player p, int points) {
        punteggio = points;
        player =p;
    }

    public int getPunteggio() {
        return punteggio;
    }

    @Override
    public String toString() {
        return "" +
                "punteggio:" + punteggio +
                ", player=" + player ;
    }
}