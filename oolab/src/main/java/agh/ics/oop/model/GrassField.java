package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField implements WorldMap{

    private int grassAmount;
    private Map<Vector2d, Grass> grasses = new HashMap<>();
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private int grassDist;

    public GrassField(int grasscount){
        this.grassAmount = grasscount;

        this.grassDist = (int) Math.floor(Math.sqrt(grassAmount * 10));

        HashMap<Integer, HashMap<Integer, Boolean>> aviableSpaces = new HashMap<>();

        for(int i=0; i<=this.grassDist; i++){
            aviableSpaces.put(i, new HashMap<Integer, Boolean>());
            for(int j=0; j<= this.grassDist; j++){
                aviableSpaces.get(i).put(j,Boolean.TRUE);
            }
        }

        Random random = new Random();

        for(int i=0; i<this.grassAmount; i++){
            ArrayList<Integer> toPickFrom = new ArrayList<>(aviableSpaces.keySet());
            int chosenOneX = toPickFrom.get(random.nextInt(toPickFrom.size()));
            toPickFrom = new ArrayList<>(aviableSpaces.get(chosenOneX).keySet());
            int chosenOneY = toPickFrom.get(random.nextInt(toPickFrom.size()));
            aviableSpaces.get(chosenOneX).remove(chosenOneY);
            if (aviableSpaces.get(chosenOneX).isEmpty()){
                aviableSpaces.remove(chosenOneX);
            }

            this.grasses.put(new Vector2d(chosenOneX,chosenOneY), new Grass(new Vector2d(chosenOneX,chosenOneY)));
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal) && position.follows(new Vector2d(0,0));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
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
        return (animals.containsKey(position) || grasses.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        } else return grasses.getOrDefault(position, null);
    }

    @Override
    public String toString() {
        MapVisualizer mv = new MapVisualizer(this);
        ArrayList<Vector2d> animalPositions = new ArrayList<>(animals.keySet());
        int maxX = this.grassDist, maxY = this.grassDist;
        for(int i=0; i < animalPositions.size(); i++){
            maxX = Math.max(maxX, animalPositions.get(i).getX());
            maxY = Math.max(maxY, animalPositions.get(i).getY());
        }
        return mv.draw(new Vector2d(0,0), new Vector2d(maxX, maxY));
    }
}
