package test_two_exercise.tradersProblem.traders;

import test_two_exercise.tradersProblem.Product;
import test_two_exercise.tradersProblem.providers.RetailerProvider;
import test_two_exercise.tradersProblem.shops.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoleTrader extends Trader {
    private static final int NUMBER_OF_RETAILERS = 5;

    private Shop shop;
    private List<RetailerProvider> providers;

    public SoleTrader(String name, String registryAddress, double capital, Shop shop, List<RetailerProvider> providers) {
        super(name, registryAddress, capital);
        setShop(shop);
        setProviders(providers);
    }

    public List<RetailerProvider> getProviders() {
        return providers;
    }

    private void setProviders(List<RetailerProvider> providers) {
        this.providers = new ArrayList<>();
        if (providers != null && providers.size() <= NUMBER_OF_RETAILERS) {
            this.providers = providers;
        }
    }

    public void addProvider(RetailerProvider provider) {
        if (provider != null && this.providers.size() < NUMBER_OF_RETAILERS) {
            this.providers.add(provider);
        }
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
        if (shop != null && !shop.getShopType().equals("Outlet")) {
            this.shop = shop;
        }
    }

    @Override
    public double calculateTaxes() {
        return this.shop == null ? 0 : this.shop.getTax();
    }

    @Override
    public void takeTurnover() {
        if (shop != null) {
            this.capital += (this.shop.getTurnover() * 1.3);
        }
    }

    @Override
    public void makeOrder(double price) {
        if (this.providers == null || this.providers.isEmpty() || this.shop == null || price > this.capital / 2) {
            System.out.println("Cannot make order!");
            return;
        }

        Random r = new Random();
        RetailerProvider provider = this.providers.get(r.nextInt(this.providers.size()));
        List<Product> products = provider.createOrder(price);
        this.shop.addProducts(products);
        shop.printProducts();
    }
}
