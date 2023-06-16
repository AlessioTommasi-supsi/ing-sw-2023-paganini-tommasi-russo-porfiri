package org.test;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.project.model.*;
import java.util.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.utils.*;

import static org.junit.Assert.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }


    //Testo se il costruttore vuoto utilizza correttamente i metodi protoBoard() addTiles() per inizializzare la Board
    @Test
    public void testEmptyConstructor() {
        ArrayList<TilePositionBoard> placements = board.getPlacements();

        // Creo i 29 oggetti TilePositionBoard inizializzati esattamente come mi aspetto siano quelli della Board
        ArrayList<TilePositionBoard> expectedPlacements = new ArrayList<>();
        int j;
        int i=1;
        for(j=4; j<6; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=2;
        for(j=3; j<6; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=3;
        for(j=1; j<7; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=4;
        for(j=1; j<8; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=5;
        for(j=2; j<8; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=6;
        for(j=3; j<6; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }
        i=7;
        for(j=3; j<5; j++){
            expectedPlacements.add(new TilePositionBoard(i, j));
        }

        //Verifico se l'inizializzazione dei placement della Board matcha quella attesi.
        Assertions.assertEquals(expectedPlacements.size(), placements.size());
        Assertions.assertTrue(placements.containsAll(expectedPlacements));

        for(TilePositionBoard tp : placements){
            Assertions.assertTrue(tp.isOccupied());
        }
    }


    @Test
    void testGetPlacements() {
        ArrayList<TilePositionBoard> myPlacements = board.getPlacements();
        Assertions.assertNotNull(myPlacements);
        Assertions.assertEquals(29, myPlacements.size());

    }

    @Test
    void testGetBag() {
        TileObjBag myBag = board.getBag();
        Assertions.assertNotNull(myBag);
        Assertions.assertEquals(103, myBag.BagSize()); //dopo aver estratto le 29 tessere in fase di costruzione, la Bag contiene 132-29=103 tessere.
    }

    @Test
    void testShowBoard() {
        ArrayList<TilePositionBoard> boardPositions = board.showBoard();
        Assertions.assertNotNull(boardPositions);
        Assertions.assertEquals(29, boardPositions.size());
    }


    @Test
    void testSetPlacements() {
        ArrayList<TilePositionBoard> extPlacements = new ArrayList<>();
        extPlacements.add(new TilePositionBoard(2, 2));
        extPlacements.add(new TilePositionBoard(5, 8));
        board.setPlacements(extPlacements);
        ArrayList<TilePositionBoard> boardPositions = board.showBoard();
        Assertions.assertEquals(31, boardPositions.size());
    }


    @Test
    public void testTileIsRemovable() throws WrongNumberOfTilesException, DuplicatesInRequestedTilesException, PositionEmptyException, BoardDoesNotContainThisPositionException, TilesAreNotRemovableException {

        // Test di una posizione removibile sul bordo (certamente almeno un lato adiacente sempre libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==2 && tilePos.getY()==3){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
        }

        // Test di una posizione non rimovibile (nessun lato libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==4 && tilePos.getY()==4){
                Assertions.assertFalse(board.tileIsRemovable(tilePos));
            }
        }


        ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<>();
        tilesToRemove.add(new TilePositionBoard(4, 7));
        tilesToRemove.add(new TilePositionBoard(5, 7));
        board.removeTiles(tilesToRemove);

        // Test di posizioni rimovibili non sul bordo (almeno un lato adiacente libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==4 && tilePos.getY()==6){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
            if(tilePos.getX()==5 && tilePos.getY()==6){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
            if(tilePos.getX()==5 && tilePos.getY()==5){
                Assertions.assertFalse(board.tileIsRemovable(tilePos));
            }

        }

        board.setPlacements(tilesToRemove);
    }


    @Test
    public void testRemoveTiles() throws TilesAreNotRemovableException, PositionEmptyException, WrongNumberOfTilesException, BoardDoesNotContainThisPositionException, DuplicatesInRequestedTilesException {

        //Creo un ArrayList di TilePositionBoard rappresentante le tessere da rimuovere (prova con tessere removibili)
        ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 1 && tilePos.getY() == 4) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 1 && tilePos.getY() == 5) {
                tilesToRemove.add(tilePos);
            }
        }

        // Test della rimozione
        ArrayList<TileObj> removedTiles = board.removeTiles(tilesToRemove);

        //Verifico se la rimozione ha avuto gli effetti desiderati
        Assertions.assertEquals(2, removedTiles.size());
        for (TilePositionBoard tr : tilesToRemove) {
            for (TilePositionBoard tb : board.getPlacements()) {
                if (tb.getX() == tr.getX() && tb.getY() == tr.getY()) {
                    Assertions.assertFalse(tb.isOccupied());
                    Assertions.assertNull(tb.getTile());
                }
            }
        }

        //BoardDoesNotContainThisPositionException
        tilesToRemove = new ArrayList<>();
        TilePositionBoard tp = new TilePositionBoard(0,0);
        tilesToRemove.add(tp);
        try {
            removedTiles = board.removeTiles(tilesToRemove);
            Assertions.fail();
        } catch (BoardDoesNotContainThisPositionException e){

        }

        //TilesAreNotRemovableException
        tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 4 && tilePos.getY() == 4) {
                tilesToRemove.add(tilePos);
            }
        }
        try {
            removedTiles = board.removeTiles(tilesToRemove);
            Assertions.fail();
        } catch (TilesAreNotRemovableException e){

        }

        //DuplicatesInRequestedTilesException
        tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 2 && tilePos.getY() == 4) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 2 && tilePos.getY() == 4) {
                tilesToRemove.add(tilePos);
            }
        }
        try {
            removedTiles = board.removeTiles(tilesToRemove);
            Assertions.fail();
        } catch (DuplicatesInRequestedTilesException e){

        }

        //TilesAreNotRemovableException (Tiles are not in the same line (equivalent for column)
        tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 2 && tilePos.getY() == 3) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 4 && tilePos.getY() == 7) {
                tilesToRemove.add(tilePos);
            }
        }
        try {
            removedTiles = board.removeTiles(tilesToRemove);
            Assertions.fail();
        } catch (TilesAreNotRemovableException e){

        }

        tilesToRemove= new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 4 && tilePos.getY() == 7) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 5 && tilePos.getY() == 7) {
                tilesToRemove.add(tilePos);
            }
        }
        removedTiles = board.removeTiles(tilesToRemove);

        tilesToRemove= new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 3 && tilePos.getY() == 6) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 4 && tilePos.getY() == 6) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 5 && tilePos.getY() == 6) {
                tilesToRemove.add(tilePos);
            }
        }
        removedTiles = board.removeTiles(tilesToRemove);

        //WrongNumberOfTilesException
        tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 3 && tilePos.getY() == 5) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 4 && tilePos.getY() == 5) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 5 && tilePos.getY() == 5) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 6 && tilePos.getY() == 5) {
                tilesToRemove.add(tilePos);
            }
        }
        try {
            removedTiles = board.removeTiles(tilesToRemove);
            Assertions.fail();
        } catch (WrongNumberOfTilesException e){

        }
    }


    //DA CONTINUARE
    @Test
    public void testTilesAreInSameLine() {
        // Create an ArrayList of TilePositionBoard representing tiles in the same line
        ArrayList<TilePositionBoard> tilesInSameLine = new ArrayList<>();
        tilesInSameLine.add(new TilePositionBoard(0, 0));
        tilesInSameLine.add(new TilePositionBoard(0, 1));
        tilesInSameLine.add(new TilePositionBoard(0, 2));

        // Test tiles in the same line
        Assertions.assertTrue(board.tilesAreInSameLine(tilesInSameLine));

        // Create an ArrayList of TilePositionBoard representing tiles not in the same line
        ArrayList<TilePositionBoard> tilesNotInSameLine = new ArrayList<>();
        tilesNotInSameLine.add(new TilePositionBoard(0, 0));
        tilesNotInSameLine.add(new TilePositionBoard(1, 1));
        tilesNotInSameLine.add(new TilePositionBoard(2, 2));

        // Test tiles not in the same line
        Assertions.assertFalse(board.tilesAreInSameLine(tilesNotInSameLine));
    }


    @Test
    public void testTilesAreInSameColumn() {
        // Create an ArrayList of TilePositionBoard representing tiles in the same column
        ArrayList<TilePositionBoard> tilesInSameColumn = new ArrayList<>();
        tilesInSameColumn.add(new TilePositionBoard(0, 0));
        tilesInSameColumn.add(new TilePositionBoard(1, 0));
        tilesInSameColumn.add(new TilePositionBoard(2, 0));

        // Test tiles in the same column
        Assertions.assertTrue(board.tilesAreInSameColumn(tilesInSameColumn));

        // Create an ArrayList of TilePositionBoard representing tiles not in the same column
        ArrayList<TilePositionBoard> tilesNotInSameColumn = new ArrayList<>();
        tilesNotInSameColumn.add(new TilePositionBoard(0, 0));
        tilesNotInSameColumn.add(new TilePositionBoard(1, 1));
        tilesNotInSameColumn.add(new TilePositionBoard(2, 2));

        // Test tiles not in the same column
        Assertions.assertFalse(board.tilesAreInSameColumn(tilesNotInSameColumn));
    }

    @Test
    public void testIsABoardPosition() {
        // Set up the board with some tiles
        board.getPlacements().add(new TilePositionBoard(0, 0));
        board.getPlacements().add(new TilePositionBoard(1, 1));
        board.getPlacements().add(new TilePositionBoard(2, 2));

        // Test existing board positions
        TilePositionBoard existingPosition = new TilePositionBoard(1, 1);
        Assertions.assertTrue(board.isABoardPosition(existingPosition));

        // Test non-existing board position
        TilePositionBoard nonExistingPosition = new TilePositionBoard(3, 3);
        Assertions.assertFalse(board.isABoardPosition(nonExistingPosition));
    }

    @Test
    public void testArePositionsDifferentFromEachOther() {
        // Create an ArrayList of TilePositionBoard with different positions
        ArrayList<TilePositionBoard> differentPositions = new ArrayList<>();
        differentPositions.add(new TilePositionBoard(0, 0));
        differentPositions.add(new TilePositionBoard(1, 1));
        differentPositions.add(new TilePositionBoard(2, 2));

        // Test different positions
        Assertions.assertTrue(board.arePositionsDifferentFromEachOther(differentPositions));

        // Create an ArrayList of TilePositionBoard with duplicate positions
        ArrayList<TilePositionBoard> duplicatePositions = new ArrayList<>();
        duplicatePositions.add(new TilePositionBoard(0, 0));
        duplicatePositions.add(new TilePositionBoard(1, 1));
        duplicatePositions.add(new TilePositionBoard(0, 0));

        // Test duplicate positions
        Assertions.assertFalse(board.arePositionsDifferentFromEachOther(duplicatePositions));
    }

    /*
    @Test
    public void testBoardIsEmpty() {
        // Test when the board is empty
        Assertions.assertTrue(board.boardIsEmpty());

        // Add a tile to the board
        board.getPlacements().add(new TilePositionBoard(0, 0));

        // Test when the board is not empty
        Assertions.assertFalse(board.boardIsEmpty());
    }


    @Test
    public void testBoardIsEmpty() throws PositionAlreadyOccupiedException {
        // Test when the board is empty
        Assertions.assertTrue(board.boardIsEmpty());

        // Add a tile to the board
        board.addTile(new Tile(), 0, 0);

        // Test when the board is not empty
        Assertions.assertFalse(board.boardIsEmpty());
    }

    @Test
    public void testBoardNeedsRestore() throws PositionAlreadyOccupiedException {
        // Test when the board contains only isolated tiles
        board.addTile(new Tile(), 0, 0);
        board.addTile(new Tile(), 2, 0);
        board.addTile(new Tile(), 0, 2);

        Assertions.assertTrue(board.boardNeedsRestore());

        // Test when the board contains connected tiles
        board.addTile(new Tile(), 1, 0);
        board.addTile(new Tile(), 1, 1);
        board.addTile(new Tile(), 1, 2);

        Assertions.assertFalse(board.boardNeedsRestore());

        // Test when the board is empty
        Assertions.assertTrue(board.boardNeedsRestore());
    }

    @Test
    public void testRestoreBoard() throws PositionAlreadyOccupiedException {
        // Add some tiles to the board
        board.addTile(new Tile(), 0, 0);
        board.addTile(new Tile(), 1, 0);
        board.addTile(new Tile(), 2, 0);
        board.addTile(new Tile(), 0, 1);

        // Verify that the board needs restoration
        Assertions.assertTrue(board.boardNeedsRestore());

        // Restore the board
        board.restoreBoard();

        // Verify that the board is restored to its initial state (empty)
        Assertions.assertTrue(board.boardIsEmpty());
    }


    @Test
    public void testAddTiles() throws PositionAlreadyOccupiedException {
        // Add tiles to the board using addTiles() method
        board.addTiles();

        // Assert that the tiles have been added successfully
        Assertions.assertFalse(board.getPlacements().isEmpty());
    }

    @Test
    public void testAddTilesWithTilesRemoved() {
        // Create an ArrayList of TilePositionBoard representing tiles to be added
        ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<>();
        tilesToRemove.add(new TilePositionBoard(1, 1));
        tilesToRemove.add(new TilePositionBoard(2, 2));

        // Add tiles to the board using addTiles(ArrayList<TilePositionBoard>) method
        board.addTiles(tilesToRemove);

        // Assert that the tiles have been added successfully
        Assertions.assertEquals(2, board.getPlacements().size());
    }



    @Test
    void testAddTilesWithRemovedTiles() {
        ArrayList<TilePositionBoard> removedTiles = new ArrayList<>();
        removedTiles.add(new TilePositionBoard(1, 2));
        removedTiles.add(new TilePositionBoard(3, 4));
        board.addTiles(removedTiles);
        ArrayList<TilePositionBoard> boardPositions = board.showBoard();
        assertEquals(35, boardPositions.size());
    }


    @Test
    public void testPrintTilePositionBoard() throws PositionAlreadyOccupiedException {
        // Add some tiles to the board
        board.addTile(new Tile("A"), 0, 0);
        board.addTile(new Tile("B"), 1, 0);
        board.addTile(new Tile("C"), 0, 1);

        // Create an ArrayList of TilePositionBoard to pass to the method
        ArrayList<TilePositionBoard> tiles = new ArrayList<>();
        tiles.add(new TilePositionBoard(new Tile("D"), 2, 0));
        tiles.add(new TilePositionBoard(new Tile("E"), 1, 1));
        tiles.add(new TilePositionBoard(new Tile("F"), 2, 1));

        // Print the board
        board.printTilePositionBoard(tiles);
    }






























   /* @Test
    void testConstructorWithPlacements() {
        ArrayList<TilePositionBoard> placements1 = new ArrayList<>();
        TileObjBag bag1 = new TileObjBag();
        placements1.add(new TilePositionBoard(1, 2));
        placements1.add(new TilePositionBoard(3, 4));
        Board customBoard = new Board(placements1);
        ArrayList<TilePositionBoard> boardPositions = customBoard.showBoard();
        assertEquals(35, boardPositions.size());
    } */

    @Test
    void testConstructorWithPlacementsAndBag() {
        ArrayList<TilePositionBoard> placements = new ArrayList<>();
        placements.add(new TilePositionBoard(1, 2));
        placements.add(new TilePositionBoard(3, 4));
        TileObjBag customBag = new TileObjBag();
        Board customBoard = new Board(placements, customBag);
        ArrayList<TilePositionBoard> boardPositions = customBoard.showBoard();
        assertEquals(35, boardPositions.size());
        assertEquals(100, customBag.BagSize());
    }
}
