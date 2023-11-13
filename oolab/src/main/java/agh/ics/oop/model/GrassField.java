package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private int grassAmount;
    private Map<Vector2d, Grass> grasses = new HashMap<>();
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
    public boolean isOccupied(Vector2d position) {
        return (super.animals.containsKey(position) || grasses.containsKey(position));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.animals.containsKey(position)){
            return super.animals.get(position);
        } else return grasses.getOrDefault(position, null);
    }

    @Override
    public String toString() {
        MapVisualizer mv = new MapVisualizer(this);
        ArrayList<Vector2d> animalPositions = new ArrayList<>(super.animals.keySet());
        int maxX = this.grassDist, maxY = this.grassDist;
        for (Vector2d animalPosition : animalPositions) {
            maxX = Math.max(maxX, animalPosition.getX());
            maxY = Math.max(maxY, animalPosition.getY());
        }
        return mv.draw(new Vector2d(0,0), new Vector2d(maxX, maxY));
    }

    @Override
    public ArrayList<WorldElement> getElements() {
        ArrayList<WorldElement> answ = new ArrayList<WorldElement>(animals.values());
        answ.addAll(grasses.values());
        return answ;
    }
}
