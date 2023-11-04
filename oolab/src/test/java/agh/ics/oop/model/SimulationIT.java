package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SimulationIT {
    @Test
    public void dataInterpretationTest1(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        List<MoveDirection> result =List.of(MoveDirection.FORWARD,MoveDirection.BACKWARD,
                MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,
                MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.FORWARD);

        Assertions.assertEquals(result, moveDirectionList);
    }

    @Test
    public void dataInterpretationTest2(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};
        RectangularMap map=new RectangularMap(6,7);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),
                new Vector2D(6,7),new Vector2D(-1,4),new Vector2D(7,8));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);

        List<Animal> animals2=Arrays.asList(new Animal(new Vector2D(2,2)),new Animal(new Vector2D(3,4))
                ,new Animal(new Vector2D(6,7)));

        Assertions.assertNotNull(simulation.getAnimals());
        Assertions.assertTrue(simulation.getAnimals() instanceof List<Animal>);

        Assertions.assertNotNull(simulation.getMoveDirectionList());
        Assertions.assertTrue(simulation.getMoveDirectionList() instanceof List<MoveDirection>);


        Assertions.assertEquals(animals2.size(),simulation.getAnimals().size());
        Assertions.assertEquals(animals2,simulation.getAnimals());

        Assertions.assertEquals(moveDirectionList,simulation.getMoveDirectionList());
    }

    @Test
    public void positionTest(){
        String[] args={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        RectangularMap map=new RectangularMap(3,5);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);
        simulation.run();

        Assertions.assertTrue(simulation.getAnimals().get(0).isAt(new Vector2D(3,3)));
        Assertions.assertTrue(simulation.getAnimals().get(1).isAt(new Vector2D(3,4)));
        Assertions.assertTrue(simulation.getAnimals().get(2).isAt(new Vector2D(2,4)));

        String[] args1={"f", "b",
                "r", "l",
                "f", "f",
                "r", "r",
                "f", "f",
                "f", "f",
                "r", "b",
                "f","f"};

        RectangularMap map1=new RectangularMap(2,4);
        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(1,4),new Vector2D(-1,4),new Vector2D(1,5));
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args);
        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);
        simulation1.run();

        Assertions.assertTrue(simulation1.getAnimals().get(0).isAt(new Vector2D(1,1)));
        Assertions.assertTrue(simulation1.getAnimals().get(1).isAt(new Vector2D(0,4)));
    }
    @Test
    public void orientationTest(){
        String[] args={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        RectangularMap map=new RectangularMap(3,5);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);
        simulation.run();

        Assertions.assertEquals(simulation.getAnimals().get(0).getDirection(),MapDirection.EAST);
        Assertions.assertEquals(simulation.getAnimals().get(1).getDirection(),MapDirection.EAST);
        Assertions.assertEquals(simulation.getAnimals().get(2).getDirection(),MapDirection.EAST);

        String[] args1={"f", "b",
                "r", "l",
                "f", "f",
                "r", "r",
                "f", "f",
                "f", "f",
                "r", "b",
                "f","f"};

        RectangularMap map1=new RectangularMap(2,4);
        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(1,4),new Vector2D(-1,4),new Vector2D(1,5));
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args);
        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);
        simulation1.run();


        Assertions.assertEquals(simulation1.getAnimals().get(0).getDirection(),MapDirection.WEST);
        Assertions.assertEquals(simulation1.getAnimals().get(1).getDirection(),MapDirection.NORTH);

    }

    @Test
    public void mapEqualityTest(){
        String[] args={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        RectangularMap map=new RectangularMap(3,5);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);
        simulation.run();

        Animal animal1Res=new Animal(new Vector2D(3,3));
        Animal animal2Res=new Animal(new Vector2D(3,4));
        Animal animal3Res=new Animal(new Vector2D(2,4));

        animal1Res.setDirection(MapDirection.EAST);
        animal2Res.setDirection(MapDirection.EAST);
        animal3Res.setDirection(MapDirection.EAST);

        RectangularMap mapRes=new RectangularMap(3,5);
        mapRes.place(animal1Res);
        mapRes.place(animal2Res);
        mapRes.place(animal3Res);

        Assertions.assertEquals(map.toString(),mapRes.toString());


        String[] args1={"f", "b",
                "r", "l",
                "f", "f",
                "r", "r",
                "f", "f",
                "f", "f",
                "r", "b",
                "f","f"};

        RectangularMap map1=new RectangularMap(2,4);
        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(1,4),new Vector2D(-1,4),new Vector2D(1,5));
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args);
        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);
        simulation1.run();

        Animal animal1Res1=new Animal(new Vector2D(1,1));
        Animal animal2Res1=new Animal(new Vector2D(0,4));

        animal1Res1.setDirection(MapDirection.WEST);
        animal2Res1.setDirection(MapDirection.NORTH);

        RectangularMap mapRes1=new RectangularMap(2,4);
        mapRes1.place(animal1Res1);
        mapRes1.place(animal2Res1);

        Assertions.assertEquals(map1.toString(),mapRes1.toString());
    }



    @Test
    public void isInMapTest(){
        String[] args={"f","r","l","b",
                        "r","f","f","l",
                        "r","r","l","b",
                        };
        RectangularMap map=new RectangularMap(5,6);
        List<Vector2D> positions= List.of(new Vector2D(2,4),new Vector2D(4,4),
                new Vector2D(-1,4),new Vector2D(0,0),new Vector2D(6,7));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);
        simulation.run();

        for(int i=0;i<simulation.getAnimals().size();i++){
            Assertions.assertFalse(simulation.getAnimals().get(i).getPosition().x()<0
                    || simulation.getAnimals().get(i).getPosition().x()>map.getWidth()
                    || simulation.getAnimals().get(i).getPosition().y()<0
                    || simulation.getAnimals().get(i).getPosition().y()>map.getHeight());
        }


        String[] args1={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        RectangularMap map1=new RectangularMap(3,5);
        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args);
        Simulation simulation1=new Simulation(moveDirectionList,positions,map);
        simulation1.run();

        for(int i=0;i<simulation1.getAnimals().size();i++){
            Assertions.assertFalse(simulation1.getAnimals().get(i).getPosition().x()<0
                    || simulation1.getAnimals().get(i).getPosition().x()>map.getWidth()
                    || simulation1.getAnimals().get(i).getPosition().y()<0
                    || simulation1.getAnimals().get(i).getPosition().y()>map.getHeight());
        }

    }

    @Test
    public void uniqueTest(){
        RectangularMap map =new RectangularMap(9,9);
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(1,4));

        map.place(animal1);
        map.place(animal2);
        map.place(animal2);

        RectangularMap map1 =new RectangularMap(9,9);
        map1.place(animal1);
        map1.place(animal2);

        Assertions.assertEquals(map.toString(),map1.toString());

        animal2.setPosition(new Vector2D(8,8));
        map.place(animal2);

        System.out.println(map.toString());
        System.out.println(map1.toString());
        Assertions.assertEquals(map.toString(),map1.toString());

    }

    @Test
    public void moveExisting(){
        Animal animal1=new Animal(new Vector2D(2,3));
        Animal animal2=new Animal(new Vector2D(1,4));
        RectangularMap map =new RectangularMap(9,9);

        map.place(animal1);

        map.move(animal2,MoveDirection.BACKWARD);

        RectangularMap map1 =new RectangularMap(9,9);
        map1.place(animal1);

        Assertions.assertEquals(map.toString(),map1.toString());


    }



}
