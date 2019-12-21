package module_three.test_three_exercise.post_office_1.models;

public class Mailman extends Person {
    private int experience;
    private int deliveredPackagesCount;

    public Mailman(String firstName, String lastName, int experience) {
        super(firstName, lastName);
        this.experience = experience;
    }

    @Override
    public void run() {
        while (true) {
            try {
                PostOffice.getInstance().carryPackages();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void increaseNumberOfDeliveredPackages(int packages) {
        this.deliveredPackagesCount += packages;
    }

    public int getDeliveredPackagesCount() {
        return deliveredPackagesCount;
    }
}
