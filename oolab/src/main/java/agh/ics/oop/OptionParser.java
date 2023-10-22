package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import javax.lang.model.type.NullType;

public class OptionParser {
    static MoveDirection[] move_parser(String[] args) {
        MoveDirection[] answer;
        answer = new MoveDirection[args.length];

        for(int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "forward":
                case "f":
                    answer[i] = MoveDirection.FORWARD;
                    break;
                case "backward":
                case "b":
                    answer[i] = MoveDirection.BACKWARD;
                    break;
                case "right":
                case "r":
                    answer[i] = MoveDirection.RIGHT;
                    break;
                case "left":
                case "l":
                    answer[i] = MoveDirection.LEFT;
                    break;
                default: {
                    answer[i] = null;
                }
            }
        }

        return answer;
    }
}
