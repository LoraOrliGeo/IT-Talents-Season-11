package test_two_exercise.vignettes;

import test_two_exercise.vignettes.vehicles.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        GasStation gasStation = new GasStation();
        gasStation.printVignettes();

        Random r = new Random();

        // 2 - create 20 drivers
        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String name = "Random Name " + (i + 1);
            // the money will be random number between 50 and 2000
            double money = 50 + 1950 * r.nextDouble();
            Driver driver = new Driver(name, money, gasStation);
            drivers.add(driver);
        }

        // 3.1 - create 200 vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Vehicle vehicle;
            int chance = r.nextInt(3);
            // the car's year of manufacture will be random number between 1965 and 2018
            int yearManufacture = r.nextInt(54) + 1965;
            switch (chance) {
                case 0:
                    vehicle = new Car(yearManufacture);
                    break;
                case 1:
                    vehicle = new Bus(yearManufacture);
                    break;
                default:
                    vehicle = new Truck(yearManufacture);
                    break;
            }
            vehicles.add(vehicle);
        }

        // 3.2 - for every driver add 10 vehicles
        for (Driver driver : drivers) {
            List<Vehicle> driversVehicles = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                driversVehicles.add(vehicles.get(i));
            }
            driver.addVehicles(driversVehicles);
            vehicles.removeAll(driversVehicles);
        }

        // 4 - every third driver -> buy vignettes for 5 vehicles, the rest - vignettes for all vehicles
        for (int i = 0; i < drivers.size(); i++) {
            if (i % 3 == 0) {
                for (int j = 0; j < 5; j++) {
                    Driver driver = drivers.get(i);
                    int vehicleIdx = r.nextInt(driver.getVehicles().size());
                    PeriodType period = PeriodType.values()[r.nextInt(PeriodType.values().length)];
                    driver.buyVignette(vehicleIdx, period);
                }
            } else {
                drivers.get(i).buyVignettes();
            }
        }

        // 5 - print info for all drivers
        for (Driver driver : drivers) {
            driver.printInfo();
        }

        // 6 - print the left vignettes
        gasStation.printVignettes();

        // 7 - print all tricks with expire vignette for given date
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Driver driver : drivers) {
            allVehicles.addAll(driver.getVehicles());
        }
        List<Vehicle> trucks = allVehicles.stream()
                .filter(v -> v.getType().equals(VehicleType.TRUCK))
                .collect(Collectors.toList());
        printTrucksWithExpireVignettes(trucks, LocalDate.now());
    }

    private static void printTrucksWithExpireVignettes(List<Vehicle> trucks, LocalDate date) {
        System.out.println("Trucks with expire vignettes:");
        for (Vehicle truck : trucks) {
            if (truck.getVignette() != null) {
                if (truck.getVignette().getDateOfExpire().isAfter(date)) {
                    System.out.println(truck);
                }
            }
        }
    }
}
