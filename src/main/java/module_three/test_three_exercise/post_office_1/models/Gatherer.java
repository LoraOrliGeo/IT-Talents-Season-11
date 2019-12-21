package module_three.test_three_exercise.post_office_1.models;

public class Gatherer extends Mailman {
    public Gatherer(String firstName, String lastName, int experience) {
        super(firstName, lastName, experience);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000); // 2 hours
                PostOffice.getInstance().gatherLettersFromBoxes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
