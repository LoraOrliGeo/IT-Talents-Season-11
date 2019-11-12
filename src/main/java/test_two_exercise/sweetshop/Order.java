package test_two_exercise.sweetshop;

import test_two_exercise.sweetshop.cakes.Cake;
import test_two_exercise.sweetshop.clients.Client;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Client client;
    private double price;
    private String addressDelivery;
    private List<Cake> cakes;
    private LocalDateTime dateTimeDelivery;

    public Order(Client client, List<Cake> cakes) {
        this.client = client;
        this.cakes = cakes;
        this.addressDelivery = client.getAddress();
    }

    public void setDateTimeDelivery(LocalDateTime dateTimeDelivery) {
        this.dateTimeDelivery = dateTimeDelivery;
    }

    public double calculatePrice() {
        for (Cake cake : this.cakes) {
            this.price += cake.getPrice();
        }
        return this.price;
    }

    public double getPrice() {
        return price;
    }
}
