package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import java.io.Serializable;
import java.util.ArrayList;
public class MyShelfie implements Serializable {
    private ArrayList<Game> games;

    public MyShelfie() {
        games = new ArrayList<Game>();
    }

    public MyShelfie(MyShelfie extMyShelfie){
        this.games = new ArrayList<>(extMyShelfie.getGames());
    }

    public void joinGame(int intPlayerNumber, Player p ) throws Exception{
        //controllo che il player non sia gia attivo in qualche altra partita
        for (Game game: games) {
            for (Player player: game.getPlayers()) {
                switch (game.getState()){
                    case IN_WAIT://
                    case IN_PROGRESS:
                        if (player.getUsername().equals(p.getUsername())) {
                            throw new IllegalArgumentException("The player is already active or queued in some other game!");
                        }
                }
            }
        }
        //esistono partite con gia quel numero di giocatori in attesa:
        int i =0;
        for (Game game: games) {
            switch (game.getState()){
                case IN_WAIT:
                    if (game.getPlayerNumber() == intPlayerNumber) {
                        game.addPlayer(p);
                        return;
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
                    throw new IllegalArgumentException("Number of players not allowed!");
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
    public Game getGame(int idGame) {
        for (int i = 0; i < games.size(); i++) {
            if (idGame == games.get(i).getCurrentGameId()){
                return games.get(i);
            }
        }
        return null;
    }
}
