package module_three.test_three_exercise.test_three.models.meats;

public class Meat {

    public enum MeatType {
        MEATBALL(2, 1),
        PLESKAVICA(3, 2),
        STEAK(4, 3);

        private int preparationTime; // minutes
        private int price;

        MeatType(int preparationTime, int price) {
            this.preparationTime = preparationTime;
            this.price = price;
        }

        public int getPreparationTime() {
            return preparationTime * 10;
        }

        public int getPrice() {
            return price;
        }
    }

    private MeatType meatType;

    public Meat(MeatType meatType) {
        this.meatType = meatType;
    }

    public MeatType getMeatType() {
        return this.meatType;
    }
}
