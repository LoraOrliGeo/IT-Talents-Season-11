package test_two_exercise.traders.models;

public enum ShopType {
    STAND_SHOP(50), OUTLET_SHOP(150), BOOTH_SHOP(50);

    private int tax;

    ShopType(int tax){
        this.tax = tax;
    }

    public int getTax(){
        return tax;
    }
}
