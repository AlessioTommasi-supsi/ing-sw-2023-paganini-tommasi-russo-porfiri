package org.example.Model;


import java.io.Serializable;

public class Ranking implements Serializable {
    private int punteggio;
    private Player player;

    public Ranking(Player p, int points) {
        punteggio = points;
        player =p;
    }

    @Override
    public String toString() {
        return "" +
                "punteggio:" + punteggio +
                ", player=" + player ;
    }
}