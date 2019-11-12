package test_two_exercise.real_estates.real_estates_types;

import test_two_exercise.real_estates.agency.Agent;
import test_two_exercise.real_estates.clients.Seller;

import java.util.Objects;

public abstract class RealEstate {
    private String description;
    private String address;
    protected double price;
    private String type;
    private double area;
    private Agent agent;
    private Seller owner;

    public RealEstate(String description, String address, double price, String type, double area) {
        this.description = description;
        this.address = address;
        setPrice(price);
        setType(type);
        setArea(area);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public double getArea() {
        return area;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price){
        if(getMinRange() <= price && price <= getMaxRange()){
            this.price = price;
        }
    }

    private void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    public Seller getOwner() {
        return this.owner;
    }

    public void setOwner(Seller seller) {
        if (seller != null) {
            this.owner = seller;
        }
    }

    protected abstract String[] getRealEstateTypes();

    private void setType(String type) {
        String[] types = getRealEstateTypes();
        for (int i = 0; i < types.length; i++) {
            if (types[i].equalsIgnoreCase(type)) {
                this.type = type;
                return;
            }
        }
        System.out.println("The type is not valid!");
    }

    public Agent getAgent() {
        return this.agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    protected abstract int getMinRange();
    protected abstract int getMaxRange();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.area, area) == 0 &&
                Objects.equals(description, that.description) &&
                Objects.equals(address, that.address) &&
                Objects.equals(type, that.type) &&
                Objects.equals(agent, that.agent) &&
                Objects.equals(owner, that.owner);
    }
}
