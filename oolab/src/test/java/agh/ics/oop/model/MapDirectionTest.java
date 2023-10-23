package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {

    @Test
    public void next(){
        MapDirection[] directions = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};

        for(MapDirection direction: directions){
            System.out.printf("Następcą %s jest %s%n", direction, direction.next());
        }
    }

    @Test
    public void previous(){
        MapDirection[] directions = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};

        for(MapDirection direction: directions){
            System.out.printf("Poprzednikiem %s jest %s%n", direction, direction.previous());
        }
    }
}
