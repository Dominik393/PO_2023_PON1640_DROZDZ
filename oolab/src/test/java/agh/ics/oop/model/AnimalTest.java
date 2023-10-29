package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void move(){
        Animal anim = new Animal(new Vector2d(0,0), MapDirection.NORTH);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        assertEquals(MapDirection.NORTH, anim.getOrientation());
        anim.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0,1), anim.getPosition());
        anim.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        anim.move(MoveDirection.LEFT);
        anim.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        assertEquals(MapDirection.WEST, anim.getOrientation());
        anim.move(MoveDirection.RIGHT);
        anim.move(MoveDirection.RIGHT);
        anim.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.EAST, anim.getOrientation());
        assertEquals(new Vector2d(1,0), anim.getPosition());

    }

}
