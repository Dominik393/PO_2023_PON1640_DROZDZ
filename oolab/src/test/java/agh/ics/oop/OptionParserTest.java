package agh.ics.oop;

import agh.ics.oop.OptionParser;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OptionParserTest {

    @Test
    public void move_parser(){
        ArrayList<MoveDirection> actual = OptionParser.move_parser(new String[]{"f", "forward", "b", "backward", "l", "left",
        "r", "right"});
        ArrayList<MoveDirection> expected;
        expected = new ArrayList<MoveDirection>();
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.FORWARD);
        expected.add(MoveDirection.BACKWARD);
        expected.add(MoveDirection.BACKWARD);
        expected.add(MoveDirection.LEFT);
        expected.add(MoveDirection.LEFT);
        expected.add(MoveDirection.RIGHT);
        expected.add(MoveDirection.RIGHT);
        assertArrayEquals(new ArrayList[]{expected}, new ArrayList[]{actual});
    }
}
