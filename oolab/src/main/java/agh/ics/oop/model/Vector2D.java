package agh.ics.oop.model;

public record Vector2D(int x, int y) {

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2D other) {
        return other.x >= x() && other.y >= y();
    }

    public boolean follows(Vector2D other) {
        return other.x <= x() && other.y <= y();
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x() + other.x, y() + other.y);
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x() - other.x, y() - other.y);
    }

    public Vector2D upperRight(Vector2D other) {
        return new Vector2D(Math.max(x(), other.x), Math.max(y(), other.y));
    }

    public Vector2D lowerLeft(Vector2D other) {
        return new Vector2D(Math.min(x(), other.x), Math.min(y(), other.y));
    }

    public Vector2D opposite() {

        return new Vector2D((-1) * x(), (-1) * y());
    }


    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2D))
            return false;
        Vector2D that = (Vector2D) other;
        return x == that.x && y == that.y;
    }


}
