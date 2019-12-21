package module_three.design_patterns.builder;

public class Demo {
    public static void main(String[] args) {

        Car car = new Car().withFancyRims(true);
        car.withLightColor("blue");

        Car anotherCar = new Car().withElectricCharger();

    }
}
