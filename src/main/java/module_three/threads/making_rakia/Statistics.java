package module_three.threads.making_rakia;

public class Statistics extends Thread {
    @Override
    public void run() {
        while(true){
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Person.distillery.printStatistics();
        }
    }
}
