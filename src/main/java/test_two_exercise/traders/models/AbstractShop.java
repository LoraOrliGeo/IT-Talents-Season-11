package test_two_exercise.traders.models;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShop {

    private static final String DEFAULT_ADDRESS = "19 Avenue Str";
    private static final String DEFAULT_WORKING_TIME = "09:00 - 18:00";

    private String address;
    private String workingTime;
    private double area;
    protected double tax;
    private List<Item> items;
    private List<Item> soldItems;

    protected AbstractShop(String address, String workingTime, double area, List<Item> items) {
        setAddress(address);
        setWorkingTime(workingTime);
        setArea(area);
        setTax();
        setItems(items);
        this.soldItems = new ArrayList<>();
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
                "Shop address must be not null or empty. Default value of %s is set!", DEFAULT_ADDRESS));
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
                "Shop working time must be not null or empty. Default value of %s is set!", DEFAULT_WORKING_TIME));
        this.workingTime = DEFAULT_WORKING_TIME;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (getMinAreaSquareMeters() <= area && area <= getMaxAreaSquareMeters()) {
            this.area = area;
            return;
        }
        System.out.println(String.format(
                "Shop area must be between %.2f and %.2f. Default value of %.2f is set!",
                getMinAreaSquareMeters(),
                getMaxAreaSquareMeters(),
                getDefaultAreaSquareMeters()));
        this.area = getDefaultAreaSquareMeters();
    }

    public double getTax() {
        return tax;
    }

    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {

        if (items == null) {
            this.items = new ArrayList<>();
        }

        this.items = items;
    }

    public void addItems(List<Item> items) {
        this.items.addAll(items);
    }

    public double getTurnover() {
        double turnover = 0;
        for (Item item : soldItems) {
            turnover += item.getPrice();
        }

        return turnover;
    }

    protected abstract double getMinAreaSquareMeters();

    protected abstract double getMaxAreaSquareMeters();

    protected abstract double getDefaultAreaSquareMeters();

    protected abstract void setTax();

    protected abstract ShopType getShopType();
}
