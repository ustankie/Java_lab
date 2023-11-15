package agh.ics.oop.model;

public class PositionNotInMapException extends Exception{
    public PositionNotInMapException(Vector2D position){
        super("Position "+position+" is not in map");
    }
}
