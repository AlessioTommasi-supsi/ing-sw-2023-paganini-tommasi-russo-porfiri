package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import java.io.Serializable;

public class Choice implements Serializable {
    private ChoiceMyShelfie choice;
    private Turn.Event state;
    private Object argument;
    private Player player;

    public Choice(ChoiceMyShelfie choice, Player player, Object argument) {
        this.choice = choice;
        this.argument = argument;
        this.player = player;
    }

    public Turn.Event getState() {
        return state;
    }

    public void setState(Turn.Event state) {
        this.state = state;
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
                ", state=" + state +
                ", argument=" + argument.toString() +
                ", player=" + player.toString() +
                '}';
    }
}
