package module_three.test_three_exercise.gas_station.model;

import module_three.test_three_exercise.gas_station.db.DbDao;
import module_three.test_three_exercise.gas_station.db.StatisticsDao;

import java.io.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GasStation {
    private static final int NUMBER_OF_CASES = 2;
    private static final int NUMBER_OF_COLUMNS = 5;
    private static GasStation INSTANCE = new GasStation();
    private BlockingQueue<Car>[] columns;
    private BlockingQueue<CarOwner>[] cases;
    private Map<Integer, Set<LoadingEntity>> loadingLogs;
    private StatisticMaker statisticMaker;

    class StatisticMaker extends Thread {
        private File file = new File("C:\\Users\\Lori\\Desktop\\gas_station_statistics.txt");

        @Override
        public void run() {
            try {
                Thread.sleep(2400); // 24 hours
                file.createNewFile();
                printFirstStatistic();
                printSecondStatistic();
                printThirdStatistics();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void printFirstStatistic() throws SQLException {
            Map<Integer, Set<LoadingEntity>> x = StatisticsDao.getAllLoadingStandings();
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                for (Map.Entry<Integer, Set<LoadingEntity>> entry : x.entrySet()) {
                    pw.println("Column " + (entry.getKey() + 1) + ":");
                    for (LoadingEntity entity : entry.getValue()) {
                        pw.println("\t" + entity.getFuelType() + ", " +
                                entity.getLiters() + " liters, " +
                                entity.getLoadingTime());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void printSecondStatistic() throws SQLException {
            Map<Integer, Integer> y = StatisticsDao.getNumberOfCarsPerColumn();
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                pw.println();
                for (Map.Entry<Integer, Integer> entry : y.entrySet()) {
                    pw.println("Column " + (entry.getKey() + 1) + ": " + entry.getValue() + " cars");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void printThirdStatistics() throws SQLException {
            Map<String, Integer> z = StatisticsDao.getTotalLitersPerFuelType();
            double gasPriceLiter = 1.6;
            double dieselPriceLiter = 2.4;
            double petrolPriceLiter = 2;

            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                pw.println();
                for (Map.Entry<String, Integer> entry : z.entrySet()) {
                    pw.println(entry.getKey() + ": " + entry.getValue() + " liters");
                }

                pw.println();
                double total = z.get("GAS") * gasPriceLiter + z.get("DIESEL") * dieselPriceLiter + z.get("PETROL") * petrolPriceLiter;
                pw.println("Total Price = " + total);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    private GasStation() {
        initColumns();
        initCases();
        this.loadingLogs = new HashMap<>();
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        worker1.start();
        worker2.start();
        Cashier cashier1 = new Cashier();
        Cashier cashier2 = new Cashier();
        cashier1.start();
        cashier2.start();
        this.statisticMaker = new StatisticMaker();
        this.statisticMaker.setDaemon(true);
        this.statisticMaker.start();
    }

    private void initCases() {
        this.cases = new BlockingQueue[NUMBER_OF_CASES];
        for (int i = 0; i < NUMBER_OF_CASES; i++) {
            this.cases[i] = new ArrayBlockingQueue<>(10);
        }
    }

    private void initColumns() {
        this.columns = new BlockingQueue[NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            this.columns[i] = new ArrayBlockingQueue<>(10);
        }
    }

    public synchronized static GasStation getInstance() {
        return INSTANCE;
    }

    public void addCarToColumn(Car car) throws InterruptedException {
        int columnId = new Random().nextInt(this.columns.length);
        System.out.println("Car arrived to column " + columnId);
        car.getOwner().setColumnId(columnId);
        this.columns[columnId].put(car);
    }

    public synchronized void refuel() {
        Car car = getCarFromFullColumn();
        if (car != null) {
            car.setLoaded(true);
            car.getOwner().start();
        }
    }

    private Car getCarFromFullColumn() {
        for (BlockingQueue<Car> column : this.columns) {
            if (!column.isEmpty()) {
                Car car = column.peek();
                if (car != null && !car.isLoaded()) {
                    return car;
                }
            }
        }
        return null;
    }

    public void goToCaseQueue(CarOwner carOwner) throws InterruptedException {
        BlockingQueue<CarOwner> aCase = this.cases[new Random().nextInt(this.cases.length)];
        aCase.put(carOwner);
    }

    public void serviceOwner() throws InterruptedException {
        CarOwner owner = getOwnerFromFullCaseQueue();
        if (owner != null) {
            owner.pay();
        }
    }

    private CarOwner getOwnerFromFullCaseQueue() throws InterruptedException {
        for (BlockingQueue<CarOwner> aCase : this.cases) {
            if (!aCase.isEmpty()) {
                return aCase.take();
            }
        }
        return null;
    }

    public void removeCar(int columnId) throws InterruptedException {
        int fuelQuantity = new Random().nextInt(31) + 10;
        Car car = this.columns[columnId].take();
        LocalDateTime loadingTime = LocalDateTime.now();
        saveLoading(car.getFuel(), columnId, fuelQuantity, loadingTime);
        System.out.println("Car leaves the gas station");
    }

    private void saveLoading(Car.FuelType fuel, int columnId, int fuelQuantity, LocalDateTime loadingTime) {
        if (!this.loadingLogs.containsKey(columnId)) {
            this.loadingLogs.put(columnId, new TreeSet<>((l1, l2) -> l1.getLoadingTime().compareTo(l2.getLoadingTime())));
        }
        LoadingEntity loadingEntity = new LoadingEntity();
        loadingEntity.setColumnId(columnId);
        loadingEntity.setFuelType(fuel);
        loadingEntity.setLiters(fuelQuantity);
        loadingEntity.setLoadingTime(loadingTime);
        this.loadingLogs.get(columnId).add(loadingEntity);
        try {
            DbDao.getInstance().insertEntity(loadingEntity);
            System.out.println("Loading entity is successfully added to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
