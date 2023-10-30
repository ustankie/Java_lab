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
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions);

        List<Animal> animals=Arrays.asList(new Animal(new Vector2D(2,2)),new Animal(new Vector2D(3,4)));

        Assertions.assertNotNull(simulation.getAnimals());
        Assertions.assertTrue(simulation.getAnimals() instanceof List<Animal>);

        Assertions.assertNotNull(simulation.getMoveDirectionList());
        Assertions.assertTrue(simulation.getMoveDirectionList() instanceof List<MoveDirection>);

        Assertions.assertEquals(animals,simulation.getAnimals());
        Assertions.assertEquals(moveDirectionList,simulation.getMoveDirectionList());
    }

    @Test
    public void positionTest(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};

        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions);
        simulation.run();


        Assertions.assertTrue(simulation.getAnimals().get(0).isAt(new Vector2D(3,0)));
        Assertions.assertTrue(simulation.getAnimals().get(1).isAt(new Vector2D(2,4)));

    }

    @Test
    public void orientationTest(){
        String[] args={"f", "b", "r","l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","f"};

        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions);
        simulation.run();


        Assertions.assertEquals(simulation.getAnimals().get(0).getDirection(),MapDirection.SOUTH);
        Assertions.assertEquals(simulation.getAnimals().get(1).getDirection(),MapDirection.NORTH);

    }

    @Test
    public void isInMapTest(){
        String[] args={"f","r","l","b",
                        "r","f","f","l",
                        "r","r","l","b",
                        };
        List<Vector2D> positions= List.of(new Vector2D(2,4),new Vector2D(4,4),
                new Vector2D(0,4),new Vector2D(0,0));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        Simulation simulation=new Simulation(moveDirectionList,positions);
        simulation.run();

        for(int i=0;i<positions.size();i++){
            Assertions.assertFalse(simulation.getAnimals().get(i).getPosition().x()<0
                    || simulation.getAnimals().get(i).getPosition().x()>4
                    || simulation.getAnimals().get(i).getPosition().y()<0
                    || simulation.getAnimals().get(i).getPosition().y()>4);
        }
    }


}
