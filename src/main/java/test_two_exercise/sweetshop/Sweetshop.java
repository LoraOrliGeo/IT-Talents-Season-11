package test_two_exercise.sweetshop;

import test_two_exercise.sweetshop.cakes.*;
import test_two_exercise.sweetshop.clients.Client;
import test_two_exercise.sweetshop.clients.CorporateClient;
import test_two_exercise.sweetshop.clients.PrivateClient;

import java.util.*;

public class Sweetshop {
    private static final int NUMBER_OF_DELIVERS = 5;

    private String name;
    private String address;
    private String number;
    private Set<Provider> providers;
    private final Map<CakeStyle, Set<Cake>> catalogue;
    private Map<CakeStyle, Set<Cake>> availableCakes;
    private double money;
    private Map<CakeStyle, Integer> soldCakes;
    private List<Client> clients;

    public Sweetshop(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.soldCakes = new HashMap<>();
        this.clients = new ArrayList<>();
        addProviders();
        this.catalogue = createCatalogue();
        this.availableCakes = new HashMap<>();
        this.availableCakes.putAll(this.catalogue);
    }

    private void addProviders() {
        this.providers = new LinkedHashSet<>();

        for (int i = 0; i < NUMBER_OF_DELIVERS; i++) {
            Provider provider = new Provider("Provider" + (i + 1), "555-66-455" + i);
            this.providers.add(provider);
        }
    }

    private Map<CakeStyle, Set<Cake>> createCatalogue() {
        Map<CakeStyle, Set<Cake>> catalogue = initCatalogue();
        Random r = new Random();

        for (int i = 0; i < 30; i++) {
            int chance = r.nextInt(4);
            String cakeName = "Cake" + (i + 1);
            Cake cake = generateRandomCake(cakeName, chance);
            catalogue.get(cake.getCakeStyle()).add(cake);
        }

        return catalogue;
    }

    private Map<CakeStyle, Set<Cake>> initCatalogue() {
        Map<CakeStyle, Set<Cake>> catalogue = new HashMap<>();
        catalogue.put(CakeStyle.WEDDING, new HashSet<>());
        catalogue.put(CakeStyle.SPECIAL, new HashSet<>());
        catalogue.put(CakeStyle.STANDARD, new HashSet<>());
        catalogue.put(CakeStyle.CHILDREN, new HashSet<>());
        return catalogue;
    }

    public Map<CakeStyle, Set<Cake>> getCatalogue() {
        return Collections.unmodifiableMap(this.catalogue);
    }

    public Provider getRandomProvider() {
        List<Provider> providers = new ArrayList<>(this.providers);
        return providers.get(new Random().nextInt(this.providers.size()));
    }

    public void receiveMoney(double money) {
        this.money += money;
    }

    public double getMoney() {
        return this.money;
    }

    private Cake generateRandomCake(String cakeName, int chance) {
        Random r = new Random();
        double price = 15.50 + (26.99 - 15.50) * r.nextDouble(); // cake price - between 15.50 and 26.99
        int pieces = r.nextInt(11) + 1; // pieces numbers - between 1 and 10

        List<String> types;

        switch (chance) {
            case 0:
                types = CakeStyle.STANDARD.getTypes();
                return new StandardCake(cakeName, "descr", price,
                        pieces, types.get(r.nextInt(types.size())), r.nextBoolean());
            case 1:
                int floors = r.nextInt(5) + 1; // floors - between 1 and 5
                types = CakeStyle.WEDDING.getTypes();
                return new WeddingCake(cakeName, "descr", price,
                        pieces, types.get(r.nextInt(types.size())), floors);
            case 2:
                types = CakeStyle.SPECIAL.getTypes();
                return new SpecialCake(cakeName, "descr", price,
                        pieces, types.get(r.nextInt(types.size())), "EventName");
            default:
                types = CakeStyle.CHILDREN.getTypes();
                return new ChildrenCake(cakeName, "descr", price,
                        pieces, types.get(r.nextInt(types.size())), "KidName");
        }
    }

    public void registerOrder(Client client, List<Cake> cakes) {
        List<Cake> availableCakes = extractAvailableCakes(client, cakes);
        this.clients.add(client);
        Order order = new Order(client, availableCakes);
        Provider provider = getRandomProvider();

        double orderPrice = order.calculatePrice();

        provider.addOrder(order);
        provider.executeOrder(order, client.getPercentTip());

        double discount;

        if (client instanceof CorporateClient) {
            discount = ((CorporateClient) client).getDiscount() * orderPrice; // percent discount is applied
            orderPrice -= discount;
        } else if (client instanceof PrivateClient) {
            List<Double> vouchers = ((PrivateClient) client).getVouchers();
            while (vouchers.size() >= 1) {
                double voucher = vouchers.get(0);
                double diff = orderPrice - voucher;
                if (diff >= 0) {
                    orderPrice -= voucher;
                    vouchers.remove(0);
                } else {
                    orderPrice -= diff;
                    vouchers.set(0, voucher - diff);
                }
            }
        }

        client.spendMoney(orderPrice);
        removeOrderedCakes(availableCakes);
    }

    public List<Cake> extractAvailableCakes(Client client, List<Cake> cakes) {
        List<Cake> availableCakes = new ArrayList<>();

        for (Cake cake : cakes) {
            if (checkCakeAvailability(cake)) {
                System.out.println(String.format("%s successfully ordered a cake %s - %s %s",
                        client.getName(), cake.getName(), cake.getStyle(), cake.getType()));
                availableCakes.add(cake);
            }
        }

        return availableCakes;
    }

    private boolean checkCakeAvailability(Cake cake) {
        if (cake != null) {
            CakeStyle cakeStyle = cake.getStyle();
            if (this.availableCakes.containsKey(cakeStyle) && this.availableCakes.get(cakeStyle).contains(cake)) {
                return true;
            }
        }
        return false;
    }

    private void removeOrderedCakes(List<Cake> orderedCakes) {
        for (Cake orderedCake : orderedCakes) {
            CakeStyle cakeStyle = orderedCake.getStyle();
            this.soldCakes.putIfAbsent(cakeStyle, 0);
            this.soldCakes.put(cakeStyle, this.soldCakes.get(cakeStyle) + 1);
            this.availableCakes.get(cakeStyle).remove(orderedCake);
        }
    }

    public void printSweetshopIncome() {
        System.out.println(String.format("========== Sweetshop Income ==========%n%.2f", this.getMoney()));
    }

    public void printAvailableCakes() {
        System.out.println("========== Available Cakes ==========");
        System.out.println(CakeStyle.STANDARD);
        printSortedCakes(new ArrayList<>(availableCakes.get(CakeStyle.STANDARD)));
        System.out.println(CakeStyle.WEDDING);
        printSortedCakes(new ArrayList<>(availableCakes.get(CakeStyle.WEDDING)));
        System.out.println(CakeStyle.SPECIAL);
        printSortedCakes(new ArrayList<>(availableCakes.get(CakeStyle.SPECIAL)));
        System.out.println(CakeStyle.CHILDREN);
        printSortedCakes(new ArrayList<>(availableCakes.get(CakeStyle.CHILDREN)));
    }

    public void printProvidersRanking() {
        System.out.println("========== Providers Ranking by Tips ==========");
        this.providers.stream().sorted((e1, e2) -> Double.compare(e2.getTip(), e1.getTip()))
                .forEach(e -> System.out.println(e.toString()));
    }

    public void printMostSalableCakeStyle() {
        int max = 0;
        CakeStyle style = null;
        for (Map.Entry<CakeStyle, Integer> entry : this.soldCakes.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                style = entry.getKey();
            }
        }
        System.out.printf("========== Most salable cake style ==========%n%s%n", style);
    }

    public void printProviderMostOrders() {
        List<Provider> providers = new ArrayList<>(this.providers);
        providers.sort((e1, e2) -> Integer.compare(e2.getCompletedOrdersCount(), e1.getCompletedOrdersCount()));
        System.out.println("========== Provider with Highest Number of Orders ==========\n" +
                providers.get(0).getName() + " - orders: " + providers.get(0).getCompletedOrdersCount());
    }

    public void printClientSpentTheMost() {
        if (this.clients.isEmpty()) {
            System.out.println("There are not any clients!");
        } else {
            this.clients.sort((e1, e2) -> Double.compare(e2.getSpentMoney(), e1.getSpentMoney()));
            System.out.println("========== Client spent Highest Amount of Money on Cakes ==========\n"
                    + this.clients.get(0));
        }
    }

    private void printSortedCakes(List<Cake> cakes) {
        Collections.sort(cakes);
        for (Cake cake : cakes) {
            System.out.println(cake);
        }
    }
}
