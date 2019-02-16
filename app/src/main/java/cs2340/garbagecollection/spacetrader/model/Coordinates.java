package cs2340.garbagecollection.spacetrader.model;

public class Coordinates {
    private final double x;
    private final double y;

    /**
     * Constructor for Coordinates class that uses doubles to
     set x and y location
     * @param x is double that represents part of coordinate system
     * @param y is double that represents part of coordinate system
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
