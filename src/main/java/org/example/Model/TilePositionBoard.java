package org.example.Model;

public class TilePositionBoard {
    private int x;
    private int y;
    private TileObj tileInSlot;
    private boolean occupied;

    public TilePositionBoard(int abscissa, int ordinate){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= null;
        this.occupied= false;
    }

    public TilePositionBoard(int abscissa, int ordinate, TileObj tile){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= tile;
        this.occupied= true;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isOccupied(){
        if(this.occupied==true){
            return true;
        }
        else return false;
    }

    public TileObj getTile() throws PositionEmptyException {
        if(tileInSlot != null){
            return this.tileInSlot;
        }
        else throw new PositionEmptyException();
    }

    public void setTile(TileObj tile) throws PositionAlreadyOccupiedException {
        if(this.occupied != true){
            this.tileInSlot= tile;
            this.occupied= true;
        }
        else throw new PositionAlreadyOccupiedException();
    }

    public TileObj removeTile() throws PositionEmptyException {
        if(this.tileInSlot != null && this.occupied == true){
            TileObj tempTile = new TileObj(this.tileInSlot);
            this.tileInSlot= null;
            this.occupied=false;
            return tempTile;
        }
        else throw new PositionEmptyException();
    }


}
