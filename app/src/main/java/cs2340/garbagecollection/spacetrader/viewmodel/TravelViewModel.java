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
     * @param list - list of all planets
     * @return list of Planets that are within range
     */
    public List<Planet> planetsInRange(Planet currPlanet, List<Planet> list, Ship currShip) {
        // list of distances to each planet
        List<Integer> distances = new ArrayList<>();
        List<Planet> validPlanets = new ArrayList<>();
        // max distance the ship can travel on current fuel tank
        int travelableDist = currShip.getFuel() * DIST_PER_FUEL;

        for (Planet planet: list) {
            distances.add(currPlanet.calcDistance(planet));
        }
        for (int i = 0; i < list.size(); i++) {
            if (travelableDist >= distances.get(i)) {
                validPlanets.add(list.get(i));
            }
        }
        return validPlanets;
    }

    /** travels to a Planet. Assumes it's within range **/
    public void travel(Planet destination, Ship ship) {
        int dist = Game.getCurrLocation().calcDistance(destination);
        int fuelConsumed = dist / DIST_PER_FUEL;
        ship.deductFuel(fuelConsumed);

        Game.setCurrLocation(destination);
    }
}
