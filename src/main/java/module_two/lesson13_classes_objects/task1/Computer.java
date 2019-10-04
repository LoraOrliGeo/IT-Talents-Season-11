package module_two.lesson13_classes_objects.task1;

public class Computer {
    private int year;
    private double price;
    private boolean isNotebook;
    private double hardDiskMemory;
    private double freeMemory;
    private String operationSystem;

    public Computer() {
        this.isNotebook = false;
        this.operationSystem = "Win XP";
    }

    public Computer(int year, double price, double hardDiskMemory, double freeMemory) {
        this();
        this.year = year;
        this.price = price;
        this.hardDiskMemory = hardDiskMemory;
        this.freeMemory = freeMemory;
    }

    public Computer(int year, double price, boolean isNotebook, double hardDiskMemory, double freeMemory,
                    String operationSystem) {
        this(year, price, hardDiskMemory, freeMemory);
        this.isNotebook = isNotebook;
        this.operationSystem = operationSystem;
    }

    public double getPrice() {
        return this.price;
    }

    public void changeOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void useMemory(int memory) {
        if (freeMemory >= memory) {
            freeMemory -= memory;
        } else {
            System.out.println("Not enough free memory!");
        }
    }

    public int comparePrice(Computer c) {
        if (c == null) {
            System.out.println("The second computer does not exist!");
            return 2;
        }

        if (this.getPrice() > c.getPrice()) {
            return -1;
        } else if (c.getPrice() > this.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Year: %d%nPrice: %.2f%n" +
                        "Notebook: %b%nHard Disk Memory: %.2f%n" +
                        "Free Memory: %.2f%nOperation System: %s",
                year, price, isNotebook, hardDiskMemory, freeMemory, operationSystem);
    }
}
