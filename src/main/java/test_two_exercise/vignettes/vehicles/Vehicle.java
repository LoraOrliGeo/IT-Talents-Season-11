package test_two_exercise.vignettes.vehicles;

import test_two_exercise.vignettes.Vignette;

public abstract class Vehicle {
    private Vignette vignette;
    private int yearManufacture;

    protected Vehicle(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public void setVignette(Vignette vignette) {
        if (vignette != null) {
            this.vignette = vignette;
            this.vignette.stick();
        }
    }

    public Vignette getVignette() {
        return this.vignette;
    }

    public abstract VehicleType getType();

    @Override
    public String toString() {
        return String.format("%s - %s", this.getType(), this.vignette.getDateOfExpire());
    }
}
