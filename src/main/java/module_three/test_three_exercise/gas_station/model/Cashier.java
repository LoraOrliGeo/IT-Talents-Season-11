package module_three.test_three_exercise.gas_station.model;

public class Cashier extends Thread {
    @Override
    public void run() {
        while(true){
            try {
                GasStation.getInstance().serviceOwner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
