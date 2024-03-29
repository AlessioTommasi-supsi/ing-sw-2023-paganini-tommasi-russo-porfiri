package org.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.controller.Controller;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.Client;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.Server;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.DrawFromBoardMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ControllerTest {

    @Test
    public void testUpdate() throws Exception {
        Player player = new Player("Player1");
        player.setId(1);
        Turn model = new Turn();
        MyShelfie myShelfie = new MyShelfie();
        myShelfie.joinGame(2, player);
        Player player1 = new Player("Player2");
        player1.setId(2);
        myShelfie.getGames().get(0).addPlayer(player1);
        model.setMyShelfie(myShelfie);
        Server server = new ServerImpl(model);
        ClientImpl client = new ClientImpl(server);
        Controller controller = new Controller(model, client);
        ChoiceMyShelfie choiceMyShelfie = ChoiceMyShelfie.DRAW_FROM_BOARD;

        int[] ordine = new int[1];
        ordine[0] = 1;
        ArrayList<TilePositionBoard> positions = new ArrayList<TilePositionBoard>();
        positions.add(new TilePositionBoard(3,1));
        DrawFromBoardMessage argument = new DrawFromBoardMessage(positions, 0, model.getMyShelfie().getGames().get(0).getCurrentGameId(), ordine);

        Choice choice = new Choice(
                choiceMyShelfie,
                model.getMyShelfie().
                        getGame(    model.getMyShelfie().getGames().get(0).getCurrentGameId()   ).getCurrentPlayer(),
                argument);

        ArrayList<TilePositionBoard> BordBefore = controller.getModel().getMyShelfie().getGames().get(0).getBoard().getPlacements();
        controller.update(client, choice);
        ArrayList<TilePositionBoard> BoardAfter = controller.getModel().getMyShelfie().getGames().get(0).getBoard().getPlacements();

        assertNotEquals(BordBefore.toString(), BoardAfter.toString());
        controller.getClient();
    }
}
