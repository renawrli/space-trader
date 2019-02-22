package cs2340.garbagecollection.spacetrader.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Difficulty difficulty;
    private Player player;
    private Universe universe;

    /**
     * Constructs the single Game object
     * @param difficulty - difficulty of the game
     * @param player - Player that plays the game
     */
    public Game(Difficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;

        List<Planet> africanNations = new ArrayList<>();
        africanNations.add(new Planet("Nigeria"));
        List<Planet> carribeanNations = new ArrayList<>();
        carribeanNations.add(new Planet("The Bahamas"));
        List<Planet> caNations = new ArrayList<>();
        caNations.add(new Planet("Nicaragua"));
        List<Planet> weNations = new ArrayList<>();
        weNations.add(new Planet("France"));
        List<Planet> eeNations = new ArrayList<>();
        eeNations.add(new Planet("Hungary"));
        List<Planet> naNations = new ArrayList<>();
        naNations.add(new Planet("United States"));
        List<Planet> saNations = new ArrayList<>();
        saNations.add(new Planet("Argentina"));
        List<Planet> cAsiaNations = new ArrayList<>();
        cAsiaNations.add(new Planet("Kazakhstan"));
        List<Planet> seAsiaNations = new ArrayList<>();
        seAsiaNations.add(new Planet("Indonesia"));
        List<Planet> meNations = new ArrayList<>();
        meNations.add(new Planet("Lebanon"));

        SolarSystem africa = new SolarSystem();
        SolarSystem caribbean = new SolarSystem();
        SolarSystem centralAmerica = new SolarSystem();
        SolarSystem westEurope = new SolarSystem();
        SolarSystem eastEurope = new SolarSystem();
        SolarSystem northAmerica = new SolarSystem();
        SolarSystem southAmerica = new SolarSystem();
        SolarSystem centralAsia = new SolarSystem();
        SolarSystem southEastAsia = new SolarSystem();
        SolarSystem middleEast = new SolarSystem();
        List<SolarSystem> theUniverse = new ArrayList<>();
        theUniverse.add(africa);
        theUniverse.add(caribbean);
        theUniverse.add(centralAmerica);
        theUniverse.add(westEurope);
        theUniverse.add(eastEurope);
        theUniverse.add(northAmerica);
        theUniverse.add(southAmerica);
        theUniverse.add(centralAsia);
        theUniverse.add(southEastAsia);
        theUniverse.add(middleEast);
    }

}
