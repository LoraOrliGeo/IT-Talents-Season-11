package test_two_exercise.tradersProblem.shops;

import java.util.Random;

public class Outlet extends Shop {
    private static final int TAX = 150;

    public Outlet(String address, String workTime) {
        super(address, workTime, Outlet.TAX);
    }

    @Override
    protected int generateRandomArea() {
        Random r = new Random();
        return r.nextInt(91) + 10;
    }

    @Override
    public ShopType getShopType() {
        return ShopType.OUTLET;
    }
}
