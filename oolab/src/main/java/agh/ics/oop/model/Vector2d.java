package agh.ics.oop.model;

public class Vector2d {
    private final int X;
    private final int Y;

    public Vector2d(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        return "(%d,%d)".formatted(X, Y);
    }

    public boolean precedes(Vector2d other) {
        return (X <= other.getX()) && (Y <= other.getY());
    }

    public boolean follows(Vector2d other) {
        return (X >= other.getX()) && (Y >= other.getY());
    }

    public Vector2d add(Vector2d other) {
        return new Vector2d(X + other.getX(), Y + other.getY());
    }

    public Vector2d subtract(Vector2d other) {
        return new Vector2d(X - other.getX(), Y - other.getY());
    }

    public Vector2d upperRight(Vector2d other) {
        return new Vector2d(Math.max(X, other.getX()), Math.max(Y, other.getY()));
    }

    public Vector2d lowerLeft(Vector2d other) {
        return new Vector2d(Math.min(X, other.getX()), Math.min(Y, other.getY()));
    }

    public Vector2d opposite() {
        return new Vector2d(-X, -Y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Vector2d)) {
            return false;
        }

        Vector2d vec = (Vector2d) other;

        return ((vec.getX() == X) && (vec.getY() == Y));

    }
}
