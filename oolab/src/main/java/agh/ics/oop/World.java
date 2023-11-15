package agh.ics.oop;


import agh.ics.oop.model.*;

import java.util.List;


public class World {

    public static void main(String[]args){
        Animal animal=new Animal();
        Animal animal2=new Animal(new Vector2D(1,3));


        String[] args1={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f","f"};
        List<MoveDirection> directions = OptionParser.parse(args1);

        GrassField grassField=new GrassField(10);
        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
        grassField.subscribe(consoleMapDisplay);
        System.out.println(grassField);


        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),
                new Vector2D(6,7),new Vector2D(-1,4),new Vector2D(7,8));


        Simulation simulation = new Simulation(directions, positions,grassField);
        System.out.println(simulation.getMoveDirectionList());
        System.out.println(simulation.getMap());
        simulation.run();

        System.out.println(grassField.getElements());

        RectangularMap map=new RectangularMap(3,6);
        map.place(new Animal(new Vector2D(3,5)));
        map.place(new Animal(new Vector2D(3,7)));


        GrassField grassField1=new GrassField(10);
        Animal animala=new Animal(new Vector2D(1,0));
        Grass grass=new Grass(new Vector2D(2,2));
        Animal animal1=new Animal(new Vector2D(-1,100));
        Animal animal2a=new Animal(new Vector2D(-1,100));
        Animal grass1=new Animal(new Vector2D(0,0));
        Animal animal3=new Animal(new Vector2D(0,0));

        grassField1.place(animala);
        grassField1.place(grass);
        grassField1.place(animal1);
        grassField1.place(animal2a);
        grassField1.place(grass1);
        grassField1.place(animal3);


        grassField.move(animala,MoveDirection.BACKWARD);




    }


}
