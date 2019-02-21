package cs2340.garbagecollection.spacetrader.model;

import java.util.HashSet;

/**
 * Generates the universe
 */
public class Universe {
    private SolarSystem africa = new SolarSystem();
    private SolarSystem carribean = new SolarSystem();
    private SolarSystem centralAmerica = new SolarSystem();
    private SolarSystem westEurope = new SolarSystem();
    private SolarSystem eastEurope = new SolarSystem();
    private SolarSystem northAmerica = new SolarSystem();
    private SolarSystem southAmerica = new SolarSystem();
    private SolarSystem centralAsia = new SolarSystem();
    private SolarSystem northAsia = new SolarSystem();
    private SolarSystem southEastAsia = new SolarSystem();
    private SolarSystem middleEast = new SolarSystem();

    /** Getters of the Solar Systems */
    public SolarSystem getAfrica() {
        return africa;
    }

    public SolarSystem getCarribean() {
        return carribean;
    }

    public SolarSystem getCentralAmerica() {
        return centralAmerica;
    }

    public SolarSystem getWestEurope() {
        return westEurope;
    }

    public SolarSystem getEastEurope() {
        return eastEurope;
    }

    public SolarSystem getNorthAmerica() {
        return northAmerica;
    }

    public SolarSystem getSouthAmerica() {
        return southAmerica;
    }

    public SolarSystem getCentralAsia() {
        return centralAsia;
    }

    public SolarSystem getNorthAsia() {
        return northAsia;
    }

    public SolarSystem getSouthEastAsia() {
        return southEastAsia;
    }

    public SolarSystem getMiddleEast() {
        return middleEast;
    }

}
