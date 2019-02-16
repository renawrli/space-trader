package cs2340.garbagecollection.spacetrader.model;

public class Player {
    /**
     * enum for the difficulty levels in Player
     * getDifficulty returns the String representation for each enum
     */
    public enum Difficulty {
        EASY("Easy"), INTERMEDIATE("Intermediate"), EXPERT("Expert");
        private String difficulty;

        Difficulty(String difficulty) {
            this.difficulty = difficulty;
        }

        public String getDifficulty() {
            return difficulty;
        }
    }
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

    private Difficulty difficulty;
    /**
     * Create a Player with allocated skill points
     *
     * @param pilotPoints - points allocated to the Pilot skill
     * @param fighterPoints - points allocated to the Fighter skill
     * @param traderPoints - points allocated to the trader skill
     * @param engineerPoints - points allocated to the engineer skill
     * @param difficulty - Difficulty enum level for this player
     */
    public Player (String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints, Difficulty difficulty) {
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.difficulty = difficulty;
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

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public Difficulty getDifficulty() { return difficulty; }

    @Override
    public String toString() {
        return String.format("[Player name:%s, pilotPoints:%d, fighterPoints:%d, traderPoints:%d, engineerPoints:%d]", name, pilotPoints, fighterPoints, traderPoints, engineerPoints);
    }
}
