package cs2340.garbagecollection.spacetrader.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Difficulty difficulty;
    private Player player;

    /** Randomizer to pick coordinates x, y and piracy and police level */
    private Random rand = new Random();

    /**
     * Constructs the single Game object
     * @param difficulty - difficulty of the game
     * @param player - Player that plays the game
     */
    public Game(Difficulty difficulty, Player player) {
        this.difficulty = difficulty;
        this.player = player;

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
