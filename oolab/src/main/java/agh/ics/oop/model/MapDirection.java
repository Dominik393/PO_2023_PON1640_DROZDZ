package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this){
            case NORTH -> {
                return "Północ";
            }
            case EAST -> {
                return "Wschód";
            }
            case WEST -> {
                return "Zachód";
            }
            case SOUTH -> {
                return "Południe";
            }
            default -> {
                return "Jak udało ci się to zrobić????";
            }
        }
    }

    public MapDirection next(){
        switch (this){
            case SOUTH -> {
                return WEST;
            }
            case WEST -> {
                return NORTH;
            }
            case NORTH -> {
                return EAST;
            }
            case EAST -> {
                return SOUTH;
            }
            default -> {
                return null;
            }
        }
    }

    public MapDirection previous(){
        switch (this){
            case SOUTH -> {
                return EAST;
            }
            case WEST -> {
                return SOUTH;
            }
            case NORTH -> {
                return WEST;
            }
            case EAST -> {
                return NORTH;
            }
            default -> {
                return null;
            }
        }
    }

    public Vector2d toUnitVector(){
        switch (this){
            case EAST -> {
                return new Vector2d(1,0);
            }
            case NORTH -> {
                return new Vector2d(0,1);
            }
            case WEST -> {
                return new Vector2d(-1, 0);
            }
            case SOUTH -> {
                return new Vector2d(0, -1);
            }
            default -> {
                return null;
            }
        }
    }
}


