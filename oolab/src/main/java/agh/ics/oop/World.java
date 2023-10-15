package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class World {
    static void run(MoveDirection[] args){
        for(int i=0; i < args.length; i++) {
            switch (args[i]) {
                case LEFT -> System.out.print("zwierzak skręca w lewo");
                case RIGHT -> System.out.print("zwierzak skręca w prawo");
                case BACKWARD -> System.out.print("zwierzak idzie do tyłu");
                case FORWARD -> System.out.print("zwierzak idzie do przodu");
            }
            if (i < args.length-1) {
                System.out.println(',');
            }else {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(OptionParser.move_parser(args));
        System.out.println("system zakończył działanie");
    }
}
