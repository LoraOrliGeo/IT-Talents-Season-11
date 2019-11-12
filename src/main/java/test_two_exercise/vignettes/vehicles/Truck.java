package test_two_exercise.vignettes.vehicles;

public class Truck extends Vehicle {
    public Truck(int yearManufacture) {
        super(yearManufacture);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
