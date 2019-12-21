package module_three.test_three_exercise.lutenica.model;

import module_three.test_three_exercise.lutenica.Pissaro;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Baba extends Person implements Runnable {

    private Map<LocalDateTime, Integer> batch;

    public Baba(String name, int age) {
        super(name, age);
        this.batch = new TreeMap<>();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * 10);
                int kg = Kitchen.getInstance().takePreparedVegetables();
                System.out.println("Baba cook " + kg + " kg lutenica");
                this.batch.put(LocalDateTime.now(), kg);
                Pissaro.insertLutenicaRecordToDB(LocalDateTime.now(), kg, this.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
