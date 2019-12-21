package module_three.test_three_exercise.library;

import java.time.LocalDate;

public class Magazine extends ReadingMaterial implements Comparable<Magazine> {

    enum Category implements ReadingSeparator {
        FASHION, SCI_FI, NATURE, COSMOS
    }

    private int number;
    private Category category;

    public Magazine(String name, String publisher, LocalDate issueDate, Category category) {
        super(name, publisher, issueDate);
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public Library.ReadingMaterialType getReadingMaterialType() {
        return Library.ReadingMaterialType.MAGAZINE;
    }

    @Override
    public ReadingSeparator getSeparator() {
        return category;
    }

    @Override
    public int getMaxRentDuration() throws InvalidRentException {
        throw new InvalidRentException();
    }

    @Override
    protected double getInitialTax() {
        return 0;
    }

    @Override
    public int compareTo(Magazine o) {
        if (this.getName().compareTo(o.getName()) == 0) {
            return this.getNumber() - o.getNumber();
        }
        return this.getName().compareTo(o.getName());
    }
}
