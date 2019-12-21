package module_three.test_three_exercise.library;

import java.util.Random;

public class Client extends Thread {
    public static Library library;
    private ReadingMaterial readingMaterial;

    public Client(String name, ReadingMaterial readingMaterial, Library library) {
        super(name);
        this.readingMaterial = readingMaterial;
        Client.library = library;
    }

    @Override
    public void run() {
        try {
            Random r = new Random();
            int duration = r.nextInt(10);
            library.rentReadingMaterial(this.readingMaterial, duration);
            Thread.sleep(30000);
            library.giveBackReadingMaterial(this.readingMaterial);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
