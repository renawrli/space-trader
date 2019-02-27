package cs2340.garbagecollection.spacetrader.model;

/**
 * Enum for tech level
 */
public enum TradeGood {
    /** Each resource holds its name, MTLP, MTLU, TTP, Base Price,
        IPL,Var, IE, CR, ER, MTL, MTH respectively */

    WATER(0, 0, 2, 30, 3, 4, IE.DROUGHT, Resources.LOTSOFWATER, Resources.DESERT, 30, 50),
    FURS(0, 0, 0, 250, 10, 10, IE.COLD, Resources.RICHFAUNA, Resources.LIFELESS,	230, 280),
    FOOD(1,0, 1, 100, 5, 5, IE.CROPFAIL,	Resources.RICHSOIL,	Resources.POORSOIL, 90, 16),
    ORE(2, 2, 3, 350, 20, 10, IE.WAR, Resources.MINERALRICH, Resources.MINERALPOOR,350, 420),
    GAMES(3, 1, 6, 250, -10, 5, IE.BOREDOM, Resources.ARTISTIC, null, 160, 270),
    FIREARMS(3, 1, 5, 125, -75, 100, IE.WAR, Resources.WARLIKE, null, 600, 1100),
    MEDICINE(4, 1, 6, 650, -20, 10, IE.PLAGUE, Resources.LOTSOFHERBS, null, 400, 700),
    MACHINES(4, 3, 5, 900, -30, 5, IE.LACKOFWORKERS,	null, null,600, 800),
    NARCOTICS(5, 0, 5, 3500, -125, 150, IE.BOREDOM, Resources.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS( 6, 4, 7, 5000, -150, 100, IE.LACKOFWORKERS, null, null, 3500, 5000);


    private int MTLP;
    private int MTLU;
    private int TTP;
    private int basePrice;
    private int IPL;
    private int var;
    private IE badEvent;
    private Resources CR;
    private Resources ER;
    private int MTL;
    private int MTH;


    TradeGood(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var,
              IE badEvent, Resources CR, Resources ER, int MTL, int MTH) {
        this.MTLP = MTLP;
        this.MTLU = MTLU;
        this.TTP = TTP;
        this.basePrice = basePrice;
        this.IPL = IPL;
        this.var = var;
        this.badEvent = badEvent;
        this.CR = CR;
        this.ER = ER;
        this.MTL = MTL;
        this.MTH = MTH;
    }

    /** getters **/
    public int getMTLP() {
        return MTLP;
    }

    public int getMTLU() {
        return MTLU;
    }

    public int getTTP() {
        return TTP;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getIPL() {
        return IPL;
    }

    public int getVar() {
        return var;
    }

    public IE getBadEvent() {
        return badEvent;
    }

    public Resources getCR() {
        return CR;
    }

    public Resources getER() {
        return ER;
    }

    public int getMTL() {
        return MTL;
    }

    public int getMTH() {
        return MTH;
    }
}
