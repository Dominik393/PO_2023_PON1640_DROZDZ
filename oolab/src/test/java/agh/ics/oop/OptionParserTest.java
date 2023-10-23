package agh.ics.oop;

import agh.ics.oop.OptionParser;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.World.run;


public class OptionParserTest {

    @Test
    public void move_parser(){
        MoveDirection[] moves = new MoveDirection[9];
        run(OptionParser.move_parser(new String[]{"f", "b", "r", "l", "forward", "backward", "right", "left"}));
        }
}
