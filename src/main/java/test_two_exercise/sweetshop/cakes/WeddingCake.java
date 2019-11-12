package test_two_exercise.sweetshop.cakes;

public class WeddingCake extends Cake {
    private int floors;

    public WeddingCake(String name, String description, double price, int pieces, String type, int floors) {
        super(name, description, price, pieces, type);
        this.floors = floors;
    }

    @Override
    public CakeStyle getCakeStyle() {
        return CakeStyle.WEDDING;
    }

    @Override
    public int compareTo(Cake o) {
        return o.getPieces() - this.getPieces();
    }
}
