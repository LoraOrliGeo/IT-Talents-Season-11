package test_two_exercise.traders.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoloSeller extends AbstractSeller {

    private static final int MAX_PROVIDERS_COUNT = 5;
    private List<RetailerProvider> providers;
    private AbstractShop shop;

    public SoloSeller(String name, String registryAddress, double amount, List<RetailerProvider> providers, AbstractShop shop) {
        super(name, registryAddress, amount);
        setProviders(providers);
        setShop(shop);
    }

    public List<RetailerProvider> getProviders() {
        return providers;
    }

    private void setProviders(List<RetailerProvider> providers) {
        if (providers == null || providers.size() > MAX_PROVIDERS_COUNT) {
            System.out.println(String.format(
                    "Providers list is null or contains more than %d providers! Providers list set to be empty.",
                    MAX_PROVIDERS_COUNT));
            this.providers = new ArrayList<>();
            return;
        }
        this.providers = providers;
    }

    public void addProvider(RetailerProvider retailerProvider) {
        if (retailerProvider == null || providers.size() == MAX_PROVIDERS_COUNT) {
            System.out.println("Provider is not added because it is not valid or no space for it!");
            return;
        }
        providers.add(retailerProvider);
    }

    public AbstractShop getShop() {
        return shop;
    }

    private void setShop(AbstractShop shop) {
        if (shop == null || ShopType.OUTLET_SHOP.equals(shop.getShopType())) {
            System.out.println("Solo seller shop is not set because it is null or not valid!");
            return;
        }
        this.shop = shop;
    }

    @Override
    public void collectTurnover() {
        if (shop == null) {
            return;
        }
        amount += shop.getTurnover() * (30 / 100.0);
    }

    @Override
    public void makeOrder(double price) {

        if(shop == null){
            System.out.println("I can't make my order, because I don't have a shop!");
            return;
        }

        if(providers == null || providers.isEmpty()){
            System.out.println("I can't make my order, because I don't have providers!");
            return;
        }

        if(price > amount / 2){
            System.out.println("Cannot make order, because price exceed seller amount");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(providers.size());
        List<Item> items = providers.get(index).makeOrder(price);
        shop.addItems(items);
    }

    @Override
    protected double calculateTaxesToPay() {
        return shop == null ? 0 : shop.getTax();
    }
}
