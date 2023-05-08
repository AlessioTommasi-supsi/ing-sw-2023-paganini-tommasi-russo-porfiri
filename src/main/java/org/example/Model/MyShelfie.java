package org.example.Model;

import java.io.Serializable;
import java.util.ArrayList;
public class MyShelfie implements Serializable {
    private ArrayList<Game> games;

    public MyShelfie() {
        games = new ArrayList<Game>();
    }

    public void joinGame(int intPlayerNumber, Player p ) throws Exception{
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
                    }
                    break;
            }
            i++;
        }
        //non esistono partite in attesa con quel numero di giocatori
        Game g =null;

        if (i == games.size()) {
            //g=new Game(intPlayerNumber, p);
            switch (intPlayerNumber){
                case 2:
                    g=new GameTwoPlayers(intPlayerNumber,p);
                break;
                case 3:
                    g=new GameThreePlayers(intPlayerNumber, p);
                break;
                case 4:
                    g=new GameFourPlayers(intPlayerNumber, p);
                break;
                default:
                    throw new IllegalArgumentException("numero di giocatori non consentito!");
            }
            games.add(g);
        }
    }

    @Override
    public String toString() {
        return "MyShelfie{" +
                "games=" + games.toString() +
                '}';
    }

    public ArrayList<Game> getGames() {
        return games;
    }
    public Game getGame(int id_game) {
        for (int i = 0; i < games.size(); i++) {
            if (id_game == games.get(i).getCurrent_game_id()){
                return games.get(i);
            }
        }
        return null;
    }
}
