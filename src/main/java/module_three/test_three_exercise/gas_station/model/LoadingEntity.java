package module_three.test_three_exercise.gas_station.model;

import java.time.LocalDateTime;

public class LoadingEntity {
    private int columnId;
    private Car.FuelType fuelType;
    private int liters;
    private LocalDateTime loadingTime;

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public Car.FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(Car.FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public LocalDateTime getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(LocalDateTime loadingTime) {
        this.loadingTime = loadingTime;
    }
}
