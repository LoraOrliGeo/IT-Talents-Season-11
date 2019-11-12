package test_two_exercise.real_estates.real_estates_types;

public class House extends Building {
    private int parkingSlots;
    private double yardArea;

    public House(String description, String address, double price, String type,
                 double area, String constructionType, int parkingSlots, double yardArea) {
        super(description, address, price, type, area, constructionType);
        setParkingSlots(parkingSlots);
        setYardArea(yardArea);
    }

    public int getParkingSlots() {
        return parkingSlots;
    }

    public double getYardArea() {
        return yardArea;
    }

    private void setParkingSlots(int parkingSlots) {
        if (parkingSlots >= 0) {
            this.parkingSlots = parkingSlots;
        }
    }

    private void setYardArea(double yardArea) {
        if (yardArea >= 0) {
            this.yardArea = yardArea;
        }
    }

    @Override
    protected String[] getRealEstateTypes() {
        return new String[]{"етаж от къща", "цяла къща"};
    }

    @Override
    protected int getMinRange() {
        return 50000;
    }

    @Override
    protected int getMaxRange() {
        return 80000;
    }
}
