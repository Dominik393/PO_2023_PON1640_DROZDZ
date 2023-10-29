package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void Tostring(){
        for(int i = -2; i<= 2; i++){
            String actual_string = new Vector2d(i,i).toString();
            assertEquals(actual_string, "(%d,%d)".formatted(i,i));
        }

    }

    @Test
    public void equals(){
        Vector2d vec = new Vector2d(5,10);
        assertTrue(vec.equals(vec));
        assertFalse(vec.equals(new Vector2d(vec.getX()-1, vec.getY()+1)));
    }

    @Test
    public void precedes(){
        Vector2d vec = new Vector2d(0,0);

        assertTrue(vec.precedes(vec));
        assertTrue(vec.precedes(vec.add(new Vector2d(1,0))));
        assertTrue(vec.precedes(vec.add(new Vector2d(0,1))));

        assertFalse(vec.precedes(vec.add(new Vector2d(-1,0))));
        assertFalse(vec.precedes(vec.add(new Vector2d(0,-1))));
        assertFalse(vec.precedes(vec.add(new Vector2d(-1,-1))));
    }

    @Test
    public void follows(){
        Vector2d vec = new Vector2d(0,0);
        assertTrue(vec.follows(vec));
        assertTrue(vec.follows(vec.add(new Vector2d(-1,0))));
        assertTrue(vec.follows(vec.add(new Vector2d(0,-1))));

        assertFalse(vec.follows(vec.add(new Vector2d(1,0))));
        assertFalse(vec.follows(vec.add(new Vector2d(0,1))));
        assertFalse(vec.follows(vec.add(new Vector2d(1,1))));
    }

    @Test
    public void upperRight(){
        Vector2d vec = new Vector2d(0,0);

        assertEquals(vec, vec.upperRight(vec));
        assertEquals(vec.add(new Vector2d(0,1)), vec.upperRight(vec.add(new Vector2d(0,1))));
        assertEquals(vec.add(new Vector2d(1,0)), vec.upperRight(vec.add(new Vector2d(1,0))));
        assertEquals(vec.add(new Vector2d(1,1)), vec.upperRight(vec.add(new Vector2d(1,1))));
    }

    @Test
    public void lowerLeft(){
        Vector2d vec = new Vector2d(0,0);

        assertEquals(vec, vec.lowerLeft(vec));
        assertEquals(vec.add(new Vector2d(0,-1)), vec.lowerLeft(vec.add(new Vector2d(0,-1))));
        assertEquals(vec.add(new Vector2d(-1,0)), vec.lowerLeft(vec.add(new Vector2d(-1,0))));
        assertEquals(vec.add(new Vector2d(-1,-1)), vec.lowerLeft(vec.add(new Vector2d(-1,-1))));
    }

    @Test
    public void add(){
        Vector2d vec = new Vector2d(0,0);

        assertEquals(vec, vec.add(new Vector2d(0,0)));
        assertEquals(new Vector2d(1,0), vec.add(new Vector2d(1,0)));
        assertEquals(new Vector2d(0,1), vec.add(new Vector2d(0,1)));
        assertEquals(new Vector2d(-1,0), vec.add(new Vector2d(-1,0)));
        assertEquals(new Vector2d(0,-1), vec.add(new Vector2d(0,-1)));
    }

    @Test
    public void subtract(){
        Vector2d vec = new Vector2d(0,0);

        assertEquals(vec, vec.subtract(new Vector2d(0,0)));
        assertEquals(new Vector2d(-1,0), vec.subtract(new Vector2d(1,0)));
        assertEquals(new Vector2d(0,-1), vec.subtract(new Vector2d(0,1)));
        assertEquals(new Vector2d(1,0), vec.subtract(new Vector2d(-1,0)));
        assertEquals(new Vector2d(0,1), vec.subtract(new Vector2d(0,-1)));
    }

    @Test
    public void opposite(){
        assertEquals(new Vector2d(-1,-2), new Vector2d(1,2).opposite());
        assertEquals(new Vector2d(1,2), new Vector2d(-1,-2).opposite());
        assertEquals(new Vector2d(0,0), new Vector2d(0,0).opposite());
    }
}
