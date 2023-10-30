package agh.ics.oop.model;


import java.util.Objects;

public class Animal {
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
    public Vector2D getPosition(){
        return this.position;
    }
    public MapDirection getDirection(){
        return this.direction;
    }



    //    setters
    public void setPosition( Vector2D position){
        if(position.y()>=0 && position.y()<=4 && position.x()>=0 && position.x()<=4)
            this.position=position;
    }
    public void setDirection( MapDirection direction){
        this.direction=direction;
    }


    //other methods
    public String toString(){
        return position.toString()+" "+direction.toString();
    }

    public boolean isAt(Vector2D position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        switch(direction){
            case LEFT -> this.setDirection(this.direction.previous());
            case RIGHT -> this.setDirection(this.direction.next());
            case BACKWARD -> this.setPosition(this.position.subtract(this.direction.toUnitVector()));
            case FORWARD -> this.setPosition(this.position.add(this.direction.toUnitVector()));
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




