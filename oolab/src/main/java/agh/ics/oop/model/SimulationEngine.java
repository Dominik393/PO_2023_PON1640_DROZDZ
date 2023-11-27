package agh.ics.oop.model;

import agh.ics.oop.Simulation;

import java.util.ArrayList;

public class SimulationEngine {
    private ArrayList<Simulation> simulations;

    public SimulationEngine(ArrayList<Simulation> simulationss){
        this.simulations = simulationss;
    }

    public void runSync(){
        for(Simulation simulation : simulations){
            simulation.run();
        }
    }

    public void runAsync(){
        ArrayList<Thread> threads = new ArrayList<>();

        for(Simulation simulation: simulations){
            Thread thread = new Thread(simulation);
            threads.add(new Thread(simulation));
            thread.start();
        }
    }

    public void awaitSimulationsEnd(){
        
    }
}
