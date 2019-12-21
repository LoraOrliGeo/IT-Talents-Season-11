package module_three.test_three_exercise.library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;

public abstract class ReadingMaterial {

    private class Auditor extends Thread {
        private static final int PERCENT_INTEREST = 1;
        private int duration;

        public Auditor(int duration) {
            this.duration = duration;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(this.duration * 1000);
                if (isTaken()) {
                    while (true) {
                        if (isInterrupted()) {
                            return;
                        }

                        Thread.sleep(1000);
                        tax = tax + (tax * PERCENT_INTEREST / 100);
                        System.out.println("Auditor charged with " + PERCENT_INTEREST + "% interest - now the tax is " + tax);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Auditor's charging finished!");
            }
        }
    }

    private String name;
    private String publisher;
    private LocalDate issueDate;
    private Library.ReadingMaterialType type;
    private double initialTax;
    private double tax;
    private TreeMap<LocalDateTime, LocalDateTime> rentPeriod;
    private Auditor auditor;

    protected ReadingMaterial(String name, String publisher, LocalDate issueDate) {
        this.name = name;
        this.publisher = publisher;
        this.issueDate = issueDate;
        this.initialTax = getInitialTax();
        this.tax = initialTax;
        this.rentPeriod = new TreeMap<>();
    }

    public abstract Library.ReadingMaterialType getReadingMaterialType();

    public abstract ReadingSeparator getSeparator();

    public abstract int getMaxRentDuration() throws InvalidRentException;

    protected abstract double getInitialTax();

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public double getTax() {
        return tax;
    }

    public void rentStart(int duration) {
        this.auditor = new Auditor(duration);
        auditor.start();
        this.rentPeriod.put(LocalDateTime.now(), null);
    }

    public void rentFinish() {
        this.auditor.interrupt();
        this.rentPeriod.put(this.rentPeriod.lastEntry().getKey(), LocalDateTime.now());
    }

    public boolean isTaken() {
        if (this.rentPeriod.isEmpty()) {
            return false;
        }

        // if the rm is taken, the rentPeriod's value will be null
        // if the rm is not taken, the rentPeriod's value will be the date - it's been returned
        return this.rentPeriod.lastEntry().getValue() == null;
    }
}
