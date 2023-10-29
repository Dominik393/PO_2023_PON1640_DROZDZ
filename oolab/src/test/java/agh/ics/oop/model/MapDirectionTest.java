package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    public void next(){
        MapDirection[] directions = MapDirection.values();

        for(int i = 0; i < directions.length; i++){
            assertEquals((i),);
        }

    }

    @Test
    public void previous(){
        MapDirection[] directions = MapDirection.values();

        for(MapDirection direction: directions){
            System.out.printf("Poprzednikiem %s jest %s%n", direction, direction.previous());
        }
    }
}
