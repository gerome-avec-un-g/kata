package fr.geromeavecung.kata;

public record Coordinates(int x, int y) {

    @Override
    public String toString() {
        return x + " " + y;
    }

    public Coordinates north() {
        return new Coordinates(x, y + 1);
    }

    public Coordinates east() {
        return new Coordinates(x + 1, y);
    }

    public Coordinates south() {
        return new Coordinates(x, y - 1);
    }

    public Coordinates west() {
        return new Coordinates(x - 1, y);
    }

}
