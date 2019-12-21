package module_three.test_three_exercise.post_office;

public class Parcel extends Package {
    private double length;
    private double width;
    private double height;
    private boolean isFragile;

    public Parcel(Citizen sender, Citizen receiver, double length, double width, double height, boolean isFragile) {
        super(sender, receiver);
        this.length = length;
        this.width = width;
        this.height = height;
        this.isFragile = isFragile;
        this.tax = calculateTax();
    }

    private double calculateTax() {
        double tax = 2;
        if (this.length > 60 || this.width > 60 || this.height > 60) {
            tax *= 1.5;
        }

        if (isFragile) {
            tax *= 1.5;
        }
        return tax;
    }

    @Override
    public boolean isFragile() {
        return isFragile;
    }

    @Override
    protected PackageType getPackageType() {
        return PackageType.PARCEL;
    }
}
