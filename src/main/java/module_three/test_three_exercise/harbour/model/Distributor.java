package module_three.test_three_exercise.harbour.model;

public class Distributor extends Thread {
    private int warehouseId;

    public Distributor(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public void run() {
        while (true) {
            Harbour.getInstance().takePackageFromWarehouse(warehouseId);
        }
    }
}
