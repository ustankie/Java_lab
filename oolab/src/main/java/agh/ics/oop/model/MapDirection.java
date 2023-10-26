package agh.ics.oop.model;

public enum MapDirection {
    NORTH(1),EAST(2) ,SOUTH(3), WEST(4) ;
    private int id;

    MapDirection(int id){
        this.id=id;
    }

    public String toString(){
        return switch(this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }

    public MapDirection next(){
        MapDirection[] dir=MapDirection.values();
        int i=0;
        for (; dir[i]!=(this);i++){

        }
        i++;
        i%=dir.length;
        return dir[i];

    }

    public MapDirection previous(){
        MapDirection[] dir=MapDirection.values();
        int i=0;
        for (; dir[i]!=(this);i++){

        }
        i+=dir.length-1;
        i%=dir.length;
        return dir[i];
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
