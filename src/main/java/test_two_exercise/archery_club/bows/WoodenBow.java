package test_two_exercise.archery_club.bows;

public class WoodenBow extends Bow {

    public WoodenBow(String manufacturer, double weight, int tensileForce) {
        super(manufacturer, weight, tensileForce);
    }

    @Override
    public int getBonus() {
        return 0;
    }

    @Override
    protected int getMinTensileForce() {
        return 20;
    }

    @Override
    protected int getMaxTensileForce() {
        return 30;
    }

    @Override
    protected int getAvgTensileForce() {
        return 25;
    }

    @Override
    public String getBowType() {
        return "Wooden";
    }
}
