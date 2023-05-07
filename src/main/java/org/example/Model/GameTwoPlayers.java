package org.example.Model;

import java.io.Serializable;

public class GameTwoPlayers extends Game implements Serializable {
    public GameTwoPlayers(int playerNumber, Player dealer){
        super(playerNumber, dealer);
    }

    @Override
    public void BuildBoard() {
        return;
    }


}
