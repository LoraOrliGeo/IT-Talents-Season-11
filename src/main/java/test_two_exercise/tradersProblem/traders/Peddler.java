package test_two_exercise.tradersProblem.traders;

import test_two_exercise.tradersProblem.Product;
import test_two_exercise.tradersProblem.providers.RetailerProvider;
import test_two_exercise.tradersProblem.shops.Shop;

import java.util.ArrayList;
import java.util.List;

public class Peddler extends Trader {
    private Shop shop;
    private RetailerProvider provider;

    public Peddler(String name, String registryAddress, double capital, Shop shop, RetailerProvider provider) {
        super(name, registryAddress, capital);
        setShop(shop);
        this.provider = provider;
    }

    public RetailerProvider getProvider() {
        return provider;
    }

    @Override
    public List<Shop> getShops() {
        List<Shop> shops = new ArrayList<>();
        if (this.shop != null) {
            shops.add(this.shop);
        }
        return shops;
    }

    private void setShop(Shop shop) {
        if (shop != null) {
            this.shop = shop;
        }
    }

    @Override
    public double calculateTaxes() {
        return this.shop == null ? 0 : this.shop.getTax();
    }

    @Override
    public void takeTurnover() {
        this.capital += (this.shop.getTurnover() * 1.3);
    }

    @Override
    public void makeOrder(double price) {
        if (this.shop == null || this.provider == null || price > this.capital / 2) {
            System.out.println("Cannot make order!");
            return;
        }

        List<Product> products = this.provider.createOrder(price);
        this.shop.addProducts(products);
        shop.printProducts();
    }
}
