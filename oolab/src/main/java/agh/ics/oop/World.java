package agh.ics.oop;


import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2D;
import agh.ics.oop.model.Animal;

import java.util.List;


public class World {

//    public static void main(String[]args){
//        System.out.println("system wystartował");
//        //pkt 16,17
//        List<MoveDirection> parsed= OptionParser.parse(args);
//        run(parsed);
//
//        System.out.println("system zakończył działanie");
//    }
//
//    public static void run(List<MoveDirection> args){
//        for (MoveDirection arg : args){
//            if (arg!=null){
//                System.out.println(arg);
//            }
//
//        }
//    }
    public static void main(String[]args){
        Animal animal=new Animal();
        System.out.println(animal.getPosition());

        List<MoveDirection> directions = OptionParser.parse(args);
        List<Vector2D> positions = List.of(new Vector2D(2,2), new Vector2D(3,4));
        Simulation simulation = new Simulation(directions, positions);
        simulation.run();

    }


}
