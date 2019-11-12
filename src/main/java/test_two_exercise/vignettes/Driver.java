package test_two_exercise.vignettes;

import test_two_exercise.vignettes.vehicles.Vehicle;
import test_two_exercise.vignettes.vehicles.VehicleType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Driver {
    private String name;
    private List<Vehicle> vehicles;
    private double money;
    private GasStation gasStation;

    public Driver(String name, double money, GasStation gasStation) {
        this.name = name;
        this.money = money;
        this.vehicles = new ArrayList<>();
        this.gasStation = gasStation;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public double getMoney() {
        return money;
    }

    public void addVehicles(List<Vehicle> vehicles) {
        this.vehicles.addAll(vehicles);

    }

    public void buyVignettes() {
        Random r = new Random();
        for (int i = 0; i < vehicles.size(); i++) {
            buyVignette(i, PeriodType.values()[r.nextInt(PeriodType.values().length)]);
        }
    }

    public void buyVignette(int number, PeriodType period) {

        if (number >= vehicles.size()) {
            return;
        }

        Vehicle vehicle = this.vehicles.get(number);
        Vignette vignette = gasStation.sellVignette(vehicle, period);

        if (vignette == null) {
            return;
        }

        if (money < vignette.getPrice()) {
            return;
        }

        this.money -= vignette.getPrice();
        vehicle.setVignette(vignette);
    }

    public List<Vehicle> getVehiclesWithExpireVignette(LocalDate currentDate) {
        List<Vehicle> vehiclesWithExpireVignette = new ArrayList<>();

        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getVignette() != null) {
                LocalDate dateOfExpire = vehicle.getVignette().getDateOfExpire();
                if (dateOfExpire.isAfter(currentDate)) {
                    vehiclesWithExpireVignette.add(vehicle);
                }
            }
        }

        return vehiclesWithExpireVignette;
    }

    public void printInfo() {
        System.out.println(String.format("%s has %s cars, number of expire vignettes: %d, money: %.2f",
                this.getName(),
                this.getCarCount(),
                this.getVehiclesWithExpireVignette(LocalDate.now()).size(),
                this.getMoney()));
    }

    private int getCarCount() {
        int cars = 0;
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getType().equals(VehicleType.CAR)) {
                cars++;
            }
        }
        return cars;
    }
}
