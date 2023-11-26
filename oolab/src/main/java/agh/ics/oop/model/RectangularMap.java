package agh.ics.oop.model;


import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap  {
    private Map<Vector2D,Animal> animals;
    List<Animal> animalsOnMap;

    private int width;
    private int height;

    public RectangularMap(int width, int height){
        super();
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
        {


            Vector2D position = (Vector2D) position1;
//            try {
                if (position.getX() > width || position.getY() > height
                        || position.getX() < 0 || position.getY() < 0) {
//                    throw new PositionNotInMapException(position);
                    return false;
                }
//            } catch (PositionNotInMapException e) {
//                System.out.println("Map id: "+this.getId()+": "+e.getMessage());
//                return false;
//            }

//            try {
                if (super.canMoveTo(position1)) {
                    return true;
                }
//                throw new PositionAlreadyOccupiedException((Vector2D) position1);
//            } catch (PositionAlreadyOccupiedException e) {
//                System.out.println("Map id: "+this.getId()+": "+e.getMessage());
                return false;
//            }
        }
    }



    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2D(0,0),new Vector2D(width,height));
    }
}
