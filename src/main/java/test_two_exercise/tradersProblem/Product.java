package test_two_exercise.tradersProblem;

import java.util.Objects;
import java.util.Random;

public class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(String name) {
        this.name = name;
        this.price = getRandomPrice();
    }

    private double getRandomPrice() {
        Random r = new Random();
        return 5 + 10 * r.nextDouble(); // min + (max - min) * r.nextDouble()
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.getName(), this.getPrice());
    }
}
