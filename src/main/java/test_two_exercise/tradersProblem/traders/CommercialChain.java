package test_two_exercise.tradersProblem.traders;

import test_two_exercise.tradersProblem.Product;
import test_two_exercise.tradersProblem.providers.Provider;
import test_two_exercise.tradersProblem.providers.ProviderType;
import test_two_exercise.tradersProblem.shops.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommercialChain extends Trader {
    private static final int NUMBER_OF_PROVIDERS = 15;
    private static final int NUMBER_OF_SHOPS = 10;

    private List<Provider> providers;
    private List<Shop> shops;

    public CommercialChain(String name, String registryAddress, double capital, List<Shop> shops, List<Provider> providers) {
        super(name, registryAddress, capital);
        setShops(shops);
        setProviders(providers);
    }

    private void setProviders(List<Provider> providers) {
        this.providers = new ArrayList<>();
        if (providers != null) {
            for (Provider provider : providers) {
                this.providers.add(provider);

                if (this.providers.size() == NUMBER_OF_PROVIDERS) {
                    break;
                }
            }
        }
    }

    @Override
    public List<Shop> getShops() {
        List<Shop> shops = new ArrayList<>();
        if (this.shops != null && !this.shops.isEmpty()) {
            shops.addAll(this.shops);
        }
        return shops;
    }

    private void setShops(List<Shop> shops) {
        this.shops = new ArrayList<>();
        if (shops != null) {
            for (Shop shop : shops) {
                if (!"Stand".equals(shop.getShopType())) {
                    this.shops.add(shop);
                }
                if (this.shops.size() == NUMBER_OF_SHOPS) {
                    break;
                }
            }
        }
    }

    @Override
    public double calculateTaxes() {
        double taxes = 0;

        if (this.shops != null && !this.shops.isEmpty()) {
            for (Shop shop : this.shops) {
                taxes += shop.getTax();
            }
        }

        return taxes;
    }

    @Override
    public void takeTurnover() {
        if (this.shops != null && !this.shops.isEmpty()) {
            for (Shop shop : this.shops) {
                this.capital += (shop.getTurnover() * 1.3);
            }
        }
    }

    @Override
    public void makeOrder(double price) {
        if (this.providers == null || this.providers.isEmpty() ||
                this.shops == null || this.shops.isEmpty() ||
                price > this.capital / 2) {
            System.out.println("Cannot make order!");
            return;
        }

        Random r = new Random();

        for (Shop shop : this.shops) {
            Provider provider = this.providers.get(r.nextInt(this.providers.size()));

            if (ProviderType.WHOLESALE.equals(provider.getType())) {
                double discount = price * provider.getProviderDiscountPercentage() / 100;
                price -= discount;
                this.capital += discount;
            }

            List<Product> products = provider.createOrder(price);
            shop.addProducts(products);
            shop.printProducts();
        }
    }

}
