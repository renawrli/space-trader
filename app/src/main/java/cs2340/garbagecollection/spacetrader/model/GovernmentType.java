package cs2340.garbagecollection.spacetrader.model;

public enum GovernmentType {
    ANARCHY("Anarchy"),
    CAPITALIST("Capitalist"),
    COMMUNIST("Communist"),
    CONFEDERACY("Confederacy"),
    CORPORATE("Corporate"),
    CYBERNETIC("Cybernetic"),
    DEMOCRACY("Democracy"),
    DICTATORISHIP("Dictatorship"),
    FASCIST("Fascist"),
    FEUDAL("Feudal"),
    MILITARY("Military"),
    MONARCHY("Monarchy"),
    PACIFIST("Pacifist"),
    SOCIALIST("Socialist"),
    STATE_OF_SATORI("State of Satori"),
    TECHNOCRACY("Technocracy"),
    THEOCRACY("Theocracy");

    private String governmentType;
    GovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public String getGovernmentType() {
        return governmentType;
    }
}
