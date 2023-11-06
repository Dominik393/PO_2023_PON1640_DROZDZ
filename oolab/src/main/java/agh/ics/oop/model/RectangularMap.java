package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap {
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private final int width;
    private final int height;
    private final Vector2d lowerleft = new Vector2d(0,0);
    private final Vector2d upperright;

    public RectangularMap(int w, int h){
        this.width = w;
        this.height = h;
        this.upperright = new Vector2d(w,h);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(isOccupied(position)) && position.follows(lowerleft) && position.precedes(upperright);
    }

    @Override
    public boolean place(Animal animal) {
        if (!(isOccupied(animal.getPosition()))){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        if (isOccupied(position)){
            return animals.get(position);
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer mv = new MapVisualizer(this);
        return mv.draw(lowerleft, upperright);
    }
}
