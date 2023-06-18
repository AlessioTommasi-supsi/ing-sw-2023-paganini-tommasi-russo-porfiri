package org.test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.project.model.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.utils.*;
import static org.junit.Assert.*;

class BoardTest {
    private Board board;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @BeforeEach
    public void setOutputStream() {
        //Redirect System.out to a ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreOutputStream() {
        //Restore System.out
        System.setOut(originalOut);
    }


    //Testo se il costruttore vuoto utilizza correttamente i metodi protoBoard() addTiles() per inizializzare la Board
    @Test
    public void testEmptyConstructor() {
        ArrayList<TilePositionBoard> placements = board.getPlacements();

        //Creo i 29 oggetti TilePositionBoard inizializzati esattamente come mi aspetto siano quelli della Board
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
        Assertions.assertEquals(29, myPlacements.size()); //29 è la dimensione corretta di una Board da 2 Players

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
        extPlacements.add(new TilePositionBoard(2, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(5, 8, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        board.setPlacements(extPlacements);
        ArrayList<TilePositionBoard> boardPositions = board.showBoard();
        Assertions.assertEquals(31, boardPositions.size());
    }


    @Test
    public void testTileIsRemovable() throws WrongNumberOfTilesException, DuplicatesInRequestedTilesException, PositionEmptyException, BoardDoesNotContainThisPositionException, TilesAreNotRemovableException {

        // Test di posizioni rimovibili sul bordo (certamente almeno un lato adiacente sempre libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==2 && tilePos.getY()==3){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
            if(tilePos.getX()==5 && tilePos.getY()==2){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
        }

        // Test di posizioni non rimovibili (nessun lato libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==4 && tilePos.getY()==4){
                Assertions.assertFalse(board.tileIsRemovable(tilePos));
            }
            if(tilePos.getX()==6 && tilePos.getY()==4){
                Assertions.assertFalse(board.tileIsRemovable(tilePos));
            }
        }

        //Rimuovo le tessere (4,7), (5,7) in modo da permettere poi di rimuovere le successive (4,6), (5,6)
        ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 4 && tilePos.getY() == 7) {
                tilesToRemove.add(tilePos);
            }
            if (tilePos.getX() == 5 && tilePos.getY() == 7) {
                tilesToRemove.add(tilePos);
            }
        }
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

        //Test di una rimozione avvenuta con successo
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

        //Test dei casi eccezionali
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


    @Test
    public void testTilesAreInSameLine() {
        // Create an ArrayList of TilePositionBoard representing tiles in the same line
        ArrayList<TilePositionBoard> tilesInSameLine = new ArrayList<>();
        for(TilePositionBoard tileBoard : board.getPlacements()){
            if(tileBoard.getX() == 6 && tileBoard.getY() == 3){
                tilesInSameLine.add(tileBoard);
            }
            if(tileBoard.getX() == 6 && tileBoard.getY() == 4){
                tilesInSameLine.add(tileBoard);
            }
            if(tileBoard.getX() == 6 && tileBoard.getY() == 5){
                tilesInSameLine.add(tileBoard);
            }

        }
        // Test tiles in the same line
        Assertions.assertTrue(board.tilesAreInSameLine(tilesInSameLine));

        // Create an ArrayList of TilePositionBoard representing tiles not in the same line
        ArrayList<TilePositionBoard> tilesNotInSameLine = new ArrayList<>();
        for(TilePositionBoard tileBoard : board.getPlacements()){
            if(tileBoard.getX() == 3 && tileBoard.getY() == 3){
                tilesNotInSameLine.add(tileBoard);
            }
            if(tileBoard.getX() == 4 && tileBoard.getY() == 3){
                tilesNotInSameLine.add(tileBoard);
            }
            if(tileBoard.getX() == 5 && tileBoard.getY() == 5){
                tilesNotInSameLine.add(tileBoard);
            }

        }
        // Test tiles not in the same line
        Assertions.assertFalse(board.tilesAreInSameLine(tilesNotInSameLine));
    }


    @Test
    public void testTilesAreInSameColumn() {
        // Create an ArrayList of TilePositionBoard representing tiles in the same column
        ArrayList<TilePositionBoard> tilesInSameColumn = new ArrayList<>();
        tilesInSameColumn.add(new TilePositionBoard(2, 5));
        tilesInSameColumn.add(new TilePositionBoard(3, 5));
        tilesInSameColumn.add(new TilePositionBoard(4, 5));

        // Test tiles in the same column
        Assertions.assertTrue(board.tilesAreInSameColumn(tilesInSameColumn));

        // Create an ArrayList of TilePositionBoard representing tiles not in the same column
        ArrayList<TilePositionBoard> tilesNotInSameColumn = new ArrayList<>();
        tilesNotInSameColumn.add(new TilePositionBoard(5, 2));
        tilesNotInSameColumn.add(new TilePositionBoard(5, 3));
        tilesNotInSameColumn.add(new TilePositionBoard(7, 4));

        // Test tiles not in the same column
        Assertions.assertFalse(board.tilesAreInSameColumn(tilesNotInSameColumn));
    }


    @Test
    public void testIsABoardPosition() {
        // Test existing board positions
        TilePositionBoard existingPosition = new TilePositionBoard(4, 3);
        Assertions.assertTrue(board.isABoardPosition(existingPosition));

        // Test non-existing board position
        TilePositionBoard nonExistingPosition = new TilePositionBoard(5, 9);
        Assertions.assertFalse(board.isABoardPosition(nonExistingPosition));
    }


    @Test
    public void testArePositionsDifferentFromEachOther() {
        // ArrayList of TilePositionBoard with different positions
        ArrayList<TilePositionBoard> differentPositions = new ArrayList<>();
        differentPositions.add(new TilePositionBoard(2, 3));
        differentPositions.add(new TilePositionBoard(2, 4));
        differentPositions.add(new TilePositionBoard(2, 5));
        // Test different positions
        Assertions.assertTrue(board.arePositionsDifferentFromEachOther(differentPositions));

        // Create an ArrayList of TilePositionBoard with duplicate positions
        ArrayList<TilePositionBoard> duplicatePositions = new ArrayList<>();
        duplicatePositions.add(new TilePositionBoard(3, 2));
        duplicatePositions.add(new TilePositionBoard(3, 3));
        duplicatePositions.add(new TilePositionBoard(3, 2));
        // Test duplicate positions
        Assertions.assertFalse(board.arePositionsDifferentFromEachOther(duplicatePositions));
    }

    @Test
    public void testInitializeBoard(){
        board.thePowerOfTheAtom();
        Assertions.assertTrue(board.boardIsEmpty());
        ArrayList<TilePositionBoard> boardPositions = board.showBoard();
        Assertions.assertEquals(0, boardPositions.size());
    }


    @Test
    public void testBoardIsEmpty() {
        // Test when the board is not empty
        Assertions.assertFalse(board.boardIsEmpty());
        Assertions.assertNotEquals(0, board.showBoard().size());

        // Test when the board is empty
        board.thePowerOfTheAtom(); //Takes care of emptying the Board
        Assertions.assertTrue(board.boardIsEmpty());
        Assertions.assertEquals(0, board.showBoard().size());

    }


    @Test
    public void testBoardNeedsRestore() {
        // Test when board is full
        Assertions.assertFalse(board.boardNeedsRestore());

        // Test when the board contains connected tiles
        board.thePowerOfTheAtom();
        ArrayList<TilePositionBoard> extPlacements = new ArrayList<>();
        extPlacements.add(new TilePositionBoard(3, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 3, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(5, 2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(5, 3, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(3, 6, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(4, 6, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(5, 6, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 7, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        board.setPlacements(extPlacements);
        Assertions.assertFalse(board.boardNeedsRestore());

        // Test when the board is empty
        board.thePowerOfTheAtom();
        Assertions.assertTrue(board.boardNeedsRestore());

        // Test when the board contains only isolated tiles
        extPlacements = new ArrayList<>();
        extPlacements.add(new TilePositionBoard(3, 2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(3, 6, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 6, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(4, 4, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 7, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        board.setPlacements(extPlacements);
        Assertions.assertTrue(board.boardNeedsRestore());

    }

    @Test
    public void testRestoreBoard(){
        // Test when board is full and therefore does not need to be restored
        Assertions.assertEquals(29, board.showBoard().size());
        Assertions.assertFalse(board.boardNeedsRestore());
        board.restoreBoard();
        Assertions.assertEquals(29, board.showBoard().size());
        Assertions.assertFalse(board.boardNeedsRestore());

        // Test when board is empty and therefore needs to be restored
        board.thePowerOfTheAtom();  //Empty the board completely
        Assertions.assertEquals(0, board.showBoard().size());
        Assertions.assertTrue(board.boardNeedsRestore());
        board.restoreBoard();
        Assertions.assertNotEquals(0, board.showBoard().size());
        Assertions.assertFalse(board.boardNeedsRestore());

    }


    // Test del metodo addTiles (utilizzato per riempire tutte le posizioni vuote con dei TileObj estratti casualmente dalla TileObjBag)
    @Test
    public void testAddTiles() {
        // Add tiles to the board using addTiles() method
        board.thePowerOfTheAtom();
        Assertions.assertTrue(board.boardNeedsRestore());
        board.restoreBoard();
        Assertions.assertFalse(board.boardNeedsRestore());
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
    void testAddTilesWithRemovedTiles(){
        // Create a list of TilePositionBoard representing removed tiles
        ArrayList<TilePositionBoard> tilesRemoved = new ArrayList<>();
        for (TilePositionBoard tilePos : board.getPlacements()) {
            if (tilePos.getX() == 1 && tilePos.getY() == 4) {
                tilesRemoved.add(tilePos);
            }
            if (tilePos.getX() == 1 && tilePos.getY() == 5) {
                tilesRemoved.add(tilePos);
            }
        }
        try{
            board.removeTiles(tilesRemoved);
        } catch(Exception e) {

        }
        Assertions.assertEquals(27, board.getPlacements().size());

        // Call addTiles method to add the removed tiles to the board
        board.addTiles(tilesRemoved);

        // Verify that the positions of removed tiles have been added back to the board
        for (TilePositionBoard tp : tilesRemoved) {
            Assertions.assertTrue(board.getPlacements().contains(tp));
        }
        Assertions.assertEquals(29, board.getPlacements().size());
    }


    @Test
    public void testPrintTilePositionBoard() {
        // Create a list of TilePositionBoard to represent the board
        ArrayList<TilePositionBoard> boardTiles = new ArrayList<>();
        boardTiles.add(new TilePositionBoard(0, 0));
        boardTiles.add(new TilePositionBoard(0, 1));
        boardTiles.add(new TilePositionBoard(1, 0));

        // Set the board tiles
        board.setPlacements(boardTiles);

        // Call the printTilePositionBoard method
        board.printTilePositionBoard(board.getPlacements());

        // Verify the output
        String expectedOutput = "TPB (0,0) TPB (0,1) \nTPB (1,0) - \n";
        Assertions.assertEquals(expectedOutput, outputStream.toString());
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
    }

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

     */

}
