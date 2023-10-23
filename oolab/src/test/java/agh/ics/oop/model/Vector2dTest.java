package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void Tostring(){
        for(int i = -2; i<= 2; i++){
            System.out.println(new Vector2d(i,i) + "  " + new Vector2d(i - 10, i + 10));
        }
    }

    @Test
    public void equals(Vector2d other){
        System.out.println("Powinna być prawda:  " + other.equals(other));
        System.out.printf("Powinnien wyjść fałsz: %s%n", other.equals(new Vector2d(other.getX(), other.getY() + 1)) && (other.equals(new Vector2d(other.getX() + 1, other.getY()))));
    }

    @Test
    public void precedes(Vector2d other){
        System.out.println("Powinna być prawda:  " + other.precedes(other));
        System.out.println("Powinna być prawda:  " + other.precedes(other.add(new Vector2d(1,0))));
        System.out.println("Powinna być prawda:  " + other.precedes(other.add(new Vector2d(0,1))));

        System.out.println("Powinnien wyjść fałsz:  " + other.precedes(other.add(new Vector2d(-1,0))));
        System.out.println("Powinnien wyjść fałsz:  " + other.precedes(other.add(new Vector2d(0,-1))));
        System.out.println("Powinnien wyjść fałsz:  " + other.precedes(other.add(new Vector2d(-1,-1))));
    }

    @Test
    public void follows(Vector2d other){
        System.out.println("Powinna być prawda:  " + other.follows(other));
        System.out.println("Powinna być prawda:  " + other.follows(other.add(new Vector2d(-1,0))));
        System.out.println("Powinna być prawda:  " + other.follows(other.add(new Vector2d(0,-1))));

        System.out.println("Powinnien wyjść fałsz:  " + other.follows(other.add(new Vector2d(1,0))));
        System.out.println("Powinnien wyjść fałsz:  " + other.follows(other.add(new Vector2d(0,1))));
        System.out.println("Powinnien wyjść fałsz:  " + other.follows(other.add(new Vector2d(1,1))));
    }

    @Test
    public void upperRight(Vector2d other){
        System.out.println("dokladnie other: " + other.upperRight(other));
        System.out.println("Tylko X z other: " + other.upperRight(other.add(new Vector2d(0,1))));
        System.out.println("Tylko Y z other: " + other.upperRight(other.add(new Vector2d(0,1))));
        System.out.println("Nic z other: " + other.upperRight(other.add(new Vector2d(1,1))));
    }

    @Test
    public void lowerLeft(Vector2d other){
        System.out.println("dokladnie other: " + other.upperRight(other));
        System.out.println("Tylko X z other: " + other.upperRight(other.add(new Vector2d(0,1))));
        System.out.println("Tylko Y z other: " + other.upperRight(other.add(new Vector2d(0,1))));
        System.out.println("Nic z other: " + other.upperRight(other.add(new Vector2d(1,1))));
    }

    @Test
    public void add(Vector2d other){
        System.out.println("Takie samo: " + other.add(new Vector2d(0,0)));
        System.out.println("Takie większe X: " + other.add(new Vector2d(1,0)));
        System.out.println("Takie mniejsze X: " + other.add(new Vector2d(-1,0)));
        System.out.println("Takie większe Y: " + other.add(new Vector2d(0,1)));
        System.out.println("Takie mniejsze Y: " + other.add(new Vector2d(0,-1)));
    }

    @Test
    public void subtract(Vector2d other){
        System.out.println("Takie samo: " + other.subtract(new Vector2d(0,0)));
        System.out.println("Takie mniejsze X: " + other.subtract(new Vector2d(1,0)));
        System.out.println("Takie większe X: " + other.subtract(new Vector2d(-1,0)));
        System.out.println("Takie mniejsze Y: " + other.subtract(new Vector2d(0,1)));
        System.out.println("Takie większe Y: " + other.subtract(new Vector2d(0,-1)));
    }

    @Test
    public void opposite(){
        Vector2d[] vectors = {new Vector2d(-1,-2),new Vector2d(0,0), new Vector2d(1,2)};

        for(Vector2d vector: vectors){
            System.out.println("Powinno być (%s,%s), a jest: ".formatted(vector.getX(),vector.getY()) + vector);
        }
    }
}
