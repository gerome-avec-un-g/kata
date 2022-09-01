package fr.geromeavecung.kata;

public class Mower {
    private Coordinates coordinates;
    private Orientation orientation;

    public Mower(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public void moveForward(Garden garden) {
        Coordinates nextCoordinates = computeNextCoordinates();
        if(garden.checkCoordinates(nextCoordinates)) {
            coordinates = nextCoordinates;
        }
    }

    private Coordinates computeNextCoordinates() {
        return switch (orientation){
            case NORTH -> coordinates.north();
            case EAST -> coordinates.east();
            case SOUTH -> coordinates.south();
            case WEST -> coordinates.west();
        };
    }

    public void rotateLeft() {
        orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        orientation = orientation.rotateRight();
    }

    @Override
    public String toString() {
        return coordinates.toString() + " " + orientation.toString();
    }

}
