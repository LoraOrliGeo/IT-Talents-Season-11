package test_two_exercise.archery_club.bows;

public abstract class Bow implements IBow{
    private String manufacturer;
    private double weight;
    private int tensileForce;

    public Bow(String manufacturer, double weight, int tensileForce) {
        setManufacturer(manufacturer);
        setWeight(weight);
        setTensileForce(tensileForce);
    }

    private void setManufacturer(String manufacturer) {
        if (manufacturer != null && !manufacturer.isEmpty()) {
            this.manufacturer = manufacturer;
        }
    }

    private void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    private void setTensileForce(int tensileForce) {
        if (getMinTensileForce() <= tensileForce && tensileForce <= getMaxTensileForce()) {
            this.tensileForce = tensileForce;
        } else {
            this.tensileForce = getAvgTensileForce();
        }
    }

    public abstract int getBonus();

    protected abstract int getMinTensileForce();

    protected abstract int getMaxTensileForce();

    protected abstract int getAvgTensileForce();

    public abstract String getBowType();
}
