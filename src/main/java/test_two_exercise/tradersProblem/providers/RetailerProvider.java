package test_two_exercise.tradersProblem.providers;

public class RetailerProvider extends Provider {

    public RetailerProvider(String name, String address, String workTime) {
        super(name, address, workTime);
    }

    @Override
    public ProviderType getType() {
        return ProviderType.RETAILER;
    }
}
