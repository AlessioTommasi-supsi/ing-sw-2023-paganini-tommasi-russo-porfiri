package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.controller;

import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.distributed.Client;
import it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model.*;

import java.util.ArrayList;
import java.util.Random;

public class Controller1 {
    private final Game model;
    private final Client client;

    private final Random RAND = new Random();

    public Controller1(Game model, Client client) {
        this.model = model;
        this.client = client;
    }

    private Outcome computeOutcome() { /*parte elaborativa fatta dal client*/
        //elabro risposta da inviare a client!!!
        /*qui devo fare computazione e ritornare qualcosa alla view!!*/
        return Outcome.WIN;
    }

    //MY SHELFIE
    public void CreateMyShelfie(){

    }

    public void displayBoard(){

    }

    public void start(){

    }

    public void end(){

    }

    public int calculatePoins(){
        return 0;
    }

    public void getGoal(){

    }

    public void removeTile(){

    }

    public void getCardGoal(){

    }

    public void displayShelves(){

    }

    public void putTile(TilePositionShelves pt){

    }

    public ArrayList<Ranking> getRanking(){
        return null;
    }

    //END MY SHELFIE

    public void update(Client o, Choice_my_shelfie scelta_client, ArrayList params /*parametri che passro in base alla scelta fatta!*/) {
        if (!o.equals(client)) {
            System.err.println("CLIENT NON CORRETTO! DISCONNESSIONE!! " + o);
            return;
        }

        try {
            switch (scelta_client) {
                case PESCA_FROM_PLANCIA:
                    model.setOutcome("hai selezionato: PESCA_FROM_PLANCIA" );
                break;
                case IMMMETTI_IN_LIBRERIA:
                    model.setOutcome("hai selezionato: IMMMETTI_IN_LIBRERIA" );
                break;
                case TERMINA_TURNS:
                    model.setOutcome("hai selezionato: TERMINA_TURNS" );
                break;
                default:
                    throw new IllegalStateException("la scelta presente nel model non e'tra quelle possibili: " + model.getCpuChoice());
            }

        }catch (Exception e){
            model.setOutcome("si e' verificato un errore: "+ e.getMessage() );
            e.printStackTrace();
        }
    }


}