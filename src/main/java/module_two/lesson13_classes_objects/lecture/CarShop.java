package module_two.lesson13_classes_objects.lecture;

public class CarShop {
    private static int idxNextCar = 0;
    private Car[] cars;
    private int freeSpaces;

    CarShop(int capacity) {
        this.cars = new Car[capacity];
        this.freeSpaces = capacity;
    }

    boolean addCar(Car car) {
        if (this.freeSpaces > 0 && this.freeSpaces <= this.cars.length) {
            this.cars[this.cars.length - this.freeSpaces] = car;
            this.freeSpaces--;
            return true;
        }
        return false;
    }

    Car getNextCar() {
        // :@ ??? if -> return car, else -> ???
        if (this.cars[idxNextCar] != null) {
            return this.cars[idxNextCar++];
        }
        return null;
    }

    void sellNextCar(Person buyer) {
        if (buyer != null) {
            Car carToSell = getNextCar();
            carToSell.changeOwner(buyer);
            buyer.buyCar(carToSell);
        }
    }

    boolean removeCar(Car car) {
        // must be called after the selling car to a buyer

//        List<Car> cars = Arrays.stream(this.cars).collect(Collectors.toList());
//        return cars.remove(car);

        // or removes it by a given unique characteristic - id?
        int carId = car.getId();
        for (Car c : this.cars) {
            if (c.getId() == carId) {
                this.cars[carId - 1] = null;
                return true;
            }
        }
        return false;
    }

    void showAllCarsInTheShop() {
        if (this.cars.length > 0) {
            for (Car c : this.cars) {
                if (c != null) {
                    System.out.println(c.toString());
                }
            }
        } else {
            System.out.println("There aren't any cars in the shop!");
        }
    }
}
