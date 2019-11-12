package test_two_exercise.tradersProblem.providers;

public class WholesaleProvider extends Provider{

    public WholesaleProvider(String name, String address, String workTime) {
        super(name, address, workTime);
    }

    @Override
    public ProviderType getType() {
        return ProviderType.WHOLESALE;
    }
}
