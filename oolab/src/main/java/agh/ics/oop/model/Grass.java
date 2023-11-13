package agh.ics.oop.model;

public class Grass implements  WorldElement{
    private Vector2D position;

    public Grass(Vector2D position){
        this.position=position;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }
    @Override
    public boolean isAt(Vector2D position){
        return position.equals(this.position);
    }

    @Override
    public void move(MoveDirection direction, MoveValidator validator) {

    }


}
