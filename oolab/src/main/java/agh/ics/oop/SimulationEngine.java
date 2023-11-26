package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine  {
    private List<Simulation> simulationList;
    private List<Thread> threads;
    private ExecutorService executorService;
    public SimulationEngine(List<Simulation> simulationList) {
        this.simulationList = simulationList;
        this.threads=new ArrayList<>();
        executorService = Executors.newFixedThreadPool(4);


    }

    public void runSync() {
        for (Simulation simulation : simulationList) {
            simulation.run();
        }
    }

    public void runAsync(){
        for (Simulation simulation : simulationList) {
            Thread thread=new Thread(simulation);
            threads.add(thread);
//            synchronized (this)
            {
                thread.start();
//                awaitSimulationsEnd();
            }

        }

    }

    public void awaitSimulationsEnd()  {
        for (Thread thread : threads) {
            try{
                thread.join();
            }catch(InterruptedException ignored){

            }

        }

        executorService.shutdown();

        try{
            if(!executorService.awaitTermination(10, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        }catch (InterruptedException ignored) {

        }

    }

    public void runAsyncInThreadPool(){
        for (Simulation simulation : simulationList) {
            executorService.submit(simulation);
        }
    }


}
