package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap  {
    private Map<Vector2D,Animal> animals;
    List<Animal> animalsOnMap;

    private int width;
    private int height;

    public RectangularMap(int width, int height){
        animalsOnMap=super.getAnimalsOnMap();
        animals=super.getAnimals();
        this.width=width;
        this.height=height;

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public boolean canMoveTo(Object position1) {
        Vector2D position=(Vector2D) position1;
        if(position.getX()>width || position.getY()>height
                || position.getX()<0 || position.getY()<0)
        {
            return false;
        }
        return super.canMoveTo(position1);
    }


    @Override
    public String toString() {
        return super.toString(new Vector2D(0,0),new Vector2D(width,height));
    }
}
