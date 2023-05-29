package org.example.model;

import java.io.Serializable;

public class Choice implements Serializable {
    private ChoiceMyShelfie choice;
    private Turn.Event stato;
    private Object argument;
    private Player player;

    public Choice(ChoiceMyShelfie choice, Player player, Object argument) {
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

    public ChoiceMyShelfie getChoice() {
        return choice;
    }

    public void setChoice(ChoiceMyShelfie choice) {
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