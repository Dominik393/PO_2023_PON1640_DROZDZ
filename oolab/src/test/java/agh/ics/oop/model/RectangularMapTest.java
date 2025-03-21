package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangularMapTest {

    @Test
    public void RectangularMapTest(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(0,0));
        RectangularMap worldMap = new RectangularMap(4,4);
        worldMap.addListener(new ConsoleMapDisplay());

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r"});
        Simulation sim = new Simulation(moves, positions, worldMap);
        sim.run();

        assertEquals(new Vector2d(1, 3) ,sim.getAnimals().get(0).getPosition());

    }

    @Test
    public void RectangularMapTest2(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(1,0));
        positions.add(new Vector2d(1,1));
        RectangularMap worldMap = new RectangularMap(4,4);
        worldMap.addListener(new ConsoleMapDisplay());

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r",
                "l", "r", "f", "b", "b"});
        Simulation sim = new Simulation(moves, positions, worldMap);
        sim.run();

        assertEquals(new Vector2d(0, 2) ,sim.getAnimals().get(0).getPosition());
        assertEquals(new Vector2d(2,1), sim.getAnimals().get(1).getPosition());
        assertEquals(new Vector2d(2,3), sim.getAnimals().get(2).getPosition());

    }

    @Test
    public void idTest(){
        RectangularMap rectangularMap1 = new RectangularMap(10,10);
        RectangularMap rectangularMap2 = new RectangularMap(10,10);
        RectangularMap rectangularMap3 = new RectangularMap(10,10);

        rectangularMap1.getId();
        rectangularMap2.getId();
        rectangularMap3.getId();

        assertEquals(0, rectangularMap1.instanceId);
        assertEquals(1, rectangularMap2.instanceId);
        assertEquals(2, rectangularMap3.instanceId);
    }

}
