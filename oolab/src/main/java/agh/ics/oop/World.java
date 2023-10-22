package agh.ics.oop;

import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2D;




public class World {
    public static void main(String[]args){
        Vector2D position1 = new Vector2D(1,1);
        System.out.println(position1);
        Vector2D position2 = new Vector2D(1,1);
        System.out.println(position2);
        System.out.println(position1.equals(position2));

        System.out.println(MapDirection.WEST.toUnitVector());
    }

}
