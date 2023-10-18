package agh.ics.oop.model;

import java.util.Objects;

public class Vector2D {
    private final int x;
    private final int y;

    public Vector2D(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public boolean precedes(Vector2D other){
        return other.x >= getX() && other.y >= getY();
    }
    public boolean follows(Vector2D other){
        return other.x <= getX() && other.y <= getY();
    }

    public Vector2D add(Vector2D other){
        return new Vector2D(getX()+other.x,getY()+other.y);
    }

    public Vector2D substract(Vector2D other){
        return new Vector2D(getX()-other.x,getY()-other.y);
    }

    public Vector2D upperRight(Vector2D other){
        return new Vector2D(Math.max(getX(),other.x),Math.max(getY(),other.y));
    }

    public Vector2D lowerLeft(Vector2D other){
        return new Vector2D(Math.min(getX(),other.x),Math.min(getY(),other.y));
    }

    public Vector2D opposite(){

        return new Vector2D((-1)*getX(),(-1)*getY());
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2D))
            return false;
        Vector2D that = (Vector2D) other;
        return x==that.x && y==that.y;
    }




}
