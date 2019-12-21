package module_three.test_three_exercise.gas_station.model;

public class Car {

    public enum FuelType {
        GAS, PETROL, DIESEL
    }

    private FuelType fuel;
    private CarOwner owner;
    private static int uniqueId = 1;
    private int carId;
    private boolean isLoaded = false;

    public Car(FuelType fuel) {
        this.fuel = fuel;
        this.carId = uniqueId++;
        this.owner = new CarOwner("Driver " + carId);
    }

    public FuelType getFuel() {
        return fuel;
    }

    public CarOwner getOwner() {
        return this.owner;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }
}
