package cs2340.garbagecollection.spacetrader.model;

import java.util.HashSet;
import java.util.List;

public class SolarSystem {

    /** solar system's planets */
    private HashSet<Planet> planets;

    SolarSystem() {
        planets = new HashSet<Planet>(10);
    }

    /** constructs solar system from List of Planet objects **/
    SolarSystem(List<Planet> planetList) {
        planets = new HashSet<Planet>(planetList);
    }

    /** adds singular planet to the solar system **/
    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    /** returns number of planets in this solar system **/
    public int getNumberOfPlanets() {
        return planets.size();
    }
}
