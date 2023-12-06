package agh.ics.oop.model;


import java.util.Objects;

public class Animal implements WorldElement {
    private MapDirection direction;
    private Vector2D position;

    public  Animal(){
        this(new Vector2D(2,2));
    }

    public Animal(Vector2D position){

        this.direction= MapDirection.NORTH;
        this.position=position;
    }

    //  getters
    @Override
    public Vector2D getPosition(){
        return this.position;
    }
    public MapDirection getDirection(){
        return this.direction;
    }



    //    setters
    public void setPosition( Vector2D position,MoveValidator validator){
        if(validator.canMoveTo(position)) {
//            System.out.println(position);
            this.position = position;
        }
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setDirection(MapDirection direction){
        this.direction=direction;
    }


    //other methods
    @Override
    public String toString(){
        return direction.toString();
    }

    @Override
    public boolean isAt(Vector2D position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction,MoveValidator validator){
        switch(direction){
            case LEFT -> this.setDirection(this.direction.previous());
            case RIGHT -> this.setDirection(this.direction.next());
            case BACKWARD -> this.setPosition(this.position.subtract(this.direction.toUnitVector()),validator);
            case FORWARD -> this.setPosition(this.position.add(this.direction.toUnitVector()),validator);
            }


    }

    @Override
    public int hashCode() {
        return Objects.hash(direction,position);
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Animal that))
            return false;
        return position.equals(that.position) && direction==that.direction;
    }





}




