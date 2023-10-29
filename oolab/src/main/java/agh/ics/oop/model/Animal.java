package agh.ics.oop.model;


public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        position = new Vector2d(2,2);
        orientation = MapDirection.NORTH;
    }

    public Animal(Vector2d pos, MapDirection orien){
        position = pos;
        orientation = orien;
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

    @Override
    public String toString() {
        return "Obecna pozycja zwierzęcia to: (%d, %d) %nObecna orientacja zwierzęcia to: %s".formatted(position.getX(),
                position.getY(), orientation);
    }

    public boolean isAt(Vector2d pos){
        return (position.getX() == pos.getX() && position.getY() == pos.getY());
    }

    private void advance(int val){
        switch (this.orientation){
            case NORTH -> this.position.add(new Vector2d(1,0));
        }
    }

    public void move(MoveDirection direction){
        final int maxPos = 4;
        final int minPos = 0;

        switch (direction){
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                this.position = this.position.add(this.orientation.toUnitVector());

                if (this.position.getX() > maxPos) {
                    this.position = new Vector2d(maxPos, this.position.getY());
                }
                if (this.position.getY() > maxPos) {
                    this.position = new Vector2d(this.position.getX(), maxPos);
                }
                if (this.position.getX() < minPos){
                    this.position = new Vector2d(minPos, this.position.getY());
                }
                if (this.position.getY() < minPos){
                    this.position = new Vector2d(this.position.getX(), minPos);
                }
            }
            case BACKWARD -> {
                this.position = this.position.subtract(this.orientation.toUnitVector());

                if (this.position.getX() > maxPos) {
                    this.position = new Vector2d(maxPos, this.position.getY());
                }
                if (this.position.getY() > maxPos) {
                    this.position = new Vector2d(this.position.getX(), maxPos);
                }
                if (this.position.getX() < minPos){
                    this.position = new Vector2d(minPos, this.position.getY());
                }
                if (this.position.getY() < minPos){
                    this.position = new Vector2d(this.position.getX(), minPos);
                }
            }
            }
    }
}
