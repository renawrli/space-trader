package cs2340.garbagecollection.spacetrader.model;

public class Player {
    /** player name **/
    private String name;

    /** points for pilot **/
    private int pilotPoints;

    /** points for fighter **/
    private int fighterPoints;

    /** points for trader **/
    private int traderPoints;

    /** points for engineer **/
    private int engineerPoints;

    /** amount of money the Player has **/
    private int credits;

    /** the Player's Ship **/
    private Ship ship;

    /**
     * Create a Player with 1000 base credits and a Gnat spaceship, along with assigned skill points
     *
     * @param name - Player's name
     * @param pilotPoints - points allocated to the Pilot skill
     * @param fighterPoints - points allocated to the Fighter skill
     * @param traderPoints - points allocated to the trader skill
     * @param engineerPoints - points allocated to the engineer skill
     */
    public Player (String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.credits = 1000;
        this.ship = new Ship(ShipType.GNAT);
    }

    /** Getters and Setters **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    @Override
    public String toString() {
        return String.format("Player[name:%s, pilotPoints:%d, fighterPoints:%d, traderPoints:%d, engineerPoints:%d]", name, pilotPoints, fighterPoints, traderPoints, engineerPoints);
    }
}
