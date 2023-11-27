package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class World {
    static void run(ArrayList<MoveDirection> args){
        for(int i=0; i < args.size(); i++) {
            switch (args.get(i)) {
                case LEFT -> System.out.print("zwierzak skręca w lewo");
                case RIGHT -> System.out.print("zwierzak skręca w prawo");
                case BACKWARD -> System.out.print("zwierzak idzie do tyłu");
                case FORWARD -> System.out.print("zwierzak idzie do przodu");
            }
            if (i < args.size()-1) {
                System.out.println(',');
            }else {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(OptionParser.move_parser(args));

        System.out.println();

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println();
        MapDirection direction = MapDirection.NORTH;
        System.out.println(direction);
        System.out.println(direction.previous());
        System.out.println(direction.next());
        System.out.println(direction.toUnitVector());

        Animal beast = new Animal();
        System.out.println(beast);
        System.out.println();

        ArrayList<MoveDirection> directions = OptionParser.move_parser(args);
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        RectangularMap worldMap = new RectangularMap(4,4);
        worldMap.addListener(new ConsoleMapDisplay());
        GrassField grassField = new GrassField(10);
        grassField.addListener(new ConsoleMapDisplay());
        positions.add(new Vector2d(2,2));
        positions.add(new Vector2d(2,3));
        Simulation simulation1 = new Simulation(directions, positions, grassField);
        Simulation simulation2 = new Simulation(directions, positions, worldMap);
        ArrayList<Simulation> simulations = new ArrayList<>();
        simulations.add(simulation1);
        simulations.add(simulation2);
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
        simulationEngine.runAsync();
        System.out.println("system zakończył działanie");

    }
}
