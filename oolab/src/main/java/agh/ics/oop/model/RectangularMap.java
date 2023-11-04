package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import com.sun.source.util.JavacTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap implements WorldMap {
    Map<Vector2D, Animal> animals = new HashMap<>();
    List<Animal> animalsOnMap=new ArrayList<Animal>();

    private int width;
    private int height;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Map<Vector2D, Animal> getAnimals() {
        return animals;
    }

    public boolean isOnMap(Animal animal){
        for (Animal value : animalsOnMap) {
            if (value == animal) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()) && !isOnMap(animal)){
            animals.put(animal.getPosition(),animal);
            animalsOnMap.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if(!isOnMap(animal))
            return;
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(),animal);
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position)!=null;
    }

    @Override
    public Animal objectAt(Vector2D position) {
        return animals.get(position);
    }


    @Override
    public boolean canMoveTo(Vector2D position) {
        if(position.getX()>width || position.getY()>height
                || position.getX()<0 || position.getY()<0)
        {
            return false;
        }
        return !isOccupied(position);
    }


    @Override
    public String toString() {
        MapVisualizer map=new MapVisualizer(this);

        return map.draw(new  Vector2D(0,0), new Vector2D(width,height));
    }
}
