package agh.ics.oop;


import agh.ics.oop.model.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class World {

    public static void main(String[]args)  {
//        String[] args2={"f", "b", "r",
//                "l", "f", "f",
//                "r", "r", "f",
//                "f", "f", "f",
//                "r", "b", "f",
//                "f"};
//
//        GrassField map=new GrassField(10);
//        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4),new Vector2D(1,4));
//        List<MoveDirection> moveDirectionList= OptionParser.parse(args2);
//        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
//        map.subscribe(consoleMapDisplay);
//        Simulation simulation=new Simulation(moveDirectionList,positions,map);
//
//        String[] args1={"f", "b",
//                "r", "l",
//                "f", "f",
//                "r", "r",
//                "f", "f",
//                "f", "f",
//                "r", "b",
//                "f","f"};
//
//        RectangularMap map1=new RectangularMap(2,4);
//        List<Vector2D> positions1= List.of(new Vector2D(2,2),new Vector2D(1,4),new Vector2D(-1,4),new Vector2D(1,5));
//        List<MoveDirection> moveDirectionList1= OptionParser.parse(args1);
//        ConsoleMapDisplay consoleMapDisplay1=new ConsoleMapDisplay();
//        map1.subscribe(consoleMapDisplay1);
//        Simulation simulation1=new Simulation(moveDirectionList1,positions1,map1);
//
//        List<Simulation> simulationList=List.of(simulation,simulation1);




        System.setOut(new SynchronizedPrintStream(System.out));

        List<Simulation> simulationList1=new ArrayList<>();
        Random rand=new Random();
//        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();

        for(int i=0;i<1000;i++){
            List<MoveDirection> moveDirections=new ArrayList<>();
            int n= rand.nextInt(30)+1;
            for(int j=0;j<n;j++){
                moveDirections.add(MoveDirection.values()[rand.nextInt(4)]);
            }
            GrassField grassField=new GrassField(10);
            List<Vector2D> positions2=new ArrayList<>();
            int m= rand.nextInt(10)+1;
            for(int j=0;j<m;j++){
                Vector2D position=(new Vector2D(rand.nextInt(15),rand.nextInt(15)));
                positions2.add(position);
            }
            ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
            grassField.subscribe(consoleMapDisplay);
            Simulation simulation2=new Simulation(moveDirections,positions2,grassField);
            simulationList1.add(simulation2);

//            System.out.println(grassField);

            RectangularMap map=new RectangularMap(rand.nextInt(10)+2,rand.nextInt(10)+2 );
            ConsoleMapDisplay consoleMapDisplay2=new ConsoleMapDisplay();
            map.subscribe(consoleMapDisplay2);
            Simulation simulation3=new Simulation(moveDirections,positions2,map);
            simulationList1.add(simulation3);

        }

        Instant start=Instant.now();

        SimulationEngine simulationEngine=new SimulationEngine(simulationList1);
        simulationEngine.runAsyncInThreadPool();
        simulationEngine.awaitSimulationsEnd();

        Instant finish=Instant.now();
        long a= Duration.between(start,finish).toMillis();

        System.out.println("System zakończył działanie");
        System.out.println("ExecutionTime: "+a);
    }


}
