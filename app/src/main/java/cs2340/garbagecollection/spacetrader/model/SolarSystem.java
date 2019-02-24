package cs2340.garbagecollection.spacetrader.model;

import java.util.HashSet;
import java.util.List;

public class SolarSystem {

    /** solar system's planets */
    private HashSet<Planet> planets;
    private String name;

    SolarSystem() {
        planets = new HashSet<Planet>(10);
        name = "Default Solar System";
    }

    /** constructs solar system from List of Planet objects **/
    SolarSystem(String name, List<Planet> planetList) {
        planets = new HashSet<Planet>(planetList);
        this.name = name;
    }

    /** adds singular planet to the solar system **/
    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    /** returns number of planets in this solar system **/
    public int getNumberOfPlanets() {
        return planets.size();
    }

    @Override
    public String toString() {
        String s = "Solar System: " + name;
        for (Planet p: planets) {
            s += planets.toString() + " ";
        }
        return s;
    }
}
