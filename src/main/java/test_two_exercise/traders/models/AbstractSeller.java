package test_two_exercise.traders.models;

public abstract class AbstractSeller {

    private static final String DEFAULT_NAME = "John";
    private static final String DEFAULT_REGISTRY_ADDRESS = "19 Avenue Str";
    private static final double DEFAULT_AMOUNT = 1000;

    private String name;
    private String registryAddress;
    protected double amount;

    protected AbstractSeller(String name, String registryAddress, double amount) {
        this.name = name;
        this.registryAddress = registryAddress;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty()){
            this.name = name;
            return;
        }
        System.out.println(String.format(
                "Seller name must be not null or empty. Default value of %s is set!", DEFAULT_NAME));
        this.name = DEFAULT_NAME;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public void setRegistryAddress(String registryAddress) {
        if(registryAddress != null && !registryAddress.isEmpty()){
            this.registryAddress = registryAddress;
            return;
        }
        System.out.println(String.format(
                "Seller registry address must be not null or empty. Default value of %s is set!",
                DEFAULT_REGISTRY_ADDRESS));
        this.registryAddress = DEFAULT_REGISTRY_ADDRESS;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if(amount >= 0){
            this.amount = amount;
            return;
        }
        System.out.println(String.format(
                "Seller amount must be equal or greater than 0. Default value of %.2f is set!",
                DEFAULT_AMOUNT));
        this.amount = DEFAULT_AMOUNT;
    }

    public void payTax(){

        double taxes = calculateTaxesToPay();

        if(taxes == 0){
            System.out.println("I don't have taxes to pay, because I don't have any shops!");
            return;
        }

        if(amount < taxes){
            System.out.println("I can't pay all taxes, because I don't have enough money! Bankrupt!");
            amount = 0;
            return;
        }

        System.out.println("I paid all taxes, because I am rich!");
        amount -= taxes;
    }

    public abstract void collectTurnover();
    public abstract void makeOrder(double price);
    protected abstract double calculateTaxesToPay();
}
