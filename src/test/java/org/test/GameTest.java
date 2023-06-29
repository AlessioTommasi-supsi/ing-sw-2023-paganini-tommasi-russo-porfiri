package org.test;
import org.junit.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

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

    @Test
    public void testOthers() throws Exception {
        Player player = new Player("P");
        player.setId(0);
        Player player1 = new Player("A");
        player1.setId(1);
        Game game = new GameTwoPlayers(2, player);
        game.setCurrentGameId(0);
        game.addPlayer(player1);
        game.setCurrentPlayer(player1);
        game.nextCurrentPlayer();
        Player player2 = game.precCurrentPlayer();
        assertEquals(player2, game.precCurrentPlayer());
        assertNotEquals(game.toString(), "");
        game.startPartita();
        assertEquals(game.getState(), GameStatus.IN_PROGRESS);
        assertNotNull(game.getInstanceBoard());
        game.getPlayer(0);
    }

    @Test
    public void testOther2() {
        Player player = new Player("P");
        player.getShelves().addTile(new TilePositionShelves(0,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(0,1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(0,2, new TileObj(TileType.CAT, TileVariant.VARIANT_THREE)));
        player.getShelves().addTile(new TilePositionShelves(0,3, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,0, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,1, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        player.getShelves().addTile(new TilePositionShelves(1,2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        player.getShelves().addTile(new TilePositionShelves(1,3, new TileObj(TileType.CAT, TileVariant.VARIANT_TWO)));
        Game game1 = new GameTwoPlayers(2, player);
        Game game2 = new GameThreePlayers(3, player);
        Game game3 = new GameFourPlayers(4, player);
        game1.defineCommonCardScores();
        game2.defineCommonCardScores();
        game3.defineCommonCardScores();
        CommonCard common = new CommonCardShape(5);
        game1.setCommon1(common);
        game2.setCommon1(common);
        game3.setCommon1(common);
        game1.updatePointsCommon();
        game2.updatePointsCommon();
        game3.updatePointsCommon();
        boolean result = game1.isFullLibrary();
        assertEquals(result, game1.isFullLibrary());
        game1.setCommonCardScores(game2.getCommonCardScores());
        game1.getCommonCardScores();
        ArrayList<Ranking> ranking = game1.getRank();
        assertEquals(ranking, game1.getRank());
        game1.addChatMessage("test");
        ArrayList<String> chat = game1.getChat();
        assertEquals(chat, game1.getChat());
        ArrayList<PersonalCard> personalCards = game1.getPersonalCardDeck();
        assertEquals(personalCards, game1.getPersonalCardDeck());
    }
}