package org.example.Model;

import java.util.*;
/**
 * Faccio un array dove per ogni riga ho una mappa con il tipo di tessera come chiave e poi tutti i dati associati a quella tessera così d
 *
 * Per istanziare la plancia posso fare un ARRAY di ArrayList :
 * 1)      0 -> 1-> 2
 * 2)      0->1->2->3
 * 3)      0->1->2->3->4
 * 4)      0->1->2
 *
 * Faccio un quadrato e poi aggiungo quelli "extra
 */
/**
 * 
 */
public class Board{
    private ArrayList<TilePositionBoard> placement;
    private TileObjBag bag;
    private CommonDeck commonDeck;
    private PersonalDeck personalDeck;


    //sara il gioco a creare i placement giusti in base a quante persone ho!!
    public Board(ArrayList<TilePositionBoard> extPlacement, TileObjBag extBag, CommonDeck extCommonDeck, PersonalDeck extPersonalDeck) {

        this.placement = new ArrayList<TilePositionBoard>;
        for (TilePositionBoard p :extPlacement) {
            this.placement.add(new TilePositionBoard(p));
        }

        this.bag= new TileObjBag(extBag);

        this.commonDeck= extCommonDeck;     //da riscrivere
        this.personalDeck= extPersonalDeck;  //da riscrivere

    }

    public Board(Board extBoard) {
        this.placement= extBoard.getPlacement();
        this.bag= extBoard.getBag();
        this.commonDeck= extBoard.getCommonDeck();
        this.personalDeck= extBoard.getPersonalDeck();
    }

    public Board() {
        this.placement = new ArrayList<TilePositionBoard>();
        this.bag = new TileObjBag();
        this.commonDeck = new CommonDeck();       //da riscrivere
        this.personalDeck = new PersonalDeck();   //da riscrivere
        //qui mi costruisco le posizioni (placement) in base al numero di giocatori!!

    }

    public ArrayList<TilePositionBoard> getPlacement() {
        return new ArrayList<TilePositionBoard>(placement);
    }

    public TileObjBag getBag() {
        return new TileObjBag(this.bag);
    }

    public CommonDeck getCommonDeck() {
        return commonDeck;  //da riscrivere
    }

    public PersonalDeck getPersonalDeck() {
        return personalDeck;  //da riscrivere
    }

    public ArrayList<TilePositionBoard> showBoard() {
        return this.getPlacement();
    }  //fa stessa cosa di getPlacement


    // diminuisci i punti delle carte CommonCard in base al numero di persone (a quale metodo è riferito?)


    public boolean tileIsRemovable(TilePositionBoard position){
        int x = position.getX();
        int y = position.getY();

        //la posizione è svuotabile se contiene un tile e ha almeno un lato adiacente libero
        if(position.isOccupied()){
            for(TilePositionBoard item : placement){
                if ((item.getX()==x && (item.getY()==y-1 || item.getY()==y+1)) || ((item.getX()==x-1 || item.getX()==x+1) && item.getY()==y)) {
                    if(!item.isOccupied()){
                        return true; //lo slot position ha almeno un lato adiacente vuoto.
                    }
                }
            }
        }
        return false;
    }

//controller
    private TileObj remove1Tile(TilePositionBoard position) throws Exception {
        if(tileIsRemovable(position)){
            TileObj tempTile = position.removeTile();
            return tempTile;
        }
        else throw new Exception("impossibile rimuovere da questa posizione");

    }

    //public TileObj[] remove2Tile(qualcosa){...}
    // public TileObj[] remove3Tile(qualcosa){...}


    //QUESTO METODO Ea RICHIAMABILE  DA IsRemovable()

    //devo ancora implementare la funzionalita che posso rimuovere delle tessere sse non sono bloccate da almeno 2 altre tessere!
    //fine controllo tessere
    public ArrayList<TileObj> removeTile(ArrayList<TilePositionBoard> tile_to_remove)throws Exception{
        ArrayList<TileObj> tile_removed = new ArrayList<TileObj>();
        for (int i = 0; i < tile_to_remove.size(); i++) {
            if (!this.tileIsRemovable(tile_to_remove.get(i))) {
                throw new Exception("impossibile rimuovere da questa posizione");
            }
        }

        for (int i = 0; i < tile_to_remove.size(); i++) {
            tile_removed.add(this.remove1Tile(tile_to_remove.get(i)));
        }

        return tile_removed;
    }


}