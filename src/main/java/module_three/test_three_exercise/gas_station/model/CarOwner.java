package module_three.test_three_exercise.gas_station.model;

public class CarOwner extends Thread {
    private int columnId;

    public CarOwner(String name) {
        super(name);
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    @Override
    public void run() {
        try {
            GasStation.getInstance().goToCaseQueue(this);
            System.out.println("Driver is going to a case");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pay() throws InterruptedException {
        Thread.sleep(5000);
        GasStation.getInstance().removeCar(this.getColumnId());
        System.out.println("Payment finished");
    }
}
