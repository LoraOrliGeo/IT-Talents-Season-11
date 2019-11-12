package test_two_exercise.tradersProblem.providers;

import test_two_exercise.tradersProblem.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Provider {
    private String name;
    private String address;
    private String workTime;
    private ProviderType type;

    protected Provider(String name, String address, String workTime) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.type = getType();
    }

    public String getName() {
        return this.name;
    }

    public abstract ProviderType getType();

    public List<Product> createOrder(double price) {
        List<Product> products = new ArrayList<>();

        while (price >= 0) {
            Product product = generateRandomProduct();
            products.add(product);
            price -= product.getPrice();
        }

        return products;
    }

    public int getProviderDiscountPercentage() {
        return getType().getPercentDiscount();
    }

    private Product generateRandomProduct() {
        return new Product("Random Product Name");
    }

    @Override
    public String toString() {
        return String.format("%s - %s %s %s",
                this.name, this.type, this.address, this.workTime);
    }
}
