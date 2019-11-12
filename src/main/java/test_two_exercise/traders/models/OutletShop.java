package test_two_exercise.traders.models;

import java.util.List;

public class OutletShop extends AbstractShop {

    private static final double MIN_AREA_SQUARE_METERS = 10;
    private static final double MAX_AREA_SQUARE_METERS = 100;

    public OutletShop(String address, String workingTime, double area, List<Item> items) {
        super(address, workingTime, area, items);
    }

    @Override
    protected double getMinAreaSquareMeters() {
        return MIN_AREA_SQUARE_METERS;
    }

    @Override
    protected double getMaxAreaSquareMeters() {
        return MAX_AREA_SQUARE_METERS;
    }

    @Override
    protected double getDefaultAreaSquareMeters() {
        return (MIN_AREA_SQUARE_METERS + MAX_AREA_SQUARE_METERS) / 2;
    }

    @Override
    protected void setTax() {
        this.tax = ShopType.OUTLET_SHOP.getTax();
    }

    @Override
    protected ShopType getShopType() {
        return ShopType.OUTLET_SHOP;
    }
}
