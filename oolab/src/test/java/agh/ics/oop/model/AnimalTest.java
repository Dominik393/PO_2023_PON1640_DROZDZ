package agh.ics.oop.model;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void move(){
        Animal anim = new Animal(new Vector2d(0,0));
        MoveValidator validator = new RectangularMap(4,4);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        assertEquals(MapDirection.NORTH, anim.getOrientation());
        anim.move(MoveDirection.FORWARD, validator);
        assertEquals(new Vector2d(0,1), anim.getPosition());
        anim.move(MoveDirection.BACKWARD, validator);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        anim.move(MoveDirection.LEFT, validator);
        anim.move(MoveDirection.FORWARD, validator);
        assertEquals(new Vector2d(0,0), anim.getPosition());
        assertEquals(MapDirection.WEST, anim.getOrientation());
        anim.move(MoveDirection.RIGHT, validator);
        anim.move(MoveDirection.RIGHT, validator);
        anim.move(MoveDirection.FORWARD, validator);
        assertEquals(MapDirection.EAST, anim.getOrientation());
        assertEquals(new Vector2d(1,0), anim.getPosition());

    }

}
