package cs2340.garbagecollection.spacetrader.model;
import java.util.ArrayList;
import java.util.List;
/**
 * Generates the universe
 */
public class Universe {
    private int numSolarSystems;
    private List<SolarSystem> listOfSolarSystems;

    public Universe() {
        listOfSolarSystems = new ArrayList<>();
    }

    public Universe(List<SolarSystem> initList) {
        listOfSolarSystems = initList;
        numSolarSystems = listOfSolarSystems.size();
    }

    public List<SolarSystem> getAllSolarSystems() {
        return listOfSolarSystems;
    }

    public void addSolarSystem(SolarSystem s) {
        listOfSolarSystems.add(s);
        numSolarSystems++;
    }

    public int getNumSolarSystems() {
        return numSolarSystems;
    }
}
