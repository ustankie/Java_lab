package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2D;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Simulation {
    private List<Animal> animals;;
    private List<MoveDirection> moveDirectionList;
    private WorldMap map;
    public Simulation(List<MoveDirection> moveDirectionList, List<Vector2D> movePositionList, WorldMap map){
        this.map=map;

        int l=movePositionList.size();
        animals=new ArrayList<Animal>();


        for (Vector2D vector2D : movePositionList) {
            Animal currAnimal=new Animal(vector2D);
            if (vector2D!=null && this.map.place(currAnimal))
                this.animals.add(currAnimal);
        }

        this.moveDirectionList=new ArrayList<MoveDirection>(moveDirectionList);
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<MoveDirection> getMoveDirectionList(){
        return moveDirectionList;
    }

    public WorldMap getMap() {
        return map;
    }

    public void run(){
        int currAnimalInd=0;
        int animalsLength=animals.size();

        Animal currAnimal;


        for(MoveDirection direction: moveDirectionList){
            currAnimal=animals.get(currAnimalInd);
            map.move(currAnimal,direction);

            System.out.println(map);

            currAnimalInd=(currAnimalInd+1)%animalsLength;
        }
    }


}
