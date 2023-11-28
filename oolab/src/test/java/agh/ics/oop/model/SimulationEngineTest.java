package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngineTest {

    @Test
    public void twoMapTest(){
        String[] args={"f", "b", "r",
                "l", "f", "f",
                "r", "r", "f",
                "f", "f", "f",
                "r", "b", "f",
                "f"};

        GrassField map=new GrassField(10);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
        List<MoveDirection> moveDirectionList= OptionParser.parse(args);
        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
        map.subscribe(consoleMapDisplay);
        Simulation simulation=new Simulation(moveDirectionList,positions,map);

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
        List<MoveDirection> moveDirectionList1= OptionParser.parse(args1);
        ConsoleMapDisplay consoleMapDisplay1=new ConsoleMapDisplay();
        map1.subscribe(consoleMapDisplay1);
        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);

        List<Simulation> simulationList=List.of(simulation,simulation1);

        SimulationEngine simulationEngine=new SimulationEngine(simulationList);
        simulationEngine.runSync();

        Assertions.assertEquals(simulation.getAnimals().get(0).getDirection(),MapDirection.EAST);
        Assertions.assertEquals(simulation.getAnimals().get(1).getDirection(),MapDirection.EAST);
        Assertions.assertEquals(simulation.getAnimals().get(2).getDirection(),MapDirection.EAST);

        Assertions.assertTrue(simulation.getAnimals().get(0).isAt(new Vector2D(3,3)));
        Assertions.assertTrue(simulation.getAnimals().get(1).isAt(new Vector2D(4,4)));
        Assertions.assertTrue(simulation.getAnimals().get(2).isAt(new Vector2D(3,4)));


        Assertions.assertEquals(simulation1.getAnimals().get(0).getDirection(),MapDirection.WEST);
        Assertions.assertEquals(simulation1.getAnimals().get(1).getDirection(),MapDirection.NORTH);

        Assertions.assertTrue(simulation1.getAnimals().get(0).isAt(new Vector2D(1,1)));
        Assertions.assertTrue(simulation1.getAnimals().get(1).isAt(new Vector2D(0,4)));


    }
}
