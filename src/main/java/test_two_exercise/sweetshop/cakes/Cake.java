package test_two_exercise.sweetshop.cakes;

import java.util.List;
import java.util.Objects;

public abstract class Cake implements Comparable<Cake>{
    private String name;
    private String description;
    private double price;
    private int pieces;
    private CakeStyle style;
    private String type;

    public Cake(String name, String description, double price, int pieces, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pieces = pieces;
        this.style = getCakeStyle();
        setType(type);
    }

    public abstract CakeStyle getCakeStyle();

    private void setType(String type) {
        List<String> types = getCakeTypes();
        if (types.contains(type)) {
            this.type = type;
        }
    }

    public List<String> getCakeTypes() {
        return style.getTypes();
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public CakeStyle getStyle() {
        return this.style;
    }

    public String getType() {
        return this.type;
    }

    public int getPieces() {
        return this.pieces;
    }

    @Override
    public String toString() {
        return String.format("     %s, Type: %s, Pieces: %d, Price: %.2f",
                this.getName(), this.getType(), this.getPieces(), this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return name.equals(cake.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
