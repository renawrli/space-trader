package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import cs2340.garbagecollection.spacetrader.model.Game;
import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Ship;
import cs2340.garbagecollection.spacetrader.model.Player;

public class TravelViewModel extends AndroidViewModel {

    public TravelViewModel (@NonNull Application application) {
        super(application);
    }

    /** how many units in the universe you travel per unit of fuel **/
    private final int DIST_PER_FUEL = 8;

    /**
     * Returns a list of Planets that you have enough fuel to travel to
     * @param currPlanet - current planet you are on
     * @param planetList - list of all planets
     * @return list of Planets that are within range
     */
    public List<Planet> planetsInRange(Planet currPlanet, List<Planet> planetList, Ship currShip) {
        // max distance the ship can travel on current fuel tank
        int travelableDist = currShip.getFuel() * DIST_PER_FUEL;
        // list of distances to each planet
        List<Integer> distances;
        List<Planet> validPlanets = new ArrayList<>();

        distances = listDistances(currPlanet, planetList);

        for (int i = 0; i < distances.size(); i++) {
            if (travelableDist >= distances.get(i)) {
                validPlanets.add(planetList.get(i));
            }
        }
        return validPlanets;
    }

    /** Returns a list of distances from currPlanet to each planet in planetList **/
    public List<Integer> listDistances(Planet currPlanet, List<Planet> planetList) {
        List<Integer> distances = new ArrayList<>();
        for (Planet planet: planetList) {
            distances.add(currPlanet.calcDistance(planet));
        }
        return distances;
    }

    /**
     * Returns a list of how much fuel it takes to travel to each planet
     * @param distances - list of distances to each planet
     * @return a list of fuel units it will cost to fly to each destination
     */
    public List<Integer> listFuel(List<Integer> distances) {
        List<Integer> fuelList = new ArrayList<>();
        for(Integer i: distances) {
            fuelList.add(i / DIST_PER_FUEL);
        }
        return fuelList;
    }

    /** takes in a list of valid planets and returns them in string format **/
    public List<String> validPlanetsString(List<Planet> validPlanets) {
        ArrayList<String> planetNames = new ArrayList<>();
        for (int i = 0; i < validPlanets.size(); i++) {
            planetNames.add(validPlanets.get(i).getName());
        }
        return planetNames;
    }

    /** travels to a Planet. Assumes it's within range **/
    public void travel(Planet destination, Ship ship) {
        int dist = Game.getCurrLocation().calcDistance(destination);
        int fuelConsumed = dist / DIST_PER_FUEL;
        ship.deductFuel(fuelConsumed);

        Game.setCurrLocation(destination);
    }
}
