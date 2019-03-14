package cs2340.garbagecollection.spacetrader.model;

public class Planet {
    /** planet's name */
    private String name;

    /** x coordinate of planet **/
    private final int x;

    /** y coordinate of planet **/
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

    /** planet's catastrophic event */
    private IE badEvent;

    /** Checks equality of planet based on name
     * @param o object that is checked for equality
     * @return true if equal, otherwise false
     */
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
        badEvent = null;
    }

    public Planet(String name, GovernmentType government, int x,
                  int y, int policeLevel, int piracyLevel) {
        this(name, x, y, TechLevel.getRandomTech(), government,
                Resources.getRandomResources(),
                policeLevel, piracyLevel);
        badEvent = null;
    }

    /** calculates distance from this planet to another one **/
    public int calcDistance(Planet p) {
        double distance = 0;
        int xDist = Math.abs(x - p.getX());
        int yDist = Math.abs(y - p.getY());
        double xDistSquared = Math.pow(xDist, 2);
        double yDistSquared = Math.pow(yDist, 2);
        distance += Math.pow((xDistSquared + yDistSquared), 0.5);

        return (int) distance;
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

    public void setBadEvent(IE badEvent) {
        this.badEvent = badEvent;
    }
    public IE getBadEvent () {
        return badEvent;
    }

    @Override
    public String toString() {
        return String.format("Planet[name:%s, x-coordinate:%d, y-coordinate:%d, resource:%s, tech level:%s]",
                name, x, y, resources.toString(), technology.toString());
    }
}
