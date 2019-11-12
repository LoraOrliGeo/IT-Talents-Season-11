package test_two_exercise.sweetshop.cakes;

public class StandardCake extends Cake {
    boolean isSyrupy;

    public StandardCake(String name, String description, double price, int pieces, String type, boolean isSyrupy) {
        super(name, description, price, pieces, type);
        this.isSyrupy = isSyrupy;
    }

    @Override
    public CakeStyle getCakeStyle() {
        return CakeStyle.STANDARD;
    }

    @Override
    public int compareTo(Cake o) {
        return Double.compare(o.getPrice(), this.getPrice());
    }
}
