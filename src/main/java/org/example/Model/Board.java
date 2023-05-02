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
    private ArrayList<TilePositionBoard> placements;

    
    //sarà il gioco a creare i placements giusti in base a quante persone ho!
    public Board(ArrayList<TilePositionBoard> extPlacements) {
        this.placements = new ArrayList<TilePositionBoard>();
        for (TilePositionBoard p :extPlacements) {
            this.placements.add(new TilePositionBoard(p));
        }
    }


    public Board(Board extBoard) {
        this.placements = extBoard.getPlacements();
    }


    public Board() {
        this.placements = new ArrayList<TilePositionBoard>();
    }


    public ArrayList<TilePositionBoard> getPlacements() {
        return new ArrayList<TilePositionBoard>(placements);
    }


    public ArrayList<TilePositionBoard> showBoard() {
        return this.getPlacements();
    }  //fa stessa cosa di getPlacement (ci serve?)


    public void setPlacements(ArrayList<TilePositionBoard> extPlacements) {
        this.placements = new ArrayList<TilePositionBoard>();
        for (TilePositionBoard p :extPlacements) {
            this.placements.add(new TilePositionBoard(p));
        }
    }


    public boolean tileIsRemovable(TilePositionBoard position){
        int x = position.getX();
        int y = position.getY();

        //la posizione è svuotabile se contiene un tile e ha almeno un lato adiacente libero
        if(position.isOccupied()){
            for(TilePositionBoard item : placements){
                if ((item.getX()==x && (item.getY()==y-1 || item.getY()==y+1)) || ((item.getX()==x-1 || item.getX()==x+1) && item.getY()==y)) {
                    if(!item.isOccupied()){
                        return true; //lo slot position ha almeno un lato adiacente vuoto.
                    }
                }
            }
        }
        return false;
    }


    public ArrayList<TileObj> removeTiles(ArrayList<TilePositionBoard> tilesToRemove) throws TilesAreNotRemovableException, PositionEmptyException {
        ArrayList<TileObj> TilesRemoved = new ArrayList<TileObj>();

        if((tilesToRemove.size() < 1) || (tilesToRemove.size() > 3)){
            throw new TilesAreNotRemovableException();
        }
        else {
            for (int i = 0; i < tilesToRemove.size(); i++) {
                if (!this.tileIsRemovable(tilesToRemove.get(i))) {
                    throw new TilesAreNotRemovableException();
                }
            }
            for (int i = 0; i < tilesToRemove.size(); i++) {
                TilesRemoved.add(tilesToRemove.get(i).removeTile());
            }
            return TilesRemoved;
        }

    }


}