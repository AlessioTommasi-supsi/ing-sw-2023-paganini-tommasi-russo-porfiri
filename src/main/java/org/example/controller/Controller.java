package org.example.controller;

import org.example.Model.*;
import org.example.distributed.*;
import org.example.util.*;
import org.example.view.*;
import org.example.controller.*;

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

                break;
                case IMMMETTI_IN_LIBRERIA:
                    //prima devo aver fatto pesca from plancia!!
                    /**
                     * arg.getArgument{
                     *     ArrayList <TilePositionShelves>
                     * }
                     * */
                    //System.out.println(arg.getArgument().toString());
                    System.out.println("hai scelto immetti in libreria");

                    //model.setOutcome(Outcome.WIN);
                    break;
                case PESCA_FROM_PLANCIA:

                    break;
                case TERMINA_TURNS:

                    break;
            }
        }catch (Exception e){
            model.errore = e.toString();
        }


        model.NotifyClient();
        model.clear();
    }

}