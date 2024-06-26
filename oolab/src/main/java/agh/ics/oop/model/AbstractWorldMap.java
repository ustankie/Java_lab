package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class  AbstractWorldMap implements WorldMap<WorldElement,Vector2D> {
    protected static int curr_id=0;
    private final int id;
    private Map<Vector2D,Animal> animals = new HashMap<>();
    List<Animal> animalsOnMap=new ArrayList<Animal>();
    List<MapChangeListener> listeners=new ArrayList<MapChangeListener>();

    public Map<Vector2D,Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getAnimalsOnMap() {
        return animalsOnMap;
    }

    public AbstractWorldMap(){
        this.id=curr_id;
        curr_id+=1;
    }

    public static int getCurr_id() {
        return curr_id;
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean isOnMap(WorldElement animal){
        for (WorldElement value : animalsOnMap) {
            if (value == animal) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean place(WorldElement element) throws PositionAlreadyOccupiedException{
        {

            if (canMoveTo(element.getPosition()) && !isOnMap(element)) {
                animals.put(element.getPosition(), (Animal) element);
                animalsOnMap.add((Animal) element);

                mapChanged("Animal " + element + " placed successfully on position " + element.getPosition());
                return true;


            }else{
                throw new PositionAlreadyOccupiedException((Vector2D) element.getPosition());
//                return false;
            }





    }}
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
            Animal animalTemp=new Animal(animal.getPosition());
            animalTemp.setDirection(animal.getDirection());
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(),animal);
            if(!animalTemp.equals(animal))
                mapChanged("Animal moved "+ direction +" from position "+animalTemp.getPosition()+",direction "
                        +animalTemp.getDirection()+ ", currently on position "+animal.getPosition()+", direction "+animal.getDirection());
        }
    }

    public String toString() {
        MapVisualizer map=new MapVisualizer(this);
        return map.draw(getCurrentBounds().lowerLeft(),getCurrentBounds().upperRight());
    }
    @Override
    public List<WorldElement> getElements(){
        return (List<WorldElement>) (List<?>) animalsOnMap;
    }

    public abstract Boundary getCurrentBounds();


    public void subscribe(MapChangeListener listener){
        for(MapChangeListener l:listeners){
            if(l==listener)
                return;
        }
        listeners.add(listener);
    }

    public void unsubscribe(MapChangeListener listener){
        listeners.remove(listener);
    }

    public void mapChanged(String message){
        for(MapChangeListener l:listeners){
            l.mapChanged(this,message);
        }
    }
    public abstract AbstractWorldMap clone();

}
