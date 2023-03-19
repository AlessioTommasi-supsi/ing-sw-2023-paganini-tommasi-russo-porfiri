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




    public Set<TilePosition> displayBoard() {
        // TODO implement here
        return null;
    }


    public void deleteTiles(Set<TilePosition> p) {
        // TODO implement here
    }

    public void setTile(TileObj t, int x, int y) {
        // TODO implement here
    }

    // diminuisci i punti delle carte CommonCard in base al numero di persone
    public TileObj removeTile(int x, int y)throws Exception{
        TileObj ap;
        for (int i = 0; i < this.placement.size(); i++) {
            if ((this.placement.get(i).getX() == x) && (this.placement.get(i).getY() == y)) {
                if (!placement.get(i).isOccupied()) {
                    //devo ancora implementare la funzionalita che posso rimuovere delle tessere sse non sono bloccate da almeno 2 altre tessere!
                    
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



}