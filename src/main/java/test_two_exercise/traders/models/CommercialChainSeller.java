package test_two_exercise.traders.models;

import test_two_exercise.sweetshop.Provider;

import java.util.ArrayList;
import java.util.List;

public class CommercialChainSeller extends AbstractSeller {

    private static final int MAX_PROVIDERS_COUNT = 15;
    private static final int MAX_SHOPS_COUNT = 10;

    private List<Provider> providers;
    private List<AbstractShop> shops;

    public CommercialChainSeller(String name, String registryAddress, double amount,
                                 List<Provider> providers,
                                 List<AbstractShop> shops) {
        super(name, registryAddress, amount);
        setProviders(providers);
        setShops(shops);
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        if (providers == null || providers.size() > MAX_PROVIDERS_COUNT) {
            System.out.println(String.format(
                    "Providers list is null or contains more than %d providers! Providers list set to be empty.",
                    MAX_PROVIDERS_COUNT));
            this.providers = new ArrayList<>();
            return;
        }
        this.providers = providers;
    }

    public List<AbstractShop> getShops() {
        return shops;
    }

    public void setShops(List<AbstractShop> shops) {

        this.shops = new ArrayList<>();

        if (shops == null) {
            System.out.println("Shops list is null! Shop list set to be empty.");
            return;
        }

        for (AbstractShop shop : shops) {
            if (ShopType.STAND_SHOP.equals(shop.getShopType())) {
                System.out.println("Skip shop because it is stand shop and cannot be set!");
                continue;
            }

            shops.add(shop);
            if (shops.size() == MAX_SHOPS_COUNT) {
                break;
            }
        }
    }

    @Override
    public void collectTurnover() {
        if (shops == null) {
            return;
        }
        for (AbstractShop shop : shops) {
            amount += shop.getTurnover() * (30 / 100.0);
        }
    }

    @Override
    public void makeOrder(double price) {

        if (price > amount / 2) {
            System.out.println("Cannot make order, because price exceed seller amount");
            return;
        }
    }

    @Override
    protected double calculateTaxesToPay() {

        if (shops == null) {
            return 0;
        }

        double totalTaxes = 0;
        for (AbstractShop shop : shops) {
            totalTaxes += shop.getTax();
        }

        return totalTaxes;
    }
}
