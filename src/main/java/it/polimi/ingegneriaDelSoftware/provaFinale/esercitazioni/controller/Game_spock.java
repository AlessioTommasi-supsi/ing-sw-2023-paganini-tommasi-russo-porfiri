package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.controller;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed.Client;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Outcome;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Turn;

import java.util.Random;

public class Game_spock {
    private final Turn model;
    private final Client client;

    private final Random RAND = new Random();

    public Game_spock(Turn model, Client client) {
        this.model = model;
        this.client = client;
    }





    public void update(Client o,Choice arg) {
        if (!o.equals(client)) {
            System.err.println("CLient NON corretto! Discarding notification from " + o);
            return;
        }
        //model.setPlayerChoice(arg);
        //System.out.println(arg.getArgument().toString());
        switch (arg.getChoiche()) {
            case IMMMETTI_IN_LIBRERIA:
                System.out.println(arg.getArgument().toString());
                model.setOutcome(Outcome.WIN);
            break;
            case PESCA_FROM_PLANCIA:

                model.setOutcome(Outcome.LOSE);
            break;
            case TERMINA_TURNS:
                model.setOutcome(Outcome.DRAW);
            break;
        }

        //OLD

        /* CPU chooses */
        //elaborazioni sul model part
        //model.setCpuChoice(askCpu());
        /* Clean State */
        model.clear();
    }

}