package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class OptionParser {
    public static ArrayList<MoveDirection> move_parser(String[] args) {
        ArrayList<MoveDirection> moveList;
        moveList = new ArrayList<MoveDirection>();

        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "forward":
                case "f":
                    moveList.add(MoveDirection.FORWARD);
                    break;
                case "backward":
                case "b":
                    moveList.add(MoveDirection.BACKWARD);
                    break;
                case "right":
                case "r":
                    moveList.add(MoveDirection.RIGHT);
                    break;
                case "left":
                case "l":
                    moveList.add(MoveDirection.LEFT);
                    break;
                default: {
                    throw new IllegalArgumentException(args[i] + " is not valid move specification");
                }
            }
        }

        return moveList;
    }
}
