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
    private static final int DIST_PER_FUEL = 8;

    /**
     * Returns a list of Planets that you have enough fuel to travel to
     * @return list of Planets that are within range
     */
    public static List<Planet> planetsInRange() {
        Planet currPlanet = Game.getCurrLocation();
        List<Planet> planetList = new ArrayList<>();
        Ship currShip = Game.getPlayer().getShip();
        //adds all planets in game to planetList
        for (int i = 0; i < Game.getUniverse().getNumSolarSystems(); i++) {
            List<Planet> solarSystemPlanets =  Game.getUniverse().getAllSolarSystems().get(i).getAllPlanets();
            for (int j = 0; j < solarSystemPlanets.size(); j++) {
                planetList.add(solarSystemPlanets.get(j));
            }
        }
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
    public static List<Integer> listDistances(Planet currPlanet, List<Planet> planetList) {
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
    public static List<Integer> listFuel(List<Integer> distances) {
        List<Integer> fuelList = new ArrayList<>();
        for(Integer i: distances) {
            fuelList.add(i / DIST_PER_FUEL);
        }
        return fuelList;
    }

    /** takes in a list of valid planets and returns them in string format **/
    public static List<String> validPlanetsString(List<Planet> validPlanets) {
        ArrayList<String> planetNames = new ArrayList<>();
        for (int i = 0; i < validPlanets.size(); i++) {
            planetNames.add(validPlanets.get(i).getName());
        }
        return planetNames;
    }

    /** travels to a Planet. Assumes it's within range **/
    public static void travel(Planet destination, Ship ship) {
        int dist = Game.getCurrLocation().calcDistance(destination);
        int fuelConsumed = dist / DIST_PER_FUEL;
        ship.deductFuel(fuelConsumed);

        Game.setCurrLocation(destination);
    }
}
