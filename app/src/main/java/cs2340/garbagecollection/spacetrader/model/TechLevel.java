package cs2340.garbagecollection.spacetrader.model;
/**
 * enum for the Tech Level
 */
public enum TechLevel {
    PreAgriculture("Pre-Agriculture"),
    Agriculture("Agriculture"),
    Medieval("Medieval"),
    Renaissance("Renaissance"),
    EarlyIndustrial("Early Industrial"),
    Industrial("Industrial"),
    PostIndustrial("Post-Industrial"),
    HiTech("Hi-Tech");


    private String TechLevel;

    TechLevel(String level) {
        this.TechLevel = level;
    }

    public String getTechLevel() {
        return TechLevel;
    }
}
