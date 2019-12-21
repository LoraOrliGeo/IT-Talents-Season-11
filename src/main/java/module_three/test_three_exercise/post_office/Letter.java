package module_three.test_three_exercise.post_office;

public class Letter extends Package {

    public static final double LETTER_TAX = 0.5;

    public Letter(Citizen sender, Citizen receiver) {
        super(sender, receiver);
        this.tax = LETTER_TAX;
    }

    @Override
    protected PackageType getPackageType() {
        return PackageType.LETTER;
    }

    @Override
    protected boolean isFragile() {
        return false;
    }
}
