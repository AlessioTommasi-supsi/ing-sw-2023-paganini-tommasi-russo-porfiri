package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice playerChoice;
    private final MyShelfie myShelfie;
    private  final Player current_player;

    private final Game current_game;

    private final String errore;


    //non avrebbe senso tornare solo la board????

    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        this.current_player = model.getCurrent_player();
        this.myShelfie = model.getMyShelfie();
        this.current_game = model.getGame();
        this.errore = model.errore;

    }

    public Game getCurrentGame() {
        return current_game;
    }

    public Player getCurrentPlayer() {
        return current_player;
    }

    public Choice getPlayerChoice() {
        return this.playerChoice;
    }

    public MyShelfie getMyShelfie() {
        return myShelfie;
    }

    @Override
    public String toString() {
        return "TurnView{" +
                "playerChoice=" + playerChoice +
                ", myShelfie=" + myShelfie +
                ", game=" + current_game +
                ", errore=" + errore +
                '}';
    }
}
