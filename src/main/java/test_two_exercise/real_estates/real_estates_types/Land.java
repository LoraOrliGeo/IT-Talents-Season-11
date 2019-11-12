package test_two_exercise.real_estates.real_estates_types;

public class Land extends RealEstate {
    private boolean inRegulation;

    public Land(String description, String address, double price, String type, double area, boolean inRegulation) {
        super(description, address, price, type, area);
        this.inRegulation = inRegulation;
    }

    public boolean isInRegulation() {
        return inRegulation;
    }

    public void setInRegulation(boolean inRegulation) {
        this.inRegulation = inRegulation;
    }

    @Override
    protected String[] getRealEstateTypes() {
        return new String[]{"нива", "поляна", "гора"};
    }

    @Override
    protected int getMinRange() {
        return 30000;
    }

    @Override
    protected int getMaxRange() {
        return 85000;
    }
}
