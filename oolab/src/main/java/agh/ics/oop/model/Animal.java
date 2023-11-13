package agh.ics.oop.model;


import java.util.Objects;

public class Animal implements WorldElement{
    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        position = new Vector2d(2,2);
        orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d pos){
        position = pos;
        orientation = MapDirection.NORTH;
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

    @Override
    public String toString() {
        String orien;
        switch (this.orientation){
            case NORTH -> orien = "N";
            case WEST -> orien = "W";
            case SOUTH -> orien = "S";
            case EAST -> orien = "E";
            default -> orien = "Wydarzyło się coś niemorzliwego";
        }

        return "%s".formatted(orien);
    }

    public boolean isAt(Vector2d pos){
        return (position.equals(pos));
    }


    public void move(MoveDirection direction, MoveValidator validator){
        MapDirection neworien = this.orientation;
        Vector2d newpos = this.position;

        switch (direction) {
            case LEFT:
                neworien = this.orientation.previous();
                break;
            case RIGHT:
                neworien = this.orientation.next();
                break;
            case FORWARD:
                newpos = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                newpos = this.position.subtract(this.orientation.toUnitVector());
                break;
            default:
                break;
        }

        if (validator.canMoveTo(newpos)) {
            this.position = newpos;
            this.orientation = neworien;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return orientation == animal.orientation && Objects.equals(position, animal.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, position);
    }
}
