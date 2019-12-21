package module_three.test_three_exercise.library;

import org.json.simple.JSONObject;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Library {

    private class RentLogger {
        private LocalDateTime start;
        private LocalDateTime end;
        private String client;

        public RentLogger(LocalDateTime start, LocalDateTime end, String client) {
            this.start = start;
            this.end = end;
            this.client = client;
        }
    }

    private class Revision extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000); // 31 days
                    printAllAvailableReadingsNumber();
                    logTakenReadingMaterialsToFile();
                    logOverdueReturnReadingMaterials();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void printAllAvailableReadingsNumber() {
            int counter = 0;
            for (Map.Entry<ReadingMaterialType, Map<ReadingSeparator, TreeSet<ReadingMaterial>>> e : catalogue.entrySet()) {
                for (TreeSet<ReadingMaterial> set : e.getValue().values()) {
                    for (ReadingMaterial rm : set) {
                        if (!rm.isTaken()) {
                            counter++;
                        }
                    }
                }
            }

            System.out.println("Available reading materials count = " + counter);
        }

        private void logTakenReadingMaterialsToFile() {
            File file = new File("C:\\Users\\Lori\\ITTalents\\GitRepository\\IT" +
                    "\\src\\main\\java\\module_three\\test_three_exercise\\library\\availableReadingMaterials.txt");

            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
                List<Map.Entry<ReadingMaterial, RentLogger>> entries = new ArrayList<>();
                entries.addAll(rentLogger.entrySet());

                entries.sort(Comparator.comparing(e -> e.getValue().start));

                for (Map.Entry<ReadingMaterial, RentLogger> entry : entries) {
                    writer.println(entry.getKey().getName() + " - taken at " + entry.getValue().start + " - has to be returned at " + entry.getValue().end);
                }

                writer.println("Total taken reading materials: " + entries.size());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        private class OverdueRental {
            private ReadingMaterial rm;
            private String readerName;
            private double compensation;

            public OverdueRental(ReadingMaterial rm, String readerName, double compensation) {
                this.rm = rm;
                this.readerName = readerName;
                this.compensation = compensation;
            }
        }

        private void logOverdueReturnReadingMaterials() {
            File file = new File("C:\\Users\\Lori\\ITTalents\\GitRepository\\IT" +
                    "\\src\\main\\java\\module_three\\test_three_exercise\\library\\overdueReturnReadingMaterials.txt");

            try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
                double totalCompensation = 0;

                List<OverdueRental> overdueRentals = new ArrayList<>();

                for (Map.Entry<ReadingMaterial, RentLogger> entry : rentLogger.entrySet()) {
                    ReadingMaterial rm = entry.getKey();
                    if (entry.getValue().end.isBefore(LocalDateTime.now())) {
                        // overdue rental
                        double compensation = rm.getTax() - rm.getInitialTax();
                        totalCompensation += compensation;
                        String readerName = entry.getValue().client;

                        OverdueRental or = new OverdueRental(rm, readerName, compensation);
                        overdueRentals.add(or);
                    }
                }

                overdueRentals.sort(Comparator.comparingDouble(e -> e.compensation));

                for (OverdueRental rental : overdueRentals) {
                    // log the data as JSON
                    JSONObject obj = new JSONObject();
                    obj.put("Reader", rental.readerName);
                    obj.put("Reading Material", rental.rm.getName());
                    obj.put("Compensation", rental.compensation);

                    writer.println(obj.toJSONString());

//                    writer.println(String.format("Reader: %s, Reading Material: %s, Compensation: %f",
//                            rental.readerName, rental.rm.getName(), rental.compensation));
                }

//                obj.put("Total compensation", totalCompensation);
                writer.println("Total compensation: " + totalCompensation);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    enum ReadingMaterialType {
        BOOK, MAGAZINE, TEXTBOOK
    }

    private Map<ReadingMaterialType, Map<ReadingSeparator, TreeSet<ReadingMaterial>>> catalogue;
    private Map<ReadingMaterial, RentLogger> rentLogger;
    private Revision revision;

    public Library() {
        this.catalogue = new HashMap<>();
        this.catalogue.put(ReadingMaterialType.BOOK, new HashMap<>());
        this.catalogue.put(ReadingMaterialType.MAGAZINE, new HashMap<>());
        this.catalogue.put(ReadingMaterialType.TEXTBOOK, new HashMap<>());

        this.rentLogger = new HashMap<>();
        this.revision = new Revision();
        this.revision.setDaemon(true);
        this.revision.start();
    }

    public void addReadingMaterial(ReadingMaterial rm) {
        if (!this.catalogue.get(rm.getReadingMaterialType()).containsKey(rm.getSeparator())) {
            this.catalogue.get(rm.getReadingMaterialType()).put(rm.getSeparator(), new TreeSet<>());
        }

        this.catalogue.get(rm.getReadingMaterialType()).get(rm.getSeparator()).add(rm);
    }

    public void rentReadingMaterial(ReadingMaterial rm, int duration) {
        try {
            if (duration > rm.getMaxRentDuration()) {
                System.out.println("Sorry, the duration exceeds the max duration for this reading material.");
            } else {
                if (rm.isTaken()) {
                    System.out.println("Sorry, the reading material you looking for is taken.");
                } else {
                    rm.rentStart(duration);
                    rentLogger.put(rm,
                            new RentLogger(LocalDateTime.now(),
                                    LocalDateTime.now().plus(Duration.ofSeconds(duration)),
                                    Thread.currentThread().getName()));
                }
            }
        } catch (InvalidRentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void giveBackReadingMaterial(ReadingMaterial rm) {
        if (rm.isTaken()) {
            System.out.println("Rental tax: " + rm.getTax());
            rm.rentFinish();
            this.rentLogger.remove(rm);
        }
    }

}
