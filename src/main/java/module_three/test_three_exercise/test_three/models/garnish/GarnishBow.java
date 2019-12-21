package module_three.test_three_exercise.test_three.models.garnish;

public class GarnishBow {
    private static final int MAX_CAPACITY_OF_GARNISH = 5000; // grams
    private Garnish.GarnishType garnishType;
    private int garnishQuantity = 0;

    public GarnishBow(Garnish.GarnishType garnishType) {
        this.garnishType = garnishType;
    }

    public Garnish.GarnishType getGarnishType() {
        return garnishType;
    }

    public void addGarnish() throws NotEnoughSpaceException {
        if (this.garnishQuantity + 500 <= MAX_CAPACITY_OF_GARNISH) {
            this.garnishQuantity += 500;
        } else {
            throw new NotEnoughSpaceException();
        }
    }

    public void takeGarnish() throws NotEnoughGarnishQuantity {
        if (this.garnishQuantity - 200 >= 0) {
            this.garnishQuantity -= 200;
        } else {
            throw new NotEnoughGarnishQuantity();
        }
    }

}
