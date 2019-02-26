package cs2340.garbagecollection.spacetrader.model;

public class Market {
    /** location of market, x coordinate */
    private final int x;

    /** location of market, y coordinate */
    private final int y;

    public Market(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
