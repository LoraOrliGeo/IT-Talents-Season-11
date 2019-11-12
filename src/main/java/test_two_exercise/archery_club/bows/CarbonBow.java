package test_two_exercise.archery_club.bows;

public class CarbonBow extends Bow implements ISeniorBow {
    private static final int SIGHT_BONUS = 2;
    private static final int STABILIZATION_BONUS = 1;

    public CarbonBow(String manufacturer, double weight, int tensileForce) {
        super(manufacturer, weight, tensileForce);
    }

    @Override
    public int getBonus() {
        return SIGHT_BONUS + STABILIZATION_BONUS;
    }

    @Override
    protected int getMinTensileForce() {
        return 28;
    }

    @Override
    protected int getMaxTensileForce() {
        return 48;
    }

    @Override
    protected int getAvgTensileForce() {
        return 38;
    }

    @Override
    public String getBowType() {
        return "Carbon";
    }
}
