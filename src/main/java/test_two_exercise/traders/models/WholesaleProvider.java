package test_two_exercise.traders.models;

public class WholesaleProvider extends AbstractProvider{

    public WholesaleProvider(String name, String address, String workingTime) {
        super(name, address, workingTime);
    }

    @Override
    protected void setProviderType() {
        this.providerType = ProviderType.WHOLESALE;
    }
}
