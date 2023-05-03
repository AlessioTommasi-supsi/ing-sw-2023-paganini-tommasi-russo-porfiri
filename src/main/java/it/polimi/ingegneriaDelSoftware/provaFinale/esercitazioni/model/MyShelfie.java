package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyShelfie implements Serializable {
    private ArrayList<Game> games;

    public MyShelfie() {
        games = new ArrayList<Game>();
    }

    public Game joinGame(int intPlayerNumber, Player p ) throws Exception{
        //controllo che il player non sia gia attivo in qualche altra partita
        for (Game game: games) {
            switch (game.getStato()){
                case IN_CORSO:
                case IN_ATTESA:
                    for (Player player: game.getPlayers()) {
                        if (player.getId() == p.getId()) {
                            throw new IllegalArgumentException("il player e gia attivo o in coda in qualche altra partita");
                        }
                    }
            }
        }
        //esistono partite con gia quel numero di giocatori in attesa:
        int i =0;
        for (Game game: games) {
            switch (game.getStato()){
                case IN_ATTESA:
                    if (game.getPlayerNumber() == intPlayerNumber) {
                        game.addPlayer(p);
                        return game;
                    }
                break;
            }
            i++;
        }
        //non esistono partite in attesa con quel numero di giocatori
        Game g =null;

        if (i == games.size()) {
            try {
                //System.out.println("game create: ");
                g=new Game(intPlayerNumber, p);
                //System.out.println("game created succesfull: ");
            }catch (Exception e){
                e.printStackTrace();
            }

            games.add(g);
        }
        return g;
    }

    @Override
    public String toString() {
        return "MyShelfie{" +
                "games=" + games.toString() +
                '}';
    }
}
