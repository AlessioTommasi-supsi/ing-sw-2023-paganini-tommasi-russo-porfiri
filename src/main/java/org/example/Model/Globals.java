package org.example.Model;

public class Globals {
    private static int player_id = 1;

    private static int game_id = 1;
    public synchronized static int incrementPlayer_id() {
        player_id++;
        return player_id -1;
    }

    public synchronized static int increment_Game_id() {
        game_id++;
        return game_id -1;
    }
}