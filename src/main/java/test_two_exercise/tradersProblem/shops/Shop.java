package test_two_exercise.tradersProblem.shops;

import test_two_exercise.tradersProblem.Product;

import java.util.*;

public abstract class Shop {
    private String address;
    private String workTime;
    private int area;
    private double tax;
    private List<Product> products;
    private List<Product> soldProducts;

    protected Shop(String address, String workTime, double tax) {
        this.address = address;
        this.workTime = workTime;
        this.area = generateRandomArea();
        this.tax = tax;
        this.products = new ArrayList<>();
        this.soldProducts = new ArrayList<>();
    }

    public double getTax() {
        return tax;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public void sellProducts() {
        if (this.products != null && !this.products.isEmpty()) {
            Random r = new Random();
            int numberOfProductsToSell = r.nextInt(this.products.size());

            for (int i = 0; i < numberOfProductsToSell; i++) {
                int idx = r.nextInt(this.products.size());
                this.soldProducts.add(this.products.get(idx));
                this.products.remove(idx);
            }
        }
    }

    public double getTurnover() {
        double turnover = 0;
        for (Product soldProduct : this.soldProducts) {
            turnover += soldProduct.getPrice();
        }
        return turnover;
    }

    protected abstract int generateRandomArea();

    public abstract ShopType getShopType();

    public void printProducts() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Products in shop on address: " + this.address);
        for (Product product : this.products) {
            System.out.println(product);
        }
    }
}
