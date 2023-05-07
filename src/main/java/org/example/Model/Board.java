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
    private TileObjBag bag;

    
    //sarà il gioco a creare i placements giusti in base a quante persone ho!
    public Board(ArrayList<TilePositionBoard> extPlacements, TileObjBag extBag) {
        this.placements = new ArrayList<TilePositionBoard>();
        for (TilePositionBoard p :extPlacements) {
            this.placements.add(new TilePositionBoard(p));
        }
        this.bag= new TileObjBag(extBag);
    }


    public Board(Board extBoard) {
        this.placements = extBoard.getPlacements();
        this.bag= extBoard.getBag();
    }


    public Board() {
        this.placements = new ArrayList<TilePositionBoard>();
        this.bag = new TileObjBag();
        protoBoard();
        addTiles();
    }


    public ArrayList<TilePositionBoard> getPlacements() {
        return new ArrayList<TilePositionBoard>(placements);
    }

    public TileObjBag getBag() {
        return new TileObjBag(this.bag);
    }


    public ArrayList<TilePositionBoard> showBoard() {
        return this.getPlacements();
    }  //fa stessa cosa di getPlacement (ci serve?)


    public void setPlacements(ArrayList<TilePositionBoard> extPlacements) {
        this.placements.addAll(extPlacements);
    }


    private void protoBoard(){
        int i=1;
        int j;

        for(j=4; j<6; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=2;
        for(j=3; j<6; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=3;
        for(j=1; j<7; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=4;
        for(j=1; j<8; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=5;
        for(j=2; j<8; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=6;
        for(j=3; j<6; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
        i=7;
        for(j=3; j<5; j++){
            this.placements.add(new TilePositionBoard(i,j));
        }
    }


    public void addTiles(){
        for(TilePositionBoard p : this.placements){
            if(this.bag.BagSize()!= 0){
                try {
                    p.setTile(this.bag.extractFromBag());
                } catch (PositionAlreadyOccupiedException e) {
                    continue;
                }
            }
            else break;
        }
    }  //metodo che userò anche per riempire la board quando vuota


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


    //metodo che verifica che la board è vuota oppure contiene ancora solo tessere isolate

}