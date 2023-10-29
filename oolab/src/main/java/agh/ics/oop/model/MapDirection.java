package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static final MapDirection[] vals = values();

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
        return vals[(this.ordinal() + 1)%vals.length];
    }

    public MapDirection previous(){
        return vals[(this.ordinal() == 0) ? vals.length - 1 : this.ordinal() - 1];
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


