package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class RandomPositionGenerator implements  Iterable<Vector2D> {
    private List<Vector2D> unused=new ArrayList<Vector2D>();
    private Random random;

    private List<Vector2D> used=new ArrayList<Vector2D>();


    public RandomPositionGenerator(int width, int height, int grassCount) {

        random=new Random();
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                unused.add(new Vector2D(i,j));
            }
        }

        for(int i=0;i<grassCount;i++){
            int size=unused.size();
            int idx=random.nextInt(size);
            Vector2D newPosition=unused.remove(idx);
            used.add(newPosition);
        }


    }

    @Override
    public Iterator<Vector2D> iterator() {
        return new RandomIterator(used);
    }
}
