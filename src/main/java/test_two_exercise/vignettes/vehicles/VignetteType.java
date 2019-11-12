package test_two_exercise.vignettes.vehicles;

public enum VignetteType {
    CAR_VIGNETTE("red", 5, 5, VehicleType.CAR),
    BUS_VIGNETTE("green", 9, 20, VehicleType.BUS),
    TRUCK_VIGNETTE("blue", 7, 10, VehicleType.TRUCK);

    private String color;
    private int dailyPrice;
    private int stickTime;
    private VehicleType vehicleType;

    VignetteType(String color, int dailyPrice, int stickTime, VehicleType vehicleType) {
        this.color = color;
        this.dailyPrice = dailyPrice;
        this.stickTime = stickTime;
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return this.color;
    }

    public int getDailyPrice() {
        return this.dailyPrice;
    }

    public int getMonthlyPrice() {
        return this.dailyPrice * 10;
    }

    public int getYearlyPrice() {
        return getMonthlyPrice() * 6;
    }

    public int getStickTime(){
        return this.stickTime;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
