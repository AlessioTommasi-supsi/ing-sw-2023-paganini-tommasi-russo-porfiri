package org.example.Model;

import java.io.Serializable;

public class Choice implements Serializable {
    private Choice_my_shelfie choiche;
    private Turn.Event stato;
    private Object argument;

    private Player player;

    public Choice(Choice_my_shelfie choiche,Player player, Object argument) {
        this.choiche = choiche;
        this.argument = argument;
        this.player = player;
    }

    public Turn.Event getStato() {
        return stato;
    }

    public void setStato(Turn.Event stato) {
        this.stato = stato;
    }

    public Choice_my_shelfie getChoiche() {
        return choiche;
    }

    public void setChoiche(Choice_my_shelfie choiche) {
        this.choiche = choiche;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "choiche=" + choiche +
                ", stato=" + stato +
                ", argument=" + argument +
                ", player=" + player +
                '}';
    }
}
