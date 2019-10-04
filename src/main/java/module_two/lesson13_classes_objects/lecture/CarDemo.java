package module_two.lesson13_classes_objects.lecture;

public class CarDemo {
    public static void main(String[] args) {

        Car car1 = new Car("BMW", false, "black");
        Person person = new Person("Lori", 1234567890, false);

        Car car2 = new Car("Moskvich", false, "pink");

        car1.setPrice(1250.63);
        car2.setPrice(253.05);
//        System.out.println(car1.isMoreExpensive(car2));
//
//        System.out.println("Price for scrap: " + car1.calculateCarPriceForScrap(22.50));
//
        person.setMoney(1500);
//        person.buyCar(car1);
//        System.out.println(String.format("Money after sold car: %.2f%n", person.sellCarForScrap()));

        //test car shop
        car1.setMaxSpeed(220);
        car2.setMaxSpeed(100);

        CarShop shop = new CarShop(3);
        shop.addCar(car1);
        shop.addCar(car2);

        Car car3 = new Car("BMW", true, "blue");
        car3.setPrice(1369.78);
        car3.setMaxSpeed(300);
        shop.addCar(car3);

//        shop.showAllCarsInTheShop();

        shop.sellNextCar(person);

        System.out.println("Next car:\n" + shop.getNextCar().toString());

        System.out.println("My car: \n" + person.getCar().toString());
    }
}
