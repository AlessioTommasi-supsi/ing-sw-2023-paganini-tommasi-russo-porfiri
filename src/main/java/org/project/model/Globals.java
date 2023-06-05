package org.project.model;

public class Globals {
    private static Globals globals;
    private static int playerId = 1;

    public static Globals getInstance() {
        if (globals == null) {
            globals = new Globals();
        }
        return globals;
    }

    private static int gameId = 1;
    public synchronized static int incrementPlayerId() {
        playerId++;
        //System.out.println("incrementPlayerId: "+player_id);
        return playerId -1;
    }

    public synchronized static int incrementGameId() {
        gameId++;
        return gameId -1;
    }
}
