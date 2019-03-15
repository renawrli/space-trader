package cs2340.garbagecollection.spacetrader.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static Difficulty difficulty;
    private static Player player;
    private static Universe universe;
    private static Planet currLocation;

    /** Randomizer to pick coordinates x, y and piracy and police level */
    private Random rand = new Random();

    /**
     * Constructs the single Game object
     * @param diff - difficulty of the game
     * @param p - Player that plays the game
     */
    public Game(Difficulty diff, Player p) {
        difficulty = diff;
        player = p;

        List<Planet> africanNations = new ArrayList<>();
        africanNations.add(new Planet("Nigeria", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> carribeanNations = new ArrayList<>();
        carribeanNations.add(new Planet("The Bahamas", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> caNations = new ArrayList<>();
        caNations.add(new Planet("Nicaragua", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> weNations = new ArrayList<>();
        weNations.add(new Planet("France", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> eeNations = new ArrayList<>();
        eeNations.add(new Planet("Hungary", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> naNations = new ArrayList<>();
        naNations.add(new Planet("United States", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> saNations = new ArrayList<>();
        saNations.add(new Planet("Argentina", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> cAsiaNations = new ArrayList<>();
        cAsiaNations.add(new Planet("Kazakhstan", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> seAsiaNations = new ArrayList<>();
        seAsiaNations.add(new Planet("Indonesia", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));
        List<Planet> meNations = new ArrayList<>();
        meNations.add(new Planet("Lebanon", GovernmentType.ANARCHY,
                rand.nextInt(150), rand.nextInt(150),
                rand.nextInt(11), rand.nextInt(11)));

        SolarSystem africa = new SolarSystem("Africa", africanNations);
        SolarSystem caribbean = new SolarSystem("Carribbean", carribeanNations);
        SolarSystem centralAmerica = new SolarSystem("Central America", caNations);
        SolarSystem westEurope = new SolarSystem("West Europe", weNations);
        SolarSystem eastEurope = new SolarSystem("East Europe", eeNations);
        SolarSystem northAmerica = new SolarSystem("North America", naNations);
        SolarSystem southAmerica = new SolarSystem("South America", saNations);
        SolarSystem centralAsia = new SolarSystem("Central Asia", cAsiaNations);
        SolarSystem southEastAsia = new SolarSystem("Southeast Asia", seAsiaNations);
        SolarSystem middleEast = new SolarSystem("Middle East", meNations);

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

        universe = new Universe(theUniverse);
        currLocation = africa.getAllPlanets().get(0);
    }

    /** getters and setters **/
    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Universe getUniverse() {
        return universe;
    }

    public static Planet getCurrLocation() {
        return currLocation;
    }

    public static void setCurrLocation(Planet newLocation) {
        currLocation = newLocation;
    }
}
