package agh.ics.oop.model;

public interface WorldElement {

    Vector2D getPosition();
    String toString();
    boolean isAt(Vector2D position);
    void move(MoveDirection direction,MoveValidator validator);

}
