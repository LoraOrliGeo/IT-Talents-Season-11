package module_three.test_three_exercise.test_three.models.breads;

public class Bread {

    public enum BreadType {
        WHITE(2, 0.9),
        WHOLEGRAIN(5, 1.4);

        private int preparationTime;
        private double price;

        BreadType(int preparationTime, double price) {
            this.preparationTime = preparationTime;
            this.price = price;
        }

        public int getPreparationTime() {
            return preparationTime * 10;
        }

        public double getPrice() {
            return price;
        }
    }

    private BreadType type;

    public Bread(BreadType type) {
        this.type = type;
    }

    public BreadType getType() {
        return type;
    }
}
