package org.example.Model;

import org.example.util.*;
import java.io.Serializable;
import java.util.*;


public class Board implements Serializable {
    private ArrayList<TilePositionBoard> placements;
    private TileObjBag bag;

    
    //Sarà il gioco a creare i placements giusti in base a quante persone ho!
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
        ArrayList<TilePositionBoard> ap = new ArrayList<TilePositionBoard>();
        for (TilePositionBoard p: this.placements) {
            try{
                ap.add(new TilePositionBoard(p));
            }catch (Exception e){
                continue;
            }
        }
        return ap;
    }

    public TileObjBag getBag() {
        return new TileObjBag(this.bag);
    }

    public ArrayList<TilePositionBoard> showBoard() {
        return this.placements;
    }


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
    }  //Metodo che userò anche per riempire la board quando vuota

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
        int counter = 0;

        //La posizione è svuotabile del proprio TileObj se contiene un tile e ha almeno un lato adiacente libero.
        if(position.isOccupied()){
            int x = position.getX();
            int y = position.getY();
            for(TilePositionBoard item : placements){
                if ((item.getX() == x && (item.getY() == y - 1 || item.getY() == y + 1)) || ((item.getX() == x - 1 || item.getX() == x + 1) && item.getY() == y)) {
                    counter++;
                    if(!item.isOccupied()){
                        return true; //Lo slot position ha almeno un lato adiacente vuoto.
                    }
                }
            }
            if(counter<4){
                return true;
            } //Per le tessere ai bordi che in Board non hanno tutte e 4 le posizioni adiacenti.
              //Se sono arrivato fin qui e le posizioni adiacenti sono tutte occupate, ma quelle presenti in Board sono in numero <4
              //allora mi trovo su una tessera del bordo, certamente rimovibile.
        }
        return false;  //Se arrivo fin qui non ho trovato nessun lato adiacente libero e la mia tessera non è sul bordo. Quindi la posizione non è svuotabile.
    }


    public ArrayList<TileObj> removeTiles(ArrayList<TilePositionBoard> tilesToRemove) throws TilesAreNotRemovableException, PositionEmptyException, WrongNumberOfTilesException, BoardDoesNotContainThisPositionException {
        ArrayList<TileObj> TilesRemoved = new ArrayList<TileObj>();
        int tilesCounter = 0;

        //Le TilePositionBoard contenute nell'ArrayList passato come parametro, causa TurnView, non sono gli oggetti della Board, ma oggetti copia contenenti copie esatte dei valori degli attributi.
        //Tramite questo for a ciascuna posizione contenuta nell'ArrayList sostituisco il riferimento al corrispondente vero oggetto TilePositionBoard della Board.
        for (int i = 0; i < tilesToRemove.size() ; i++) {
            for (int j = 0; j < this.placements.size(); j++) {
                if (tilesToRemove.get(i).equals(placements.get(j))) {
                    tilesToRemove.remove(tilesToRemove.get(i));
                    tilesToRemove.add(placements.get(j));
                }
            }
        }

        for(TilePositionBoard boardPosition : tilesToRemove){
            tilesCounter++;
        }

        for(TilePositionBoard posToRemove : tilesToRemove){
            if(!isABoardPosition(posToRemove)){
                throw new BoardDoesNotContainThisPositionException(posToRemove.getX(), posToRemove.getY());
            }
            if(!tileIsRemovable(posToRemove)){
                throw new TilesAreNotRemovableException();
            }
        }

        //Se il numero di tessere contenute nell'ArrayList passato come parametro è 0 oppure >3 allora restituisce errore.
        //Da regole di gioco: è solo possibile prelevare da 1 a 3 tessere.
        if (tilesCounter < 1 || tilesCounter > 3) {
            throw new WrongNumberOfTilesException(tilesCounter);
        }

        if (!arePositionsDifferentFromEachOther(tilesToRemove)) {
            throw new TilesAreNotRemovableException();
        }
        
        //verifica se le posizioni passate sono tutte sulla stessa riga (uguale x) o tutte sulla stessa colonna (uguale y).
        if(!(tilesAreInSameLine(tilesToRemove) || tilesAreInSameColumn(tilesToRemove))){
            throw new TilesAreNotRemovableException();
        }

        //Rimuove ciascun TileObj dalla corrispondente TilePositionBoard in board. Infine il metodo restituisce questi TileObj rimossi.
        for(TilePositionBoard boardPosition : tilesToRemove){
            TilesRemoved.add(boardPosition.removeTile());
        }

        return TilesRemoved;
    }


    private boolean tilesAreInSameLine(ArrayList<TilePositionBoard> extTilesPos){
        for(int i=0; i < extTilesPos.size()-1; i++){
            TilePositionBoard currentTile = extTilesPos.get(i);
            TilePositionBoard nextTile = extTilesPos.get(i+1);

            if(!(nextTile.getX() == currentTile.getX() &&
                    ((nextTile.getY() == currentTile.getY()-1) || (nextTile.getY() == currentTile.getY()+1)))){
                return false;
            }
        }
        return  true;
    }

    private boolean tilesAreInSameColumn(ArrayList<TilePositionBoard> extTilesPos){
        for(int i=0; i < extTilesPos.size()-1; i++){
            TilePositionBoard currentTile = extTilesPos.get(i);
            TilePositionBoard nextTile = extTilesPos.get(i+1);

            if(!(nextTile.getY() == currentTile.getY() &&
                    ((nextTile.getX() == currentTile.getX()-1) || (nextTile.getX() == currentTile.getX()+1)))){
                return false;
            }
        }
        return  true;
    }

    private boolean isABoardPosition(TilePositionBoard pos){
        int x = pos.getX();
        int y = pos.getY();

        for(TilePositionBoard t : this.placements){
            if(t.getX() == x && t.getY() == y){
                return true;
            }
        }
        return false;
    }

    private boolean arePositionsDifferentFromEachOther(ArrayList<TilePositionBoard> tpb){
        for(int i=0; i<tpb.size()-1; i++){
            for(int j=1; j<tpb.size(); j++){
                if(tpb.get(i).equals(tpb.get(j))){
                    return false;
                }
            }
        }
        return true;
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
        if (board == null) {
            board = this.placements;
        }
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