package agh.ics.oop.model;

import agh.ics.oop.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    private final Vector2d lowerleft = new Vector2d(0,0);
    private final Vector2d upperright;

    public RectangularMap(int w, int h){
        this.width = w;
        this.height = h;
        this.upperright = new Vector2d(w,h);

        visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(isOccupied(position)) && position.follows(lowerleft) && position.precedes(upperright);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.animals.containsKey(position);
    }

    @Override
    public Boundry getCurrentBounds(){
        return new Boundry(lowerleft, upperright);
    }
}
