package test_two_exercise.tradersProblem;

import test_two_exercise.tradersProblem.providers.Provider;
import test_two_exercise.tradersProblem.providers.ProviderType;
import test_two_exercise.tradersProblem.providers.RetailerProvider;
import test_two_exercise.tradersProblem.providers.WholesaleProvider;
import test_two_exercise.tradersProblem.shops.Booth;
import test_two_exercise.tradersProblem.shops.Outlet;
import test_two_exercise.tradersProblem.shops.Shop;
import test_two_exercise.tradersProblem.shops.Stand;
import test_two_exercise.tradersProblem.traders.CommercialChain;
import test_two_exercise.tradersProblem.traders.Peddler;
import test_two_exercise.tradersProblem.traders.SoleTrader;
import test_two_exercise.tradersProblem.traders.Trader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Random r = new Random();

        // 1 - create 10 providers - retailers and wholesale

        List<Provider> providers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int chance = r.nextInt(2);
            Provider provider;

            String name = "Provider" + (i + 1);
            String address = "Random Address";
            String workingTime = "9:00 - 17:00";

            switch (chance) {
                case 0:
                    provider = new RetailerProvider(name, address, workingTime);
                    break;
                default:
                    provider = new WholesaleProvider(name, address, workingTime);
                    break;
            }

            providers.add(provider);
        }

        // 2 - create 20 shops - stands, booths, outlets

        List<Shop> shops = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int chance = r.nextInt(3);
            Shop shop;
            String address = "Address" + (i + 1);
            String workingTime = "9:00 - 17:00";
            switch (chance) {
                case 0:
                    shop = new Stand(address, workingTime);
                    break;
                case 1:
                    shop = new Booth(address, workingTime);
                    break;
                default:
                    shop = new Outlet(address, workingTime);
                    break;
            }
            shops.add(shop);
        }

        // 3 - create three traders: 1 peddler, 1 sole trader, 1 commercial chain
        // 4 - set shops to the traders

        List<Trader> traders = new ArrayList<>();
        String registryAddress = "Registry Address";

        Trader peddler = new Peddler("Peddler", registryAddress,
                100, shops.get(r.nextInt(shops.size())), getRandomRetailerProvider(providers));

        List<RetailerProvider> soleTraderProviders = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            soleTraderProviders.add(getRandomRetailerProvider(providers));
        }

        Trader sole = new SoleTrader("Sole", registryAddress,
                500, shops.get(r.nextInt(shops.size())), soleTraderProviders);

        Trader commercialChain = new CommercialChain("CC", registryAddress,
                3000, shops, providers);

        traders.add(peddler);
        traders.add(sole);
        traders.add(commercialChain);

        // 5 - make orders, take turnovers, pay taxes

        trade(traders);

        // 6 - print the current money balance of each trader

        for (Trader trader : traders) {
            System.out.println(trader);
        }

        // 8 print the trader with highest value of paid taxes

        traders.sort((t1, t2) -> Double.compare(t2.getPaidTaxes(), t1.getPaidTaxes()));
        System.out.println("Trader with highest value of paid taxes: ");
        System.out.println(traders.get(0));
    }

    private static RetailerProvider getRandomRetailerProvider(List<Provider> providers) {
        RetailerProvider provider = null;
        for (Provider p : providers) {
            if (p.getType().equals(ProviderType.RETAILER)) {
                provider = (RetailerProvider) p;
                break;
                // I don't remove the provider from the list, because he can provide for other traders/shops
            }
        }
        return provider;
    }

    private static void trade(List<Trader> traders) {
        Random r = new Random();
        // the price to make an order will be between 10 and 500 lv (it's not specified in the description)
        double orderPrice = 10 + 490 * r.nextDouble();

        for (Trader trader : traders) {
            trader.makeOrder(orderPrice);

            List<Shop> shops = trader.getShops();
            if (!shops.isEmpty()) {
                for (Shop shop : shops) {
                    shop.sellProducts();
                }
            }

            trader.takeTurnover();
            trader.payTax();
        }
    }
}
