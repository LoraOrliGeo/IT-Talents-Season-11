package test_two_exercise.traders.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractProvider {

    private static final String DEFAULT_NAME = "John";
    private static final String DEFAULT_ADDRESS = "19 Avenue Str";
    private static final String DEFAULT_WORKING_TIME = "09:00 - 18:00";

    private String name;
    private String address;
    private String workingTime;
    protected ProviderType providerType;
    private double price;

    protected AbstractProvider(String name, String address, String workingTime) {
        setName(name);
        setAddress(address);
        setWorkingTime(workingTime);
        setProviderType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            return;
        }
        System.out.println(String.format(
                "Provider name must be not null or empty. Default value of %s is set!", DEFAULT_NAME));
        this.name = DEFAULT_NAME;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
            return;
        }
        System.out.println(String.format(
                "Provider address must be not null or empty. Default value of %s is set!", DEFAULT_ADDRESS));
        this.address = DEFAULT_ADDRESS;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        if (workingTime != null && !workingTime.isEmpty()) {
            this.workingTime = workingTime;
            return;
        }
        System.out.println(String.format(
                "Provider working time must be not null or empty. Default value of %s is set!", DEFAULT_WORKING_TIME));
        this.workingTime = DEFAULT_WORKING_TIME;
    }

    public ProviderType getProviderType() {
        return providerType;
    }

    public int getProviderDiscountPercent() {
        return providerType.getDiscountPercent();
    }

    protected abstract void setProviderType();

    public List<Item> makeOrder(double price) {

        List<Item> items = new ArrayList<>();

        while (price != 0) {
            Item item = generateRandomItem();
            if (item.getPrice() > price) {
                item.setPrice(price);
            }

            items.add(item);
            price -= item.getPrice();
        }

        return items;
    }

    private Item generateRandomItem() {
        Random random = new Random();
        return new Item("Random item name", 5 + (10) * random.nextDouble());
    }
}
