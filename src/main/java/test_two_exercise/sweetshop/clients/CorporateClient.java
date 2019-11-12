package test_two_exercise.sweetshop.clients;

import test_two_exercise.sweetshop.cakes.*;

import java.util.List;
import java.util.Random;

public class CorporateClient extends Client {

    private static final double PERCENT_TIP = 0.05;

    public CorporateClient(String name, String number, String address) {
        super(name, number, address);
    }

    @Override
    public void makeOrder() {
        // cakes (3-5) of different style and type
        List<Cake> cakes = this.chooseCakes();
        sweetshop.registerOrder(this, cakes);
    }

    public double getDiscount() {
        Random r = new Random();
        return (r.nextInt(11) + 5) * 1.0 / 100;
    }

    protected int getRandomNumberOfCakes() {
        return new Random().nextInt(3) + 3;
    }

    @Override
    public double getPercentTip() {
        return PERCENT_TIP;
    }
}
