package module_three.test_three_exercise.warehouse;

public class Demo {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        Deliver deliver = new Deliver();
        Deliver.warehouse = warehouse;
        deliver.start();

        for (int i = 0; i < 3; i++) {
            Store store = new Store();
            Store.warehouse = warehouse;
            new Client(store).start();
            new Client(store).start();
            new Client(store).start();
            store.start();
        }
    }
}
