package org.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.model.*;

public class MyShelfieTest {

    private MyShelfie shelfie;

    @BeforeEach
    public void setUp() {
        shelfie = new MyShelfie();
    }

    @Test
    public void testJoinGame_Success() throws Exception {
        Player player = new Player("Alice");
        shelfie.joinGame(2, player);
        Game game = shelfie.getGames().get(0);
        Assertions.assertEquals(2, game.getPlayerNumber());
        Assertions.assertEquals(player.getUsername(), game.getPlayers().get(0).getUsername());
        Assertions.assertEquals(player.getUsername(), game.getDealer().getUsername());
        Assertions.assertEquals(GameStatus.IN_WAIT, game.getStato());
    }

    @Test
    public void testJoinGame_PlayerAlreadyActive() {
        Player player = new Player("Bob");

        Game game1 = new GameTwoPlayers(2, player);
        shelfie.getGames().add(game1);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shelfie.joinGame(3, player);
        });

        String expectedMessage = "il player e gia attivo o in coda in qualche altra partita";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testJoinGame_GameWithSamePlayerNumberExists() throws Exception {
        Player player1 = new Player("Charlie");
        Player player2 = new Player("Dave");

        Game game1 = new GameTwoPlayers(2, player1);
        Game game2 = new GameTwoPlayers(2, player2);
        shelfie.getGames().add(game1);
        shelfie.getGames().add(game2);

        shelfie.joinGame(2, new Player("Eve"));

        Game game = shelfie.getGames().get(0);//Eve dovrebbe essersi unita qui perche e' il primo gioco aggiunto!
        Assertions.assertEquals(GameStatus.IN_PROGRESS, game.getStato());
    }

    @Test
    public void testJoinGame_CreatingGameWithDifferentPlayerNumber() throws Exception {
        Player player = new Player("Frank");

        Game game1 = new GameTwoPlayers(2, new Player("Grace"));
        Game game2 = new GameThreePlayers(3, new Player("Henry"));
        shelfie.getGames().add(game1);
        shelfie.getGames().add(game2);

        shelfie.joinGame(4, player);


        Assertions.assertEquals(3, shelfie.getGames().size());

        //verifico che tutti i giochi devono essere nello stato IN ATTESA
        for (Game game : shelfie.getGames()) {
            Assertions.assertEquals(GameStatus.IN_WAIT, game.getStato());
        }

        //aggiungo giocatori ad ogni gioco fino ad arrivare alla quantita definita da playerNumber
        for (Game game : shelfie.getGames()) {
            while (game.getPlayers().size() < game.getPlayerNumber()) {
                shelfie.joinGame(game.getPlayerNumber(), new Player("Ivy: "+game.getPlayerNumber() + " "+game.getPlayers().size()));
            }
        }
        //verifico che tutti i giochi devono essere nello stato IN CORSO
        for (Game game : shelfie.getGames()) {
            Assertions.assertEquals(GameStatus.IN_PROGRESS, game.getStato());
        }
    }

    @Test
    public void testJoinGame_InvalidPlayerNumber() {
        Player player = new Player("Ivy");

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shelfie.joinGame(5, player);
        });

        String expectedMessage = "numero di giocatori non consentito!";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}