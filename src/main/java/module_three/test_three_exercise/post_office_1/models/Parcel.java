package module_three.test_three_exercise.post_office_1.models;

public class Parcel extends Package {
    private double width;
    private double height;
    private double length;
    private boolean isFragile;
    private boolean isOversize;

    public Parcel(Citizen sender, Citizen receiver, double width, double height, double length, boolean isFragile) {
        super(sender, receiver);
        this.width = width;
        this.height = height;
        this.length = length;
        this.tax = calculateTax();
        this.isFragile = isFragile;
    }

    private double calculateTax() {
        double tax = 2;
        if (this.height > 60 || this.width > 60 || this.length > 60) {
            this.isOversize = true;
            tax *= 1.5;
        }

        if (isFragile) {
            tax *= 1.5;
        }
        return tax;
    }

    @Override
    public int getTimeToDeliver() {
        return 15;
    }

    @Override
    public boolean isLetter() {
        return false;
    }

    @Override
    public boolean isFragile() {
        return isFragile;
    }

    @Override
    public boolean isOversize() {
        return this.isOversize;
    }
}
