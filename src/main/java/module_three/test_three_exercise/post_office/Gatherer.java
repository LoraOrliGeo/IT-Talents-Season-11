package module_three.test_three_exercise.post_office;

public class Gatherer extends Mailman implements Runnable{

    public Gatherer(String firstName, String lastName, int experience) {
        super(firstName, lastName, experience);
    }

    @Override
    public void run() {
        while(true){
            PostOffice.getInstance().takeLettersFromBoxes();
        }
    }
}
