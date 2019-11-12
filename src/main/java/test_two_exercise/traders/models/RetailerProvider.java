package test_two_exercise.traders.models;

public class RetailerProvider extends AbstractProvider {

    public RetailerProvider(String name, String address, String workingTime) {
        super(name, address, workingTime);
    }

    @Override
    protected void setProviderType() {
        this.providerType = ProviderType.RETAILER;
    }
}
