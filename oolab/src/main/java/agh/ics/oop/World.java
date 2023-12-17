package agh.ics.oop;


import agh.ics.oop.model.*;
import javafx.application.Application;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class World {

    public static void main(String[]args)  {

        Application.launch(SimulationApp.class, args);
    }
//
//        System.setOut(new SynchronizedPrintStream(System.out));
//
//        List<Simulation> simulationList1=new ArrayList<>();
//        Random rand=new Random();
////        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
//
//        for(int i=0;i<1000;i++){
//            List<MoveDirection> moveDirections=new ArrayList<>();
//            int n= rand.nextInt(30)+1;
//            for(int j=0;j<n;j++){
//                moveDirections.add(MoveDirection.values()[rand.nextInt(4)]);
//            }
//            GrassField grassField=new GrassField(10);
//            List<Vector2D> positions2=new ArrayList<>();
//            int m= rand.nextInt(10)+2;
//            for(int j=0;j<m;j++){
//                Vector2D position=(new Vector2D(rand.nextInt(15),rand.nextInt(15)));
//                positions2.add(position);
//            }
//            ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
//            grassField.subscribe(consoleMapDisplay);
//            Simulation simulation2=new Simulation(moveDirections,positions2,grassField);
//            simulationList1.add(simulation2);
//
////            System.out.println(grassField);
//
//            RectangularMap map=new RectangularMap(rand.nextInt(10)+2,rand.nextInt(10)+2 );
//            ConsoleMapDisplay consoleMapDisplay2=new ConsoleMapDisplay();
//            map.subscribe(consoleMapDisplay2);
//            Simulation simulation3=new Simulation(moveDirections,positions2,map);
//            simulationList1.add(simulation3);
//
//        }
//
//
//
//
//
//        Instant start=Instant.now();
//
//        SimulationEngine simulationEngine=new SimulationEngine(simulationList1);
//        simulationEngine.runAsync();
//        simulationEngine.awaitSimulationsEnd();
//
//        Instant finish=Instant.now();
//        long a= Duration.between(start,finish).toMillis();
//
//        System.out.println("System zakończył działanie");
//        System.out.println("ExecutionTime: "+a);
//    }


}
