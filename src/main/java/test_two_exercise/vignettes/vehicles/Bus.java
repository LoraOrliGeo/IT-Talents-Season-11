package test_two_exercise.vignettes.vehicles;

public class Bus extends Vehicle {
    public Bus(int yearManufacture) {
        super(yearManufacture);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.BUS;
    }
}
