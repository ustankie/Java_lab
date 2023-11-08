package agh.ics.oop;


import agh.ics.oop.model.*;

import java.util.List;


public class World {

    public static void main(String[]args){
        Animal animal=new Animal();
        System.out.println(animal.getPosition());
        Animal animal2=new Animal(new Vector2D(1,3));


        String[] args1={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        List<MoveDirection> directions = OptionParser.parse(args1);

        RectangularMap map=new RectangularMap(6,7);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),
                new Vector2D(6,7),new Vector2D(-1,4),new Vector2D(7,8));


        Simulation simulation = new Simulation(directions, positions,map);
        System.out.println(simulation.getMoveDirectionList());
        System.out.println(simulation.getMap());
        simulation.run();

    }


}
