package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class TurnView implements Serializable {

    static final long serialVersionUID = 1L;

    private final Choice playerChoice;
    private final MyShelfie myShelfie;
    private  final Player player;

    private final Game game;



    public TurnView(Turn model) {
        this.playerChoice = model.getPlayerChoice();
        //this.outcome = model.getOutcome();
        this.player = model.getCurrent_player();
        this.myShelfie = model.getMyShelfie();
        this.game = model.getGame();

    }

    public Game getGame() {
        return game;
    }

    public Player getPlayer() {
        return player;
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
                ", game=" + game +
                '}';
    }
}
