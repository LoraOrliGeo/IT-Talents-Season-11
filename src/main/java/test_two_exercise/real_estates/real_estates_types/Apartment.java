package test_two_exercise.real_estates.real_estates_types;

public class Apartment extends Building {

    public Apartment(String description, String address, double price, String type, double area, String constructionType) {
        super(description, address, price, type, area, constructionType);
    }

    @Override
    protected String[] getRealEstateTypes() {
        return new String[]{"студио", "мезонет", "двустаен", "тристаен", "гарсониера"};
    }

    @Override
    protected int getMinRange() {
        return 70000;
    }

    @Override
    protected int getMaxRange() {
        return 150000;
    }
}
