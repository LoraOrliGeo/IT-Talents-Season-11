package module_three.test_three_exercise.post_office_1.models;

import java.util.Random;

public class Citizen extends Person {
    private String address;

    public Citizen(String firstName, String lastName, String address) {
        super(firstName, lastName);
        this.address = address;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                if (new Random().nextBoolean()) {
                    sentLetter(new Letter(this, this));
                } else {
                    sentPackage();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sentLetter(Letter letter) {
        PostOffice.getInstance().addLetterToBox(letter);
    }

    public void sentPackage() {
        Package p;
        if (new Random().nextBoolean()) {
            p = new Letter(this, this);
        } else {
            p = new Parcel(this, this, 67, 90, 76, new Random().nextBoolean());
        }
        PostOffice.getInstance().addToRepository(p);
    }
}
