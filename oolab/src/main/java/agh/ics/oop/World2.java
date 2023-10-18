package agh.ics.oop;
import agh.ics.oop.model.Vector2D;
import agh.ics.oop.model.MapDirection;
import java.util.Objects;


public class World2 {

        public static void main(String[]args){
        Vector2D position1 = new Vector2D(1,1);
        System.out.println(position1);
        Vector2D position2 = new Vector2D(1,2);
        System.out.println(position2);
        System.out.println(position1.equals(position2));
    }
}
