package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

public class Simulation implements Runnable{
    private List<Animal> animals;
    private static AtomicInteger allPlaced=new AtomicInteger();
    private List<MoveDirection> moveDirectionList;
    private WorldMap<WorldElement,Vector2D> map;
    public Simulation(List<MoveDirection> moveDirectionList, List<Vector2D> movePositionList, WorldMap<WorldElement,Vector2D> map){
        this.map=map;

        int l=movePositionList.size();
        animals=new ArrayList<Animal>();


        for (Vector2D vector2D : movePositionList) {
            Animal currAnimal=new Animal(vector2D);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try{
                if (vector2D!=null && this.map.place(currAnimal)){
                    this.animals.add(currAnimal);

                }
            }catch(PositionAlreadyOccupiedException e){
//                System.out.println("Map id: " + map.getId() + ": " + e.getMessage());

            }


        }


        this.moveDirectionList=new ArrayList<MoveDirection>(moveDirectionList);
        allPlaced.incrementAndGet();
    }

    public static AtomicInteger getAllPlaced() {
        return allPlaced;
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<MoveDirection> getMoveDirectionList(){
        return moveDirectionList;
    }

    public WorldMap<WorldElement,Vector2D> getMap() {
        return map;
    }

    public  void run(){

            int currAnimalInd=0;
            int animalsLength=animals.size();

            Animal currAnimal;

            if(animalsLength==0){
                return;
            }


            for(MoveDirection direction: moveDirectionList){
                currAnimal=animals.get(currAnimalInd);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                map.move(currAnimal,direction);

                currAnimalInd=(currAnimalInd+1)%animalsLength;

        }

    }


}
