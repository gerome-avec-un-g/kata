package fr.geromeavecung.kata;

public class Garden {
    private final int width;
    private final int length;

    public Garden(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public boolean checkCoordinates(Coordinates nextCoordinates) {
        return isXValid(nextCoordinates.x(), width) && isYValid(nextCoordinates.y(), length);
    }

    public boolean isXValid(int nextX, int maxX) {
        return 0 <= nextX && nextX <= maxX;
    }

    public boolean isYValid(int nextY, int maxY) {
        return 0 <= nextY && nextY <= maxY;
    }

    @Override
    public String toString() {
        return width + " " + length;
    }
}
