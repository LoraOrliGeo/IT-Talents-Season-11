package module_three.test_three_exercise.gas_station.model;

public class Worker extends Thread {
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(5000);
                GasStation.getInstance().refuel();
                System.out.println("Worker refueled a car");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
