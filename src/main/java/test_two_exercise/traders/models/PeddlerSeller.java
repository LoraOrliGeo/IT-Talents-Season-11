package test_two_exercise.traders.models;

import java.util.List;

public class PeddlerSeller extends AbstractSeller {

    private RetailerProvider provider;
    private AbstractShop shop;

    public PeddlerSeller(String name, String registryAddress, double amount, RetailerProvider provider, AbstractShop shop) {
        super(name, registryAddress, amount);
        setProvider(provider);
        setShop(shop);
    }

    public RetailerProvider getProvider() {
        return provider;
    }

    public void setProvider(RetailerProvider provider) {
        this.provider = provider;
    }

    public AbstractShop getShop() {
        return shop;
    }

    public void setShop(AbstractShop shop) {
        if(shop == null){
            System.out.println("Peddler seller shop is not set because it is null!");
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

        if(provider == null){
            System.out.println("I can't make my order, because I don't have provider!");
            return;
        }

        if(price > amount / 2){
            System.out.println("Cannot make order, because price exceed seller amount");
            return;
        }

        List<Item> items = provider.makeOrder(price);
        shop.addItems(items);
    }

    @Override
    protected double calculateTaxesToPay() {
        return shop == null ? 0 : shop.getTax();
    }
}
