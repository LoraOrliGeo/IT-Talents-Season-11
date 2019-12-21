package module_three.test_three_exercise.warehouse;

public class Deliver extends Thread {
    public static Warehouse warehouse;

    @Override
    public void run() {
        while (true) {
            System.out.println("Deliver started");
            warehouse.deliver();
        }
    }
}
