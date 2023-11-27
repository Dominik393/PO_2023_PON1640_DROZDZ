package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassFieldTest {

    @Test
    public void GrassFieldTest(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(0,0));
        GrassField worldMap = new GrassField(10);
        worldMap.addListener(new ConsoleMapDisplay());

        ArrayList<MoveDirection> moves = OptionParser.move_parser(new String[]{"f","f", "f", "r", "f", "f", "b", "r"});
        Simulation sim = new Simulation(moves, positions, worldMap);
        sim.run();

        assertEquals(new Vector2d(1, 3) ,sim.getAnimals().get(0).getPosition());

    }

    @Test
    public void GrassFieldTest2(){
        ArrayList<Vector2d> positions = new ArrayList<Vector2d>();
        positions.add(new Vector2d(0,0));
        positions.add(new Vector2d(1,0));
        positions.add(new Vector2d(1,1));
        GrassField worldMap = new GrassField(20);
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
        GrassField grassField1 = new GrassField(10);
        GrassField grassField2 = new GrassField(10);
        GrassField grassField3 = new GrassField(10);

        grassField1.getId();
        grassField2.getId();
        grassField3.getId();

        assertEquals(0, grassField1.instanceId);
        assertEquals(1, grassField2.instanceId);
        assertEquals(2, grassField3.instanceId);
    }
}
