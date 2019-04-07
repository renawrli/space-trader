package cs2340.garbagecollection.spacetrader.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import cs2340.garbagecollection.spacetrader.model.Planet;
import cs2340.garbagecollection.spacetrader.model.Ship;

import static cs2340.garbagecollection.spacetrader.views.ConfigurationActivity.game;

public class TravelViewModel extends AndroidViewModel {
    public TravelViewModel (@NonNull Application application) {
        super(application);
    }
    /** how many units in the universe you travel per unit of fuel **/
    private static final int DIST_PER_FUEL = 20;

    //this should get moved to the Game class
    public static List<Planet> allPlanets() {
        List<Planet> planetList = new ArrayList<>();
        for (int i = 0; i < game.getUniverse().getNumSolarSystems(); i++) {
            List<Planet> solarSystemPlanets =  game.getUniverse().getAllSolarSystems().get(i).getAllPlanets();
            for (int j = 0; j < solarSystemPlanets.size(); j++) {
                planetList.add(solarSystemPlanets.get(j));
            }
        }
        return planetList;
    }


    /**
     * Returns a list of Planets that you have enough fuel to travel to
     * @return list of Planets that are within range
     */
    public static List<Planet> planetsInRange() {
        Planet currPlanet = game.getCurrLocation();
        List<Planet> planetList = allPlanets();
        Ship currShip = game.getPlayer().getShip();
        //adds all planets in game to planetList

        // max distance the ship can travel on current fuel tank
        int travelableDist = currShip.getFuel() * DIST_PER_FUEL;
        // list of distances to each planet
        List<Integer> distances;
        List<Planet> validPlanets = new ArrayList<>();

        distances = listDistances(allPlanets());

        for (int i = 0; i < distances.size(); i++) {
            if (travelableDist >= distances.get(i)) {
                validPlanets.add(planetList.get(i));
            }
        }
        return validPlanets;
    }

    /** Returns a list of distances from currPlanet to each planet in planetList **/
    //Fuad's version
//    public static List<Integer> listDistances() {
//        Planet currPlanet = game.getCurrLocation();
//        List<Planet> planetList = allPlanets();
//        List<Integer> distances = new ArrayList<>();
//        for (Planet planet: planetList) {
//            distances.add(currPlanet.calcDistance(planet));
//        }
//        return distances;
//    }
    //Andrew's version
    public static List<Integer> listDistances(List<Planet> validPlanets) {
        Planet currPlanet = game.getCurrLocation();
        List<Integer> distances = new ArrayList<>();
        for (Planet planet: validPlanets) {
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

        int dist = game.getCurrLocation().calcDistance(destination);
        int fuelConsumed = dist / DIST_PER_FUEL;
        ship.deductFuel(fuelConsumed);
        game.setCurrLocation(destination);
    }


}
