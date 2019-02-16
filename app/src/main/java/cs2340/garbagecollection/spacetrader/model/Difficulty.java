package cs2340.garbagecollection.spacetrader.model;

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
