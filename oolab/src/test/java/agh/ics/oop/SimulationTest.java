package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {

    @Test
    public void SimulationTest(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(0,0));

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r"});
        Simulation sim = new Simulation(moves,positions);
        sim.run();

        assertEquals(new Vector2d(0, 2) ,sim.getAnimals().get(0).getPosition());

    }

}
