package module_two.lesson13_classes_objects.lecture;

public class Car {
    private static int counterId = 1;
    private int id;
    private String model;
    private int maxSpeed;
    private int currentSpeed;
    private String color;
    private int currentGear;
    private Person owner;
    private double price;
    private boolean isSportCar;
    private boolean isSold;

    Car(String model, boolean isSportCar, String color) {
        this.model = model;
        this.isSportCar = isSportCar;
        this.color = color;
        this.currentSpeed = 25;
        this.currentGear = 1;
        this.id = Car.counterId;
        counterId++;
    }

    String getModel() {
        return this.model;
    }

    double getPrice() {
        return this.price;
    }

    void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    int getId() {
        return this.id;
    }

    String getColor() {
        return this.color;
    }

    int getMaxSpeed() {
        return this.maxSpeed;
    }

    void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        }
    }

    void accelerate() {
        if (this.currentSpeed < this.maxSpeed) {
            this.currentSpeed++;
        } else {
            System.out.println("You've already reach max speed! Cannot accelerate more!");
        }
    }

    void changeGearUp() {
        if (1 <= this.currentGear && this.currentGear < 5) {
            this.currentGear++;
        }
    }

    void changeGearDown() {
        if (1 < this.currentGear && this.currentGear <= 5) {
            this.currentGear--;
        } else {
            System.out.println("You are now on 1st gear! Cannot change gear down!");
        }
    }

    void changeGear(int nextGear) {
        if (this.currentGear != nextGear && 1 <= nextGear && nextGear <= 5) {
            this.currentGear = nextGear;
        }
    }

    void changeColor(String newColor) {
        if (newColor != null && !newColor.isEmpty()) {
            this.color = newColor;
        }
    }

    boolean isMoreExpensive(Car car) {
        if (this != car && car != null) {
            return this.price > car.price;
        }
        return false;
    }

    double calculateCarPriceForScrap(double metalPrice) {
        if (metalPrice > 0) {
            double coef = 0.2;
            if (this.color.equals("black") || this.color.equals("white")) {
                coef += 0.05;
            }

            if (this.isSportCar) {
                coef += 0.05;
            }
            this.isSold = true;
            return metalPrice * coef;
        }
        return 0;
    }

    void changeOwner(Person owner) {
        if (owner != null && this.owner != owner) {
            this.owner = owner;
        }
    }

    boolean isSoldForScrap() {
        return this.isSold;
    }

    @Override
    public String toString() {
        return String.format("------- Car %d -------%n" +
                        "Model: %s%n" +
                        "Max speed: %d%n" +
                        "Color: %s%n" +
                        "Price: %.2f",
                this.getId(),
                this.getModel(),
                this.getMaxSpeed(),
                this.getColor(),
                this.getPrice());
    }
}
