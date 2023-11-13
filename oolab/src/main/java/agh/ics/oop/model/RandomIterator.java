package agh.ics.oop.model;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomIterator implements Iterator<Vector2D> {
    private List<Vector2D> used;

    public RandomIterator(List<Vector2D> used){
        this.used =used;

    }
    @Override
    public boolean hasNext() {
        return !used.isEmpty();
    }

    @Override
    public Vector2D next() {
        return used.remove(0);
    }
}
