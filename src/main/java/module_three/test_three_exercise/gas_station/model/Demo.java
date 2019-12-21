package module_three.test_three_exercise.gas_station.model;

import module_three.test_three_exercise.gas_station.db.DbDao;

import java.sql.SQLException;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        // the block of code for creating table is commented after the table is crated once
//        try {
//            DbDao.getInstance().createTable();
//            System.out.println("Table created successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        while (true) {
            try {
                GasStation.getInstance().addCarToColumn(new Car(getRandomFuelType()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Car.FuelType getRandomFuelType() {
        return Car.FuelType.values()[new Random().nextInt(Car.FuelType.values().length)];
    }
}
