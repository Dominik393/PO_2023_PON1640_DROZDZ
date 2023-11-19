package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer;
    protected ArrayList<MapChangeListener> listeners = new ArrayList<>();

    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if (canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            mapChanged(animal, null, animal.getPosition());
        }else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    public void move(Animal animal, MoveDirection direction) {
        Vector2d old_pos = animal.getPosition();
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
        mapChanged(animal, old_pos, animal.getPosition());
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

    public String mapChanged(Animal animal, Vector2d oldVector2d, Vector2d newVector2d){
        String result = "";
        if (oldVector2d == null){
            result = "New animal " + animal.toString() + " placed on the map at " + newVector2d.toString();
        }
        else{
            result = "Animal " + animal.toString() + " moved from " + oldVector2d.toString() + " to " + newVector2d.toString();
        }
        for (MapChangeListener listener : listeners)
            listener.mapChanged(this, result);
        return result;
    }
}
