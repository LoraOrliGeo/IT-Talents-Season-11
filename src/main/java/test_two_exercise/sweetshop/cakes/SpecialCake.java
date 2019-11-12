package test_two_exercise.sweetshop.cakes;

public class SpecialCake extends Cake {
    private String eventName;

    public SpecialCake(String name, String description, double price, int pieces, String type, String eventName) {
        super(name, description, price, pieces, type);
        this.eventName = eventName;
    }

    @Override
    public CakeStyle getCakeStyle() {
        return CakeStyle.SPECIAL;
    }

    @Override
    public int compareTo(Cake o) {
        return Double.compare(o.getPrice(), this.getPrice());
    }
}
