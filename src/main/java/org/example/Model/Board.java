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
    public Board(ArrayList<TilePositionBoard> placement, TileObjBag bag, CommonDeck commonDeck) {
        this.placement = placement;
        this.bag = bag;
        this.commonDeck = commonDeck;
    }

    public Board(Board board) {
        this.placement = board.getPlacement();
        this.bag = board.getBag();
        this.commonDeck = board.getCommonDeck();
    }

    public Board() {
        this.commonDeck = new CommonDeck();
        this.personalDeck = new PersonalDeck();
        this.bag = new TileObjBag();
        //qui mi costruisco le posizioni (placement) in base al numero di giocatori!!

    }

    public ArrayList<TilePositionBoard> getPlacement() {
        return new ArrayList<TilePositionBoard>(placement);
    }

    public ArrayList<TilePositionBoard> showBoard() {
        return this.getPlacement();
    }


    public TileObjBag getBag() {
        return bag;
    }

    public void setBag(TileObjBag bag) {
        this.bag = bag;
    }

    public CommonDeck getCommonDeck() {
        return commonDeck;
    }

    public void setCommonDeck(CommonDeck commonDeck) {
        this.commonDeck = commonDeck;
    }


    public void setTile(TileObj t, int x, int y) {
        // TODO implement here
    }

    // diminuisci i punti delle carte CommonCard in base al numero di persone
    public boolean isTileRemovible(int x, int y)throws Exception{
        //controlli che la tssera non sia bloccata da altri!!
        return true;
    }

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
    public TileObj remove1Tile(TilePositionBoard position) throws Exception {
        if(tileIsRemovable(position)){
            TileObj tempTile = position.removeTile();
            return tempTile;
        }
        else throw new Exception("impossibile rimuovere da questa posizione");

    }

    //public TileObj[] remove2Tile(qualcosa){...}
    // public TileObj[] remove3Tile(qualcosa){...}


    //QUESTO METODO Ea RICHIAMABILE  DA IsRemovable()
    private TileObj removeTile(int x, int y)throws Exception{
        TileObj ap;
        for (int i = 0; i < this.placement.size(); i++) {
            if ((this.placement.get(i).getX() == x) && (this.placement.get(i).getY() == y)) {
                if (!placement.get(i).isOccupied()) {
                    //aggiunta oggetto vuoto nella posizione e ritorno di tyleobject al chiamante
                    ap = placement.get(i).getTile();
                    placement.remove(i);
                    placement.add(i,new TilePositionBoard(x,y));
                    return ap;
                } else {
                    throw new IllegalAccessException("non puoi rimuovere la tessera dalla posizione indicata poiche risulta essere una posizione vuota!! ");
                }
            }
        }
        throw new IllegalAccessException("la posizione indicata non e tra quelle disponibili del gioco.");
    }

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