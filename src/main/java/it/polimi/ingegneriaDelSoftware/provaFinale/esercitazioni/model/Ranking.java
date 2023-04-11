package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;


public class Ranking {
    private int punteggio;
    private Player player;

    public Ranking(Player p, int points) {
        punteggio = points;
        player =p;
    }
    

}