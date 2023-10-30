package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<MoveDirection> moves = new ArrayList<MoveDirection>();

    public Simulation(ArrayList<MoveDirection> mvs, ArrayList<Vector2d> poss){
        this.moves = mvs;

        for (int i=0; i < poss.size(); i++){
            this.animals.add(new Animal(poss.get(i), MapDirection.NORTH));
        }
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    public void run(){
        for(int i=0; i < moves.size(); i++){
            this.animals.get(i%animals.size()).move(this.moves.get(i));
            System.out.println("Zwierzę "+ i%animals.size() + ": " + this.animals.get(i%animals.size()));
        }
    }
}
