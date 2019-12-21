package module_three.test_three_exercise.post_office;

import java.util.Random;

public class Citizen extends Person implements Runnable {
    private String address;

    public Citizen(String firstName, String lastName, String address) {
        super(firstName, lastName);
        this.address = address;
    }

    public void addLetterToBox(Letter letter) {
        PostOffice.getInstance().getRandomPostBox().addLetter(letter);
    }

    public void addPackageToPostOffice(Citizen receiver) {
        if (new Random().nextBoolean()) {
            PostOffice.getInstance().addPackage(new Letter(this, receiver));
        } else {
            PostOffice.getInstance().addPackage(new Parcel(this, receiver, 60, 90, 60, true));
        }
    }

    @Override
    public void run() {
        while (true) {
            addLetterToBox(new Letter(this, this));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addPackageToPostOffice(this);
        }
    }
}
