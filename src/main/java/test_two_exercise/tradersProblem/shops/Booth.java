package test_two_exercise.tradersProblem.shops;

import java.util.Random;

public class Booth extends Shop {
    private static final int TAX = 50;

    public Booth(String address, String workTime) {
        super(address, workTime, Booth.TAX);
    }

    @Override
    protected int generateRandomArea() {
        Random r = new Random();
        return r.nextInt(3) + 4;
    }

    @Override
    public ShopType getShopType() {
        return ShopType.BOOTH;
    }
}
