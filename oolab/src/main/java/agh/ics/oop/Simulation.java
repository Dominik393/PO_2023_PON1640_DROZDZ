package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;

public class Simulation implements Runnable {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();
    private WorldMap worldMap;

    public Simulation(ArrayList<MoveDirection> mvs, ArrayList<Vector2d> poss, WorldMap wm){
        this.moves = mvs;
        this.worldMap = wm;
        Animal temp;

        for (int i=0; i < poss.size(); i++){
            try {
                temp = new Animal(poss.get(i));
                this.worldMap.place(temp);
                this.animals.add(temp);
            }catch (PositionAlreadyOccupiedException e){
                System.out.println(e.getMessage());
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

    @Override
    public void run(){
        for(int i=0; i < moves.size(); i++){
            worldMap.move(this.animals.get(i%animals.size()), this.moves.get(i));
        }
    }
}
