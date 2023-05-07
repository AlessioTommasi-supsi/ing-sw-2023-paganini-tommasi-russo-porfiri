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





    public void update(Client o,Choice arg) {
        try {

            if (!o.equals(client)) {
                System.err.println("CLient NON corretto! Discarding notification from " + o);
                return;
            }

            model.setPlayerChoice(arg);
            if (arg.getChoiche() != Choice_my_shelfie.GET_STATE)
                System.out.println("hai effettuato la seguente scelta: "+arg.toString());

            switch (arg.getChoiche()) {
                case JOIN_GAME:
                    if (model.getMyShelfie() == null) {
                        model.setMyShelfie(new MyShelfie());
                    }
                    int numero_giocatori = (Integer) arg.getArgument();
                    model.setGame(model.getMyShelfie().joinGame(numero_giocatori,arg.getPlayer()));


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

        if (arg.getChoiche() != Choice_my_shelfie.GET_STATE)
            System.out.println("Risposta: "+model.toString());

        model.NotifyClient();
        model.clear();
    }

}