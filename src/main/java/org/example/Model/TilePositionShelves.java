package org.example.Model;

public class TilePositionShelves {
    private int x;
    private int y;
    private TileObj tileInSlot;
    private boolean occupied;

    public TilePositionShelves(int abscissa, int ordinate){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= null;
        this.occupied= false;
    }

    public TilePositionShelves(int abscissa, int ordinate, TileObj tile){
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
        return this.occupied;
    }

    public TileObj getTile() throws PositionEmptyException {
        if(tileInSlot != null){
            TileObj tempTile = new TileObj(tileInSlot.getType(), tileInSlot.getVariant());
            return tempTile;
        }
        else throw new PositionEmptyException();
    }

    public void setTile(TileObj tile) throws PositionAlreadyOccupiedException {
        if(this.occupied == false){
            this.tileInSlot= tile;
            this.occupied= true;
        }
        else throw new PositionAlreadyOccupiedException();
    }



}
