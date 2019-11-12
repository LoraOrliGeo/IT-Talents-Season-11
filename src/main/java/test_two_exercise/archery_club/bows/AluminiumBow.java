package test_two_exercise.archery_club.bows;

public class AluminiumBow extends Bow implements ISeniorBow{
    private static final int SIGHT_BONUS = 1;

    public AluminiumBow(String manufacturer, double weight, int tensileForce) {
        super(manufacturer, weight, tensileForce);
    }

    @Override
    public int getBonus() {
        return SIGHT_BONUS;
    }

    @Override
    protected int getMinTensileForce() {
        return 25;
    }

    @Override
    protected int getMaxTensileForce() {
        return 40;
    }

    @Override
    protected int getAvgTensileForce() {
        return 32;
    }

    @Override
    public String getBowType() {
        return "Aluminium";
    }
}
