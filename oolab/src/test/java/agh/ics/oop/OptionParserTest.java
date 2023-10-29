package agh.ics.oop;

import agh.ics.oop.OptionParser;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OptionParserTest {

    @Test
    public void move_parser(){
        MoveDirection[] actual = OptionParser.move_parser(new String[]{"f", "forward", "b", "backward", "l", "left",
        "r", "right"});
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD,
        MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT};
        assertArrayEquals(actual, expected);
    }
}
