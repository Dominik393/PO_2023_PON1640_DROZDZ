package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MapDirectionTest {

    @Test
    public void next(){
        MapDirection[] directions = MapDirection.values();
        MapDirection current = directions[directions.length - 1];
        MapDirection[] new_directions = new MapDirection[4];

        for(int i = 0; i < directions.length; i++){
            new_directions[i] = current;
            current = current.next();
        }
        assertArrayEquals(directions, new_directions);

    }

    @Test
    public void previous(){
        MapDirection[] directions = MapDirection.values();
        MapDirection current = directions[directions.length - 1];
        MapDirection[] new_directions = new MapDirection[4];

        for(int i = 0; i < directions.length; i++){
            new_directions[directions.length - 1 - i] = current;
            current = current.previous();
        }
        assertArrayEquals(directions, new_directions);
    }
}
