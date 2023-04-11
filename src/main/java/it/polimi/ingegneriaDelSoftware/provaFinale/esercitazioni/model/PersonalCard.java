package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.util.*;

/**
 * compra gioco fisico per mapparlo
 * (chiedi martedi a prof!!!!) se supponiamo posiz random o dobbiamo usare quelle del gioco fisico!!
 */
public class PersonalCard {
    private TilePositionShelves positionShelves[] ;
    private int points;
    /**
     * Default constructor
     */
    public PersonalCard(int points, TilePositionShelves positionShelves[]) {
        this.points = points;
        this.positionShelves = positionShelves;
    }

    /**
     * 
     */
    private int punti;

    /**
     * 
     */
    private PersonalObjective personalCardGoal;

    /**
     * @return
     */
    public void updatePunti() {
        // TODO implement here
    }

    /**
     * @return
     */
    private int getPunti() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void PersonalCard() {
        // TODO implement here
    }

    /**
     * @return
     */
    public PersonalObjective getGoal() {
        // TODO implement here
        return null;
    }

}