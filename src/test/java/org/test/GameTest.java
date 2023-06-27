package org.test;
import org.junit.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        //lo testo su due giocatori, ma è uguale per 3 o 4
        game = new GameTwoPlayers(2, new Player("pippo"));

    }

    @Test
    public void testAddPlayer() throws Exception {

        game = new GameTwoPlayers(2, new Player("paperino"));
        Player player = new Player("gian giacomo giovanni");
        game.addPlayer(player);

        assertEquals(2, game.getPlayers().size());
        assertTrue(game.getPlayers().contains(player));
    }

    @Test
    public void testEnd() throws Exception {

        game = new GameTwoPlayers(2, new Player("topolino"));

        Player player = new Player("gian giacomo giovanni");
        game.addPlayer(player);


        game.fullLibrary();

        game.end();
        assertEquals(GameStatus.OVER, game.getState());

        //tesst ranking currentplayer dovrebbe avere 1 punto (quindi essere) mentre l altro 0
        //indice dell attributo ranking e Indice del player che in base ai punti totalizzati nella partita
        //rank e'lista dei player ordinata in base al loro punteggio (dal piu alto al piu basso)
        assertEquals(1, game.getRanking().get(0).getPoints());
        assertEquals(0, game.getRanking().get(1).getPoints());

    }

    @Test(expected = Exception.class)
    public void testAddPlayerAlredyStartedGame() throws Exception {
        Player player = new Player("gian giacomo giovanni");
        game.startPartita(); // Avvio della partita
        // Aggiunta di un giocatore quando la partita è in corso (stato diverso da IN_ATTESA)
        game.addPlayer(player);

    }
}