package module_three.test_three_exercise.post_office;

public class Mailman extends Person implements Runnable {
    private int experience;
    private boolean isBusy;
    private int deliverPackagesCount;

    public Mailman(String firstName, String lastName, int experience) {
        super(firstName, lastName);
        this.experience = experience;
    }

    @Override
    public void run() {
        PostOffice.getInstance().empty(this);
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void increaseDeliverPackagesCount() {
        this.deliverPackagesCount++;
    }

    public int getDeliverPackagesCount() {
        return deliverPackagesCount;
    }

    @Override
    public String toString() {
        return "Mailman{" +
                "deliverPackagesCount=" + deliverPackagesCount +
                '}';
    }
}
