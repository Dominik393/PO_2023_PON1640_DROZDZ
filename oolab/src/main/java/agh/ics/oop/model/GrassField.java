package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class GrassField implements WorldMap{

    private int grassAmount;
    private Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grasscount){
        this.grassAmount = grasscount;
        
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }
}
