package module_three.test_three_exercise.harbour.model;

import module_three.test_three_exercise.harbour.db.DBManager;
import module_three.test_three_exercise.harbour.db.EntityDAO;
import module_three.test_three_exercise.harbour.db.StatisticsDAO;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Harbour {
    private static final int NUMBER_OF_DOCS = 5;

    private static Harbour INSTANCE = new Harbour();
    private BlockingQueue<Ship>[] docks;
    private BlockingQueue<Package>[] warehouses;
    private Map<Integer, Entity> dairy;
    private StatisticsMaker statisticsMaker;

    private Harbour() {
        initDocs();
        this.warehouses = new BlockingQueue[2];
        this.warehouses[0] = new ArrayBlockingQueue<>(1000, true);
        this.warehouses[1] = new ArrayBlockingQueue<>(1000, true);
        Crane crane1 = new Crane("Crane 1");
        Crane crane2 = new Crane("Crane 2");
        crane1.start();
        crane2.start();
        Distributor distributor1 = new Distributor(0);
        Distributor distributor2 = new Distributor(1);
        distributor1.start();
        distributor2.start();
        this.dairy = new HashMap<>();
        this.statisticsMaker = new StatisticsMaker();
        this.statisticsMaker.setDaemon(true);
        this.statisticsMaker.start();
    }

    class StatisticsMaker extends Thread {
        private File statisticsFile = new File("C:\\Users\\Lori\\Desktop\\harbour_statistics.txt");

        @Override
        public void run() {
//            while(true) {
            try {
                statisticsFile.createNewFile();
                Thread.sleep(2400);
                printFirstStatistic();
                printSecondStatistic();
                printThirdStatistic();
                printFourthStatistic();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            }
        }

        private void printFirstStatistic() {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(statisticsFile, true))) {
                Map<Integer, Set<Entity>> x = StatisticsDAO.getInstance().getAllUnloadedPackagesByDock();
                for (Map.Entry<Integer, Set<Entity>> e : x.entrySet()) {
                    pw.println();
                    pw.println("Dock " + (e.getKey() + 1) + ":");
                    for (Entity entity : e.getValue()) {
                        pw.println("\t" + entity.toString());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void printSecondStatistic() {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(statisticsFile, true))) {
                pw.println();
                Map<Integer, Integer> x = StatisticsDAO.getInstance().getCountOfShipsPerDock();
                for (Map.Entry<Integer, Integer> e : x.entrySet()) {
                    pw.println("Dock " + (e.getKey() + 1) + ": " + e.getValue() + " ships");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void printThirdStatistic() {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(statisticsFile, true))) {
                pw.println();
                Map<String, Integer> x = StatisticsDAO.getInstance().getPackageCountByCrane();
                for (Map.Entry<String, Integer> e : x.entrySet()) {
                    pw.println(e.getKey() + ": " + e.getValue() + " packages");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void printFourthStatistic() {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(statisticsFile, true))) {
                pw.println();
                pw.println(StatisticsDAO.getInstance().getShipUnloadedMostPackages());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void initDocs() {
        docks = new BlockingQueue[NUMBER_OF_DOCS];
        for (int i = 0; i < NUMBER_OF_DOCS; i++) {
            docks[i] = new ArrayBlockingQueue<>(10, true);
        }
    }

    public synchronized static Harbour getInstance() {
        return INSTANCE;
    }

    public void addShip(Ship ship) {
        try {
            int idx = new Random().nextInt(this.docks.length);
            docks[idx].put(ship);
            System.out.println(ship.getName() + " entered a dock");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unload() {
        // invoke by Crane
        // find dock with ships
        // take the packages from this ship and put them in one of two warehouses
        try {
            Ship ship = getFullDock();
            if (ship != null) {
                List<Package> packages = ship.getPackages();
                Thread.sleep(packages.size() * 1000 * 2);
                Entity entity;
                if (new Random().nextBoolean()) {
                    for (Package p : packages) {
                        addPackageToWarehouse(p);
                        entity = new Entity();
                        entity.setShipName(ship.getName());
                        entity.setCraneName(Thread.currentThread().getName());
                        entity.setPackageId(p.getId());
                        entity.setDockId(ship.getDockId());
                        entity.setUnloadDate(LocalDateTime.now());
                        entity.setEntityId(Entity.uniqueId++);
                        this.dairy.put(entity.getEntityId(), entity);
                        try {
                            EntityDAO.getInstance().addEntity(entity);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

                System.out.println(ship.getName() + " was unloaded");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takePackageFromWarehouse(int warehouseId) {
        try {
            Thread.sleep(5000);
            this.warehouses[warehouseId].take();
            System.out.println("Distributor took packages from warehouse " + warehouseId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addPackageToWarehouse(Package p) throws InterruptedException {
        if (new Random().nextBoolean()) {
            this.warehouses[0].put(p);
            System.out.println("A package was added to warehouse 1");
        } else {
            this.warehouses[1].put(p);
            System.out.println("A package was added to warehouse 2");
        }
    }

    private Ship getFullDock() {
        BlockingQueue<Ship>[] blockingQueues = this.docks;
        for (int i = 0; i < blockingQueues.length; i++) {
            BlockingQueue<Ship> dock = blockingQueues[i];
            if (!dock.isEmpty()) {
                try {
                    Ship ship = dock.take();
                    ship.setDockId(i);
                    return ship;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
