package agh.ics.oop.model;

//import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

import static java.lang.Math.min;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private int grassPieces;
    private Map<Vector2D,Grass> grass= new HashMap<>();
    private Map<Vector2D,Animal> animals;
    List<Animal> animalsOnMap;
    List<Grass> grassOnMap=new ArrayList<Grass>();

    public GrassField(int grassPieces){
        //atrybuty
        animals=super.getAnimals();
        animalsOnMap=super.getAnimalsOnMap();
        this.grassPieces=grassPieces;

        //generowanie losowej trawy
        int width=(int)(sqrt(grassPieces*10));
        int height=(int)(sqrt(grassPieces*10));
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(width, height, grassPieces);

        for (Vector2D grassPosition : randomPositionGenerator) {
            Grass grass1=new Grass(grassPosition);
            place(grass1);
        }

    }
    //pomocniczy konstruktor (na potrzeby testów)
    public GrassField(int grassPieces,Map<Vector2D,Grass> grass){

        animals=super.getAnimals();
        animalsOnMap=super.getAnimalsOnMap();

        this.grassPieces=grassPieces;
        this.grass=grass;

    }

    public int getGrassPieces() {
        return grassPieces;
    }

    public List<Grass> getGrassOnMap() {
        return grassOnMap;
    }

    public Map<Vector2D, Grass> getGrass() {
        return grass;
    }

    @Override
    public boolean isOnMap(WorldElement element){
        if(super.isOnMap(element))
            return true;

        for (WorldElement value : grassOnMap) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Object position1) {
        if(super.canMoveTo(position1)){
            return true;
        }
        try{
            if(objectAt((Vector2D) position1) instanceof Grass){
                return true;
            }
            else{
                throw new PositionAlreadyOccupiedException((Vector2D) position1);
            }

        }catch(PositionAlreadyOccupiedException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean place(WorldElement element) {

        if(element instanceof Animal){
            return super.place(element);
        }

        if(element instanceof Grass) {
            if (canMoveTo(element.getPosition()) && !isOnMap(element)) {
                grassOnMap.add((Grass) element);
                grass.put(element.getPosition(), (Grass) element);
                return true;
            }
        }

        return false;
    }

    @Override
    public void move(WorldElement element, MoveDirection direction) {
        if(!isOnMap(element))
            return;
        super.move(element,direction);

        if(element instanceof Grass){
            grass.remove(element.getPosition());
            element.move(direction, this);
            grass.put(element.getPosition(),(Grass) element);
        }

    }


    @Override
    public WorldElement objectAt(Vector2D position) {
        WorldElement animal=super.objectAt(position);
        if(animal!=null)
            return animal;

        return grass.get(position);
    }

    private Vector2D upperEdge(){
        if(grass.isEmpty()&& animals.isEmpty()){
            return new Vector2D(0,0);
        }
        Vector2D upper= (Vector2D) grass.keySet().toArray()[0];
        for(int i=1; i<grass.size();i++){
            Vector2D key= (Vector2D) grass.keySet().toArray()[i];
            upper=upper.upperRight(key);
        }
        for(int i=0; i<animals.size();i++){
            Vector2D key= (Vector2D) animals.keySet().toArray()[i];
            upper=upper.upperRight(key);
        }


        return upper;
    }
    private Vector2D lowerEdge(){
        if(grass.isEmpty() && animals.isEmpty()){
            return new Vector2D(0,0);
        }
        Vector2D lower= (Vector2D) grass.keySet().toArray()[0];
        for(int i=1; i<grass.size();i++){
            Vector2D key= (Vector2D) grass.keySet().toArray()[i];
            lower=lower.lowerLeft(key);
        }
        for(int i=0; i<animals.size();i++){
            Vector2D key= (Vector2D) animals.keySet().toArray()[i];
            lower=lower.lowerLeft(key);
        }

        return lower;
    }




    @Override
    public List<WorldElement> getElements(){
        List<WorldElement> list=super.getElements();
        list.addAll((List<WorldElement>) (List<?>) grassOnMap);
        return list;
    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(lowerEdge(),upperEdge());
    }
}
