package org.example.Model;

import java.io.Serializable;

public class Choice implements Serializable {
    private Choice_my_shelfie choice;
    private Turn.Event stato;
    private Object argument;
    private Player player;

    public Choice(Choice_my_shelfie choice, Player player, Object argument) {
        this.choice = choice;
        this.argument = argument;
        this.player = player;
    }

    public Turn.Event getStato() {
        return stato;
    }

    public void setStato(Turn.Event stato) {
        this.stato = stato;
    }

    public Choice_my_shelfie getChoice() {
        return choice;
    }

    public void setChoice(Choice_my_shelfie choice) {
        this.choice = choice;
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
                "choice=" + choice.toString() +
                ", stato=" + stato +
                ", argument=" + argument.toString() +
                ", player=" + player.toString() +
                '}';
    }
}
