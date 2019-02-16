package cs2340.garbagecollection.spacetrader.model;

public class Planet {
    /** planet's name */
    private String name;

    /** planet's location */
    private Coordinates location;

    /** planet's tech level */
    private TechLevel technology;

    /** planet's government type */
    private GovernmentType government;

    /** planet's resources */
    private Resources resources;

    /** planet's police level */
    private int policeLevel;

    /** planet's piracy level */
    private int piracyLevel;

    public Planet(String name, Coordinates location, TechLevel technology,
                  GovernmentType government, Resources resources, int policeLevel, int piracyLevel) {
        this.name = name;
        this.location = location;
        this.technology = technology;
        this.government = government;
        this.resources = resources;
        this.policeLevel = policeLevel;
        this.piracyLevel = piracyLevel;
    }

    /** Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    public TechLevel getTechnology() {
        return technology;
    }

    public void setTechnology(TechLevel technology) {
        this.technology = technology;
    }

    public GovernmentType getGovernment() {
        return government;
    }

    public void setGovernment(GovernmentType government) {
        this.government = government;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public int getPoliceLevel() {
        return policeLevel;
    }

    public void setPoliceLevel(int policeLevel) {
        this.policeLevel = policeLevel;
    }

    public int getPiracyLevel() {
        return piracyLevel;
    }

    public void setPiracyLevel(int piracyLevel) {
        this.piracyLevel = piracyLevel;
    }
}
