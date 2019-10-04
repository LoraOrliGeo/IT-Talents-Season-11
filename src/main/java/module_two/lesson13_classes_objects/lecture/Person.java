package module_two.lesson13_classes_objects.lecture;

public class Person {
    private String name;
    private int age;
    private long personalNumber;
    private boolean isMale;
    private double weight;
    private Person[] friends;
    private double money;
    private Car car;

    Person() {
        this.age = 0;
        this.weight = 4.0;
    }

    Person(String name, long personalNumber, boolean isMale) {
        this();
        this.name = name != null && !name.isEmpty() ? name : "John Doe";
        this.personalNumber = personalNumber;
        this.isMale = isMale;
        this.friends = new Person[3];
    }

    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        }
    }

    Car getCar() {
        return this.car;
    }

    void eat() {
        System.out.println("Eating...");
    }

    void walk() {
        System.out.println(name + " is walking");
    }

    void growUp() {
        this.age++;
    }

    void drinkWater(double liters) {
        if (liters > 1) {
            System.out.println("This is too much water!!!");
        } else if (liters < 0) {
            System.out.println("There is no water to drink!");
        } else {
            System.out.println(name + " is drinking " + liters + " water.");
        }
    }

    void buyCar(Car car) {
        if (car != null && this.money - car.getPrice() >= 0) {
            this.money -= car.getPrice();
            this.car = car;
            car.changeOwner(this);
        }
    }

    double sellCarForScrap() {
        if (!this.car.isSoldForScrap()) {
            // the metal price should be passed as an argument of the method? otherwise it's magic number
            return this.money += this.car.calculateCarPriceForScrap(3.49);
        }
        return this.money;
    }
}
