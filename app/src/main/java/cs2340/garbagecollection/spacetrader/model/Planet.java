package cs2340.garbagecollection.spacetrader.model;

public class Planet {
    /** planet's name */
    private String name;

    private final int x;

    private final int y;

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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        else if (!(o instanceof Planet)) return false;
        Planet other = (Planet) o;
        return (other.getGovernment().equals(government) && other.getName().equals(name)
                && other.getTechnology().equals(technology) && other.getResources().equals(resources)
                && other.getPoliceLevel() == (policeLevel) && other.getPiracyLevel() == piracyLevel);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + resources.ordinal() + government.ordinal() + policeLevel + piracyLevel;
    }

    public Planet(String name, int x, int y, TechLevel technology,
                  GovernmentType government, Resources resources, int policeLevel, int piracyLevel) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
