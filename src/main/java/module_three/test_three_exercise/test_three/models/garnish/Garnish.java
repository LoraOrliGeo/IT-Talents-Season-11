package module_three.test_three_exercise.test_three.models.garnish;

public class Garnish {

    public enum GarnishType {
        RUSSIAN(10, 1.5),
        LUTENICA(8, 1.1),
        SNEJANKA(4, 1.2),
        CABBAGE_CARROT(2, 0.8),
        TOMATO_CUCUMBER(3, 1.3);

        private int preparationType;
        private double price;

        GarnishType(int preparationType, double price) {
            this.preparationType = preparationType;
            this.price = price;
        }

        public int getPreparationType() {
            return preparationType * 10;
        }

        public double getPrice() {
            return price;
        }
    }

    private GarnishType garnishType;

    public Garnish(GarnishType garnishType) {
        this.garnishType = garnishType;
    }

    public GarnishType getGarnishType() {
        return garnishType;
    }
}
