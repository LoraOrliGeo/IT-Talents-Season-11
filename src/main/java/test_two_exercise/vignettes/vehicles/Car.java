package test_two_exercise.vignettes.vehicles;

public class Car extends Vehicle {
    public Car(int yearManufacture) {
        super(yearManufacture);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
