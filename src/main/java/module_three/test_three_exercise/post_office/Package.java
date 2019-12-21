package module_three.test_three_exercise.post_office;

public abstract class Package {

    enum PackageType {
        LETTER, PARCEL
    }

    private Citizen sender;
    private Citizen receiver;
    protected double tax;
    private PackageType type;

    protected Package(Citizen sender, Citizen receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.type = getPackageType();
    }

    protected abstract PackageType getPackageType();

    protected abstract boolean isFragile();

    @Override
    public String toString() {
        return "Package: " + type + " with sender : " + sender + " with receiver " + receiver + " fragile: " + isFragile();
    }
}
