package test_two_exercise.traders.models;

public enum ProviderType {

    RETAILER(0), WHOLESALE(15);

    private int discountPercent;

    ProviderType(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountPercent(){
        return discountPercent;
    }
}
