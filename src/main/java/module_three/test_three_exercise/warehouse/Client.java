package module_three.test_three_exercise.warehouse;

import module_three.test_three_exercise.warehouse.products.IKind;

import java.util.Random;

public class Client extends Thread {
    private Store store;

    public Client(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                IKind product = store.getRandomProduct();
                int quantity = new Random().nextInt(4) + 1;
                store.sell(product, quantity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
