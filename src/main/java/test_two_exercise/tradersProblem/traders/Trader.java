package test_two_exercise.tradersProblem.traders;

import test_two_exercise.tradersProblem.shops.Shop;

import java.util.List;

public abstract class Trader {
    private String name;
    private String registryAddress;
    protected double capital;
    private double paidTaxes;

    protected Trader(String name, String registryAddress, double capital) {
        this.name = name;
        this.registryAddress = registryAddress;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public double getCapital() {
        return capital;
    }

    public double getPaidTaxes() {
        return this.paidTaxes;
    }

    public void payTax() {
        double taxes = calculateTaxes();
        if (taxes <= this.capital) {
            this.capital -= taxes;
            paidTaxes += taxes;
        } else {
            this.capital = 0;
        }
    }

    public abstract List<Shop> getShops();

    public abstract double calculateTaxes();

    public abstract void takeTurnover();

    public abstract void makeOrder(double price);

    @Override
    public String toString() {
        return String.format("%s - balance: %.2f", this.getName(), this.getCapital());
    }
}
