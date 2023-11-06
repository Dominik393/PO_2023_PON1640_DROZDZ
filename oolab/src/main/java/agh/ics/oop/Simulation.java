package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();
    private WorldMap worldMap;

    public Simulation(ArrayList<MoveDirection> mvs, ArrayList<Vector2d> poss, WorldMap wm){
        this.moves = mvs;
        this.worldMap = wm;

        for (int i=0; i < poss.size(); i++){
            if (this.worldMap.place(new Animal(poss.get(i)))) {
                this.animals.add(new Animal(poss.get(i)));
                this.worldMap.place(this.animals.get(i));
            }
        }
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public ArrayList<MoveDirection> getMoves() {
        return moves;
    }

    public void run(){
        for(int i=0; i < moves.size(); i++){
            worldMap.move(this.animals.get(i%animals.size()), this.moves.get(i));
            System.out.println(worldMap);
        }
    }
}
