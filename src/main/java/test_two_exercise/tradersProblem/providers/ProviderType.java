package test_two_exercise.tradersProblem.providers;

public enum ProviderType {
    WHOLESALE(15), RETAILER(0);

    int percentDiscount;

    ProviderType(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public int getPercentDiscount() {
        return this.percentDiscount;
    }
}
