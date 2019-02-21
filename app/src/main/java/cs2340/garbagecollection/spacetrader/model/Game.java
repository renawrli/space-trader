package cs2340.garbagecollection.spacetrader.model;

public class Game {
    private Difficulty difficulty;
    private Player player;
    private Universe universe;

    /**
     * Constructs the single Game object
     * @param difficulty - difficulty of the game
     * @param player - Player that plays the game
     */
    public Game(Difficulty difficulty, Player player, Universe universe) {
        this.difficulty = difficulty;
        this.player = player;
        this.universe = universe;
    }
}
