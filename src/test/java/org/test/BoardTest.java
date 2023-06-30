package org.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.*;

class BoardTest {
    private Board board;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @BeforeEach
    public void setOutputStream() {
        //Redirect di System.out a un ByteArrayOutputStream
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreOutputStream() {
        //Restore System.out
        System.setOut(originalOut);
    }


    //Testo se il costruttore vuoto utilizza correttamente i metodi protoBoard() addTiles() per inizializzare la Board
    //il metodo protoBoard() è usato solo all'interno di questo costruttore quindi il suo funzionamento è qui implicitamente testato
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

        //Test di posizioni rimovibili sul bordo (certamente almeno un lato adiacente sempre libero)
        for(TilePositionBoard tilePos : board.getPlacements()){
            if(tilePos.getX()==2 && tilePos.getY()==3){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
            if(tilePos.getX()==5 && tilePos.getY()==2){
                Assertions.assertTrue(board.tileIsRemovable(tilePos));
            }
        }

        //Test di posizioni non rimovibili (nessun lato libero)
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
        //Crea un ArrayList di TilePositionBoard contenente tutte tessere nella stessa linea
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
        //Test tiles in the same line
        Assertions.assertTrue(board.tilesAreInSameLine(tilesInSameLine));

        //Crea un ArrayList di TilePositionBoard contenente tessere non tutte nella stessa linea
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
        //Crea un ArrayList di TilePositionBoard contenente tutte tessere nella stessa colonna
        ArrayList<TilePositionBoard> tilesInSameColumn = new ArrayList<>();
        tilesInSameColumn.add(new TilePositionBoard(2, 5));
        tilesInSameColumn.add(new TilePositionBoard(3, 5));
        tilesInSameColumn.add(new TilePositionBoard(4, 5));

        //Test tiles in the same column
        Assertions.assertTrue(board.tilesAreInSameColumn(tilesInSameColumn));

        //Crea un ArrayList di TilePositionBoard contenente tessere non tutte nella stessa colonna
        ArrayList<TilePositionBoard> tilesNotInSameColumn = new ArrayList<>();
        tilesNotInSameColumn.add(new TilePositionBoard(5, 2));
        tilesNotInSameColumn.add(new TilePositionBoard(5, 3));
        tilesNotInSameColumn.add(new TilePositionBoard(7, 4));

        //Test tiles not in the same column
        Assertions.assertFalse(board.tilesAreInSameColumn(tilesNotInSameColumn));
    }


    @Test
    public void testIsABoardPosition() {
        //Test board position esistente
        TilePositionBoard existingPosition = new TilePositionBoard(4, 3);
        Assertions.assertTrue(board.isABoardPosition(existingPosition));

        // Test board position non esistente
        TilePositionBoard nonExistingPosition = new TilePositionBoard(5, 9);
        Assertions.assertFalse(board.isABoardPosition(nonExistingPosition));
    }


    @Test
    public void testArePositionsDifferentFromEachOther() {
        //ArrayList di TilePositionBoard con posizioni differenti
        ArrayList<TilePositionBoard> differentPositions = new ArrayList<>();
        differentPositions.add(new TilePositionBoard(2, 3));
        differentPositions.add(new TilePositionBoard(2, 4));
        differentPositions.add(new TilePositionBoard(2, 5));
        // Test different positions
        Assertions.assertTrue(board.arePositionsDifferentFromEachOther(differentPositions));

        //Creazione di un ArrayList of TilePositionBoard con posizioni duplicate
        ArrayList<TilePositionBoard> duplicatePositions = new ArrayList<>();
        duplicatePositions.add(new TilePositionBoard(3, 2));
        duplicatePositions.add(new TilePositionBoard(3, 3));
        duplicatePositions.add(new TilePositionBoard(3, 2));
        //Test posizioni duplicate
        Assertions.assertFalse(board.arePositionsDifferentFromEachOther(duplicatePositions));
    }

    @Test
    public void testInitializeBoard(){
        board.initializeBoard();
        Assertions.assertTrue(board.boardIsEmpty());
    }


    @Test
    public void testBoardIsEmpty() {
        //Test when board is not empty
        Assertions.assertFalse(board.boardIsEmpty());

        //Test when the board is empty
        board.initializeBoard(); //Takes care of emptying the Board
        Assertions.assertTrue(board.boardIsEmpty());
    }


    @Test
    public void testBoardNeedsRestore() {
        //Test when board is full
        Assertions.assertFalse(board.boardNeedsRestore());

        //Test when the board contains connected tiles
        board.initializeBoard();
        ArrayList<TilePositionBoard> extPlacements = new ArrayList<>();
        extPlacements.add(new TilePositionBoard(3, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 3, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(5, 2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(3, 6, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(4, 6, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(5, 6, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 7, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));
        board.setPlacements(extPlacements);
        Assertions.assertFalse(board.boardNeedsRestore());

        //Test when the board is empty
        board.initializeBoard();
        Assertions.assertTrue(board.boardNeedsRestore());

        //Test when the board contains only isolated tiles
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
        //Test when board is full and therefore does not need to be restored
        Assertions.assertFalse(board.boardNeedsRestore());
        board.restoreBoard();
        Assertions.assertFalse(board.boardNeedsRestore());

        //Test when board is empty and therefore needs to be restored
        board.initializeBoard();  //Empty the board completely
        Assertions.assertTrue(board.boardNeedsRestore());
        board.restoreBoard();
        Assertions.assertFalse(board.boardNeedsRestore());

    }


    //Test del metodo addTiles (utilizzato per riempire tutte le posizioni vuote con dei TileObj estratti casualmente dalla TileObjBag)
    @Test
    public void testAddTiles() {
        board.initializeBoard();
        Assertions.assertTrue(board.boardNeedsRestore());

        // Add tiles to the board using addTiles() method
        board.restoreBoard();  // Inside it invokes the AddTiles() method
        Assertions.assertFalse(board.boardNeedsRestore());
    }


    @Test
    void testAddTilesWithRemovedTiles(){
        //Create a list of TilePositionBoard representing removed tiles
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

        //Call addTiles method to add the removed tiles to the board
        board.addTiles(tilesRemoved);

        //Verify that the positions of removed tiles have been added back to the board
        for(TilePositionBoard extPos : tilesRemoved){
            for (TilePositionBoard posBoard : board.getPlacements()) {
                if (posBoard.getX() == extPos.getX() && posBoard.getY() == extPos.getY()) {
                    Assertions.assertTrue(posBoard.isOccupied());
                    Assertions.assertEquals(posBoard.getTile(), extPos.getTile());
                }
            }
        }
        Assertions.assertEquals(29, board.getPlacements().size());
    }


    @Test
    public void testPrintTilePositionBoard() {
        //Create a list of TilePositionBoard to represent the board
        ArrayList<TilePositionBoard> newBoardTiles = new ArrayList<>();
        newBoardTiles.add(new TilePositionBoard(3, 5, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        newBoardTiles.add(new TilePositionBoard(4, 4, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        newBoardTiles.add(new TilePositionBoard(5, 7, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));

        //Empty the board
        board.initializeBoard();

        //Add the previously selected tiles
        board.addTiles(newBoardTiles);

        //Call the printTilePositionBoard method
        board.printTilePositionBoard(board.getPlacements());

        //Verify the output
        String expectedOutput =
                "- - - - - - - - " + System.lineSeparator() +
                "- - - |[3,1]= null,o=false| |[4,1]= null,o=false| - - - " + System.lineSeparator() +
                "- - - |[3,2]= null,o=false| |[4,2]= null,o=false| |[5,2]= null,o=false| - - " + System.lineSeparator() +
                "- - |[2,3]= null,o=false| |[3,3]= null,o=false| |[4,3]= null,o=false| |[5,3]= null,o=false| |[6,3]= null,o=false| |[7,3]= null,o=false| " + System.lineSeparator() +
                "- |[1,4]= null,o=false| |[2,4]= null,o=false| |[3,4]= null,o=false| |[4,4]=  G 2,o=true| |[5,4]= null,o=false| |[6,4]= null,o=false| |[7,4]= null,o=false| " + System.lineSeparator() +
                "- |[1,5]= null,o=false| |[2,5]= null,o=false| |[3,5]=  T 3,o=true| |[4,5]= null,o=false| |[5,5]= null,o=false| |[6,5]= null,o=false| - " + System.lineSeparator() +
                "- - - |[3,6]= null,o=false| |[4,6]= null,o=false| |[5,6]= null,o=false| - - " + System.lineSeparator() +
                "- - - - |[4,7]= null,o=false| |[5,7]=  C 1,o=true| - - " + System.lineSeparator();
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    void testConstructorWithPlacementsAndBag() {
        TileObjBag extBag = new TileObjBag();
        ArrayList<TilePositionBoard> extPlacements = new ArrayList<>();
        extPlacements.add(new TilePositionBoard(3, 2, new TileObj(TileType.CAT, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 2, new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(4, 3, new TileObj(TileType.PLANT, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(5, 2, new TileObj(TileType.TROPHY, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 3, new TileObj(TileType.GAMES, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(3, 6, new TileObj(TileType.FRAME, TileVariant.VARIANT_TWO)));
        extPlacements.add(new TilePositionBoard(4, 6, new TileObj(TileType.TROPHY, TileVariant.VARIANT_ONE)));
        extPlacements.add(new TilePositionBoard(5, 6, new TileObj(TileType.PLANT, TileVariant.VARIANT_THREE)));
        extPlacements.add(new TilePositionBoard(5, 7, new TileObj(TileType.BOOK, TileVariant.VARIANT_TWO)));

        //Build the board with this second constructor
        Board customBoard = new Board(extPlacements, extBag);

        for(TilePositionBoard extPos : extPlacements){
            for (TilePositionBoard posBoard : customBoard.getPlacements()) {
                if (posBoard.getX() == extPos.getX() && posBoard.getY() == extPos.getY()) {
                    Assertions.assertEquals(posBoard.isOccupied(), extPos.isOccupied());
                    Assertions.assertEquals(posBoard.getTile().getType(), extPos.getTile().getType());
                    Assertions.assertEquals(posBoard.getTile().getVariant(), extPos.getTile().getVariant());
                }
            }
        }
        Assertions.assertEquals(customBoard.getPlacements().size(), extPlacements.size());

        //The method that initializes the TileObjBag has already been tested in TileObjBagTest
        Assertions.assertEquals(customBoard.getBag().BagSize(), extBag.BagSize());
    }


    @Test
    void testConstructorCopyExternalBoard() {
        //Create a new board using this copy constructor
        Board copiedBoard = new Board(board);

        //Get the placements of the original and copied boards
        ArrayList<TilePositionBoard> originalPlacements = board.getPlacements();
        ArrayList<TilePositionBoard> copiedPlacements = copiedBoard.getPlacements();

        //Verify that the placements are the same
        Assertions.assertEquals(originalPlacements.size(), copiedPlacements.size());
        for (int i = 0; i < originalPlacements.size(); i++) {
            TilePositionBoard originalTilePos = originalPlacements.get(i);
            TilePositionBoard copiedTilePos = copiedPlacements.get(i);
            Assertions.assertEquals(originalTilePos.getX(), copiedTilePos.getX());
            Assertions.assertEquals(originalTilePos.getY(), copiedTilePos.getY());
            Assertions.assertEquals(originalTilePos.getTile().getType(), copiedTilePos.getTile().getType());
            Assertions.assertEquals(originalTilePos.getTile().getVariant(), copiedTilePos.getTile().getVariant());
            Assertions.assertEquals(originalTilePos.isOccupied(), copiedTilePos.isOccupied());
        }

        //Verify that the bags are the same
        Assertions.assertEquals(board.getBag().getTiles().size(), copiedBoard.getBag().getTiles().size());
        for (int i = 0; i < board.getBag().getTiles().size(); i++){
            TileObj originalTile = board.getBag().getTiles().get(i);
            TileObj copiedTile = copiedBoard.getBag().getTiles().get(i);
            Assertions.assertEquals(originalTile.getType(), copiedTile.getType());
            Assertions.assertEquals(originalTile.getVariant(), copiedTile.getVariant());
        }
    }



}
