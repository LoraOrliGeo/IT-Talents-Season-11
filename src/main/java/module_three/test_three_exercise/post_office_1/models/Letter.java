package module_three.test_three_exercise.post_office_1.models;

public class Letter extends Package {
    public Letter(Citizen sender, Citizen receiver) {
        super(sender, receiver);
        this.tax = 0.5;
    }

    @Override
    public int getTimeToDeliver() {
        return 10;
    }

    @Override
    public boolean isLetter() {
        return true;
    }
}
