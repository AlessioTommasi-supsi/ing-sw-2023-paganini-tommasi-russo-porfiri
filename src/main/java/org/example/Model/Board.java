package org.example.Model;

import org.example.util.PositionAlreadyOccupiedException;
import org.example.util.PositionEmptyException;
import org.example.util.TilesAreNotRemovableException;

import java.io.Serializable;
import java.util.*;


public class Board implements Serializable {
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

    public void addTiles(ArrayList<TilePositionBoard> tilesRemoved){
        for(TilePositionBoard p : tilesRemoved){
            try {
                this.placements.add(p);
            } catch (Exception e) {
                continue;
            }
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

        //inizializzazione corretta degli elementi!
        //ERRORE RIMUOVO DA DELLE POSIZIONI CHE CONTERRANO SEMPRE IS OCCUPIED = FALSE
        for (int i =0; i<tilesToRemove.size();i++) {
            for (int j = 0; j < this.placements.size(); j++) {
                if (this.placements.get(j).equals(tilesToRemove.get(i))) {
                    tilesToRemove.remove(i);
                    tilesToRemove.add(this.placements.get(j));
                }
            }
        }
        //.DEBUG
        /*
        for(int i = 0; i< tilesToRemove.size(); i++){
            System.out.println(tilesToRemove.get(i).toString());
        }
        */

        if((tilesToRemove.size() < 1) || (tilesToRemove.size() > 3)){
            throw new TilesAreNotRemovableException();
        }

        else {
            for (int i = 0; i < tilesToRemove.size(); i++) {
                /* E! QUESTO CHE NON VA BENE!
                if (!this.tileIsRemovable(tilesToRemove.get(i))) {
                    throw new TilesAreNotRemovableException();
                }
                */
                System.out.println(" til is removable? "+tileIsRemovable(tilesToRemove.get(i)));

            }
            for (int i = 0; i < tilesToRemove.size(); i++) {

                TilesRemoved.add(tilesToRemove.get(i).removeTile());
            }
            //.DEBUG
            //this.printTilePositionBoard(this.placements);

            return TilesRemoved;
        }

    }


    public boolean boardIsEmpty(){
        for(TilePositionBoard t : this.placements){
            if(t.isOccupied()){
                return false;
            }
        }
        return true;
    }


    //la Board va ripristinata in due casi: se contiene solo tessere isolate, oppure se non contiene alcuna tessera.
    public boolean boardNeedsRestore(){
        int x,y;

        if(boardIsEmpty()){
            return true;
        }
        
        for(TilePositionBoard t : this.placements) {
            if(t.isOccupied()){
                x = t.getX();
                y = t.getY();
                for (TilePositionBoard item : placements) {
                    if ((item.getX() == x && (item.getY() == y - 1 || item.getY() == y + 1)) || ((item.getX() == x - 1 || item.getX() == x + 1) && item.getY() == y)) {
                        if (item.isOccupied()) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public void restoreBoard(){
        if(boardNeedsRestore()){
            addTiles();
        }
    }

    //.debug
    public void printTilePositionBoard(ArrayList<TilePositionBoard> board) {
        // Trova le dimensioni massime della matrice
        int maxX = 0;
        int maxY = 0;
        for (TilePositionBoard tile : board) {
            if (tile.getX() > maxX)
                maxX = tile.getX();
            if (tile.getY() > maxY)
                maxY = tile.getY();
        }

        // Crea la matrice 2D
        TilePositionBoard[][] matrix = new TilePositionBoard[maxX + 1][maxY + 1];
        for (TilePositionBoard tile : board) {
            matrix[tile.getX()][tile.getY()] = tile;
        }

        // Stampa la matrice 2D
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                TilePositionBoard tile = matrix[x][y];
                if (tile != null) {
                    System.out.print(tile + " ");
                } else {
                    // Stampa uno spazio vuoto
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }


}