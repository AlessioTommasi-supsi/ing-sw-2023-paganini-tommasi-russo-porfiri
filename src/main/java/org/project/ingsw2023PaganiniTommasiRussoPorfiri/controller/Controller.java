package org.project.ingsw2023PaganiniTommasiRussoPorfiri.controller;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.DrawFromBoardMessage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.SendMessage;

import java.util.ArrayList;

public class Controller {
    private final Turn model;
    private final Client client;

    public Controller(Turn model, Client client) {
        this.model = model;
        this.client = client;
    }

    public synchronized void update(Client o,Choice arg) {
        try {

            model.setPlayerChoice(arg);

            switch (arg.getChoice()) {
                case JOIN_GAME:
                    if (model.getMyShelfie() == null) {
                        model.setMyShelfie(new MyShelfie());
                    }
                    int numberOfPlayers = (Integer) arg.getArgument();

                    model.getMyShelfie().joinGame(numberOfPlayers,arg.getPlayer());

                    if(arg.getPlayer().getId() == -1){
                        arg.getPlayer().setId(Globals.incrementPlayerId());
                    }
                     //.DEBUG
                    System.err.println("Games number: "+model.getMyShelfie().getGames().size());
                    /*
                    model.getMyShelfie().getGames().stream()
                            .forEach(game -> System.out.println("new game: "+game.toString()));
                    `*/
                break;

                case DRAW_FROM_BOARD:
                    DrawFromBoardMessage drawMessage = (DrawFromBoardMessage) arg.getArgument();
                    //RIMOZIONE DA BOARD
                    ArrayList<TileObj> tilesRemoved = model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).getBoard().removeTiles(drawMessage.getTilesToRemove());
                    //IMMETTI IN LIBRERIA
                    //sicuramente dovrò modificare la libreria del player corrente!
                    try {
                        model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).getCurrentPlayer().putTilesInShelf(tilesRemoved, drawMessage.getColumnOfShelves(), drawMessage.getOrdine());
                    }catch (IllegalSizeOfTilesException e1){
                        //devo rimettere le tessere nella plancia!
                        model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).getBoard().addTiles(drawMessage.getTilesToRemove());
                        //DEFAULT
                        model.error = e1.getClass().getSimpleName();
                        e1.printStackTrace();
                    }catch (IllegalColumnException e2){
                        //devo rimettere le tessere nella plancia!
                        model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).getBoard().addTiles(drawMessage.getTilesToRemove());
                        //DEFAULT
                        model.error = e2.getClass().getSimpleName();
                        e2.printStackTrace();
                    }catch (FullLibraryException e3){
                        //al termine del giro dei giocatori la partita deve finire!
                        model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).fullLibrary();
                    }

                    //.DEBUG
                    //System.err.println("BOARD: ");
                    //model.getMyShelfie().getGame(drawMessage.getCurrentGameId()).getBoard().printTilePositionBoard(null);
                break;
                case SEND_MESSAGE:
                    SendMessage message = (SendMessage) arg.getArgument();
                    model.getMyShelfie().getGame(message.getCurrentGameId()).addChatMessage(message.getMessage());

                break;
                case TERMINATE_TURNS:
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).nextCurrentPlayer();
                    //se necessario ripristino la board!
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).getBoard().restoreBoard();
                    //aggiornamento punti comuni
                    //MATTIA CONTROLLA PERCHE NON VA!
                    try {
                        model.getMyShelfie().getGame((Integer) arg.getArgument()).updatePointsCommon();
                    }catch (Exception e){
                        //va ignorata poiché si genera quando un giocatore non ha tessere in libreria nella posizione successiva a quella controllata!
                        System.err.println("Error generated by: updatePointsCommon");
                        e.printStackTrace();
                    }
                    //funzionalità di fine partita
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).end();


                    break;
                case EXIT:
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).fullLibrary();

                    break;
            }
        }catch (Exception e){
            model.error = e.getClass().getSimpleName();
            e.printStackTrace();
        }


        model.NotifyClient();
        model.clear();
    }

    public Turn getModel() {
        return model;
    }

    public Client getClient() {
        return client;
    }
}