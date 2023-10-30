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
        return (position.equals(pos));
    }

    private void inBounds(int minX, int minY, int maxX, int maxY){
        if (this.position.getX() > maxX) {
            this.position = new Vector2d(maxX, this.position.getY());
        }
        if (this.position.getY() > maxY) {
            this.position = new Vector2d(this.position.getX(), maxY);
        }
        if (this.position.getX() < minX){
            this.position = new Vector2d(minX, this.position.getY());
        }
        if (this.position.getY() < minY){
            this.position = new Vector2d(this.position.getX(), minY);
        }
    }

    public void move(MoveDirection direction){
        switch (direction){
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                this.position = this.position.add(this.orientation.toUnitVector());

                inBounds(0,0,4,4);
            }
            case BACKWARD -> {
                this.position = this.position.subtract(this.orientation.toUnitVector());

                inBounds(0,0,4,4);
            }
        }
    }
}
