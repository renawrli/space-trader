package cs2340.garbagecollection.spacetrader.model;

import java.util.HashSet;

public class SolarSystem {

    /** solar system's planets */
    private HashSet<Planet>[] planets;

    SolarSystem() {
        planets = new HashSet[10];
    }
}
