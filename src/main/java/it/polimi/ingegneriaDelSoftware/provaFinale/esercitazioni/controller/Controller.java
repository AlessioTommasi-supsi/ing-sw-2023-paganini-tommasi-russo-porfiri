package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.controller;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed.Client;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Choice;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.Turn;

public class Controller {
    private final Turn model;
    private final Client client;

    public Controller(Turn model, Client client) {
        this.model = model;
        this.client = client;
    }





    public void update(Client o,Choice arg) {

        System.out.println("Game_spock  update "+arg.getChoiche());

        if (!o.equals(client)) {
            System.err.println("CLient NON corretto! Discarding notification from " + o);
            return;
        }
        //arg.setStato(Turn.Event.OUTCOME);//inutile perche in setPlayerChoice la setto come CPU_CHOICHE
        model.setPlayerChoice(arg);
        //System.out.println(arg.getArgument().toString());
        switch (arg.getChoiche()) {
            case IMMMETTI_IN_LIBRERIA:
                System.out.println(arg.getArgument().toString());
                //model.setOutcome(Outcome.WIN);
            break;
            case PESCA_FROM_PLANCIA:

                //model.setOutcome(Outcome.LOSE);
            break;
            case TERMINA_TURNS:
                //model.setOutcome(Outcome.DRAW);
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