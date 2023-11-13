package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class  AbstractWorldMap implements WorldMap<WorldElement,Vector2D> {
    private Map<Vector2D,Animal> animals = new HashMap<>();
    List<Animal> animalsOnMap=new ArrayList<Animal>();
    public Map<Vector2D,Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getAnimalsOnMap() {
        return animalsOnMap;
    }

    public boolean isOnMap(WorldElement animal){
        for (Animal value : animalsOnMap) {
            if (value == animal) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean place(WorldElement element) {
        if (canMoveTo(element.getPosition()) && !isOnMap(element)){
            animals.put(element.getPosition(),(Animal)element);
            animalsOnMap.add((Animal)element);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position)!=null;
    }
    @Override
    public WorldElement objectAt(Vector2D position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Object position1) {
        Vector2D position=(Vector2D) position1;
        return !isOccupied(position);
    }
    @Override
    public void move(WorldElement element, MoveDirection direction) {
        if(!isOnMap(element))
            return;
        if(element instanceof Animal animal){
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(),animal);
        }
    }

    public String toString(Vector2D lower, Vector2D upper) {
        MapVisualizer map=new MapVisualizer(this);
        return map.draw(lower, upper);
    }
    @Override
    public List<WorldElement> getElements(){
        return (List<WorldElement>) (List<?>) animalsOnMap;
    }
}
