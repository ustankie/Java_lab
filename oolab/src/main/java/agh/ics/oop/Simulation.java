package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2D;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class Simulation {
    private List<Animal> animals;;
    private List<MoveDirection> moveDirectionList;
    public Simulation(List<MoveDirection> moveDirectionList, List<Vector2D> movePositionList){

        int l=movePositionList.size();
        animals=new ArrayList<Animal>();

        for (Vector2D vector2D : movePositionList) {
            if (vector2D!=null)
                this.animals.add(new Animal(vector2D));
        }

        this.moveDirectionList=new ArrayList<MoveDirection>(moveDirectionList);
    }

    public List<Animal> getAnimals(){
        return animals;
    }

    public List<MoveDirection> getMoveDirectionList(){
        return moveDirectionList;
    }
    public void run(){
        int currAnimalInd=0;
        int animalsLength=animals.size();

        Animal currAnimal;


        for(MoveDirection direction: moveDirectionList){
            currAnimal=animals.get(currAnimalInd);
            currAnimal.move(direction);

            System.out.println("Zwierzę "+currAnimalInd+" : "+currAnimal.toString());

            currAnimalInd=(currAnimalInd+1)%animalsLength;
        }
    }
}
