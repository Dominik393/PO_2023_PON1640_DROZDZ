package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer;
    protected ArrayList<MapChangeListener> listeners;

    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
        }else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
    }

    public abstract Boundry getCurrentBounds();

    @Override
    public ArrayList<WorldElement> getElements(){
        return new ArrayList<WorldElement>(animals.values());
    }

    @Override
    public String toString() {
        Boundry boundry = getCurrentBounds();
        return visualizer.draw(boundry.lowerLeft(), boundry.upperRight());
    }

    public void addListener(MapChangeListener listener){
        listeners.add(listener);
    }

    public void removeListener(MapChangeListener listener){
        listeners.remove(listener);
    }
}
