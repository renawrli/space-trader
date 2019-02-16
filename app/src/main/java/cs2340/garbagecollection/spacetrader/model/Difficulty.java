package cs2340.garbagecollection.spacetrader.model;

/**
 * enum for the difficulty levels in Player
 * getDifficulty returns the String representation for each enum
 */
public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");
    private String difficulty;

    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
