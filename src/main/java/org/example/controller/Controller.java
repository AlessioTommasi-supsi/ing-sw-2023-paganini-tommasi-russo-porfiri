package org.example.controller;

import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;

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
                    int numero_giocatori = (Integer) arg.getArgument();

                    model.getMyShelfie().joinGame(numero_giocatori,arg.getPlayer());

                    if(arg.getPlayer().getId() == -1){
                        arg.getPlayer().setId(Globals.incrementPlayerId());
                    }
                     //.DEBUG
                    System.err.println("num Giochi: "+model.getMyShelfie().getGames().size());
                    model.getMyShelfie().getGames().stream()
                            .forEach(game -> System.out.println("nuovo gioco: "+game.toString()));

                break;

                case DRAW_FROM_BOARD:
                    drawFromBoardMessage drow_message = (drawFromBoardMessage) arg.getArgument();
                    //RIMOZIONE DA BOARD
                    ArrayList<TileObj> tilesRemoved = model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).getBoard().removeTiles(drow_message.getTilesToRemove());
                    //IMMETTI IN LIBRERIA
                    //sicuramente dovro modificare la libreria del player corrente!
                    try {
                        model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).getCurrentPlayer().putTilesInShelf(tilesRemoved, drow_message.getColumnOfShelves(), drow_message.getOrdine());
                    }catch (IllegalSizeOfTilesException e1){
                        //devo rimettere le tessere nella plancia!
                        model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).getBoard().addTiles(drow_message.getTilesToRemove());
                        //DEFULT
                        model.errore = e1.toString();
                        e1.printStackTrace();
                    }catch (IllegalColumnException e2){
                        //devo rimettere le tessere nella plancia!
                        model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).getBoard().addTiles(drow_message.getTilesToRemove());
                        //DEFULT
                        model.errore = e2.toString();
                        e2.printStackTrace();
                    }catch (FullLibraryException e3){
                        //al termine del giro dei giocatori la partita deve finire!
                        model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).full_library();
                    }
                    //.DEBUG
                    System.err.println("BOARD: ");
                    model.getMyShelfie().getGame(drow_message.getCurrent_game_id()).getBoard().printTilePositionBoard(null);
                    break;
                case TERMINATE_TURNS:
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).nextCurrentPlayer();
                    //se necessario ripristino la board!
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).getBoard().restoreBoard();
                    //aggiornamento punti comuni
                    //MATTIA CONTROLLA PERCHE NON VA!
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).updatePointsCommon();
                    //funzionalità di fine partita
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).end();


                    break;
                case EXIT:
                    model.getMyShelfie().getGame((Integer) arg.getArgument()).full_library();

                    break;
            }
        }catch (Exception e){
            model.errore = e.toString();
            e.printStackTrace();
        }


        model.NotifyClient();
        model.clear();
    }

}