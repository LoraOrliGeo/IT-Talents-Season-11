package module_three.test_three_exercise.test_three.models;

import module_three.test_three_exercise.test_three.models.breads.Bread;
import module_three.test_three_exercise.test_three.models.garnish.Garnish;
import module_three.test_three_exercise.test_three.models.meats.Meat;

import java.time.LocalDateTime;

public class Order {
    private Bread.BreadType breadType;
    private Meat.MeatType meatType;
    private Garnish.GarnishType garnishType;
    private double price;
    private LocalDateTime orderTime;
    private int preparationTime; // seconds

    public Order(Bread.BreadType breadType, Meat.MeatType meatType, Garnish.GarnishType garnishType) {
        this.breadType = breadType;
        this.meatType = meatType;
        this.garnishType = garnishType;
    }

    public Bread.BreadType getBreadType() {
        return breadType;
    }

    public Meat.MeatType getMeatType() {
        return meatType;
    }

    public Garnish.GarnishType getGarnishType() {
        return garnishType;
    }

    public double getPrice() {
        return price;
    }

    public void setBreadType(Bread.BreadType breadType) {
        this.breadType = breadType;
    }

    public void setMeatType(Meat.MeatType meatType) {
        this.meatType = meatType;
    }

    public void setGarnishType(Garnish.GarnishType garnishType) {
        this.garnishType = garnishType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        return String.format("%s, %s %s - %.2f, %s%n",
                this, breadType, this.meatType, this.garnishType,
                this.price, this.orderTime);
    }
}
