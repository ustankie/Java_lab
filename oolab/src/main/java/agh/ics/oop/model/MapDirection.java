package agh.ics.oop.model;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString(){
        return switch(this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }

    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2D toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2D(0,1);
            case SOUTH ->  new Vector2D(0,-1);
            case WEST -> new Vector2D(-1,0);
            case EAST -> new Vector2D(1,0);
        };
    }
}
