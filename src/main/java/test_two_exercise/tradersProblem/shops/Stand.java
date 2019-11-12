package test_two_exercise.tradersProblem.shops;

import java.util.Random;

public class Stand extends Shop {
    private static final int TAX = 50;

    public Stand(String address, String workTime) {
        super(address, workTime, Stand.TAX);
    }

    @Override
    protected int generateRandomArea() {
        Random r = new Random();
        return r.nextInt(9) + 2;
    }

    @Override
    public ShopType getShopType() {
        return ShopType.STAND;
    }
}
