package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    public void SimulationTest(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(0,0));
        WorldMap worldMap = new RectangularMap(4,4);

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r"});
        Simulation sim = new Simulation(moves, positions, worldMap);
        sim.run();

        assertEquals(new Vector2d(0, 2) ,sim.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(1,0), sim.getAnimals().get(1).getPosition());

    }

    @Test
    public void SimulationTest2(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(1,0));
        positions.add(new Vector2d(1,1));
        WorldMap worldMap = new RectangularMap(4,4);

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r",
                "l", "r", "f", "b", "b"});
        Simulation sim = new Simulation(moves, positions, worldMap);
        sim.run();

        assertEquals(new Vector2d(0, 2) ,sim.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(2,1), sim.getAnimals().get(1).getPosition());
        assertEquals(new Vector2d(2,3), sim.getAnimals().get(2).getPosition());

    }

}
