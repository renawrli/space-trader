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


    /**
     * Create a Player with allocated skill points
     *
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
    }

//    /**
//     * Checks if a potential Player's skill points equal the allowed number of points.
//     *
//     * @param pilotPts - amount of allocated pilotPoints
//     * @param fighterPts - amount of allocated fighterPoints
//     * @param traderPts - amount of allocated traderPoints
//     * @param engineerPts - amount of allocated engineerPoints
//     * @return true if the number of allocated points equal the number allowed. false if
//     * not enough or too many points have been allocated.
//     */
//    public boolean equalsAllowedPoints(int pilotPts, int fighterPts, int traderPts, int engineerPts) {
//        return (pilotPts + fighterPts + traderPts + engineerPts) == MAX_POINTS;
//    }

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
}
