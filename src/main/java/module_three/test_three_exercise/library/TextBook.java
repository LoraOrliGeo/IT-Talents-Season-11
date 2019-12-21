package module_three.test_three_exercise.library;

import java.time.LocalDate;

public class TextBook extends ReadingMaterial implements Comparable<TextBook> {

    private static final int MAX_RENT_DURATION = 150; // seconds
    private static final int INITIAL_TAX_VALUE = 3;

    enum Subject implements ReadingSeparator {
        HISTORY, PROGRAMMING, CHEMISTRY, ARTS
    }

    private String author;
    private Subject subject;

    public TextBook(String name, String publisher, String author, LocalDate issueDate, Subject subject) {
        super(name, publisher, issueDate);
        this.author = author;
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public Library.ReadingMaterialType getReadingMaterialType() {
        return Library.ReadingMaterialType.TEXTBOOK;
    }

    @Override
    public ReadingSeparator getSeparator() {
        return subject;
    }

    @Override
    public int getMaxRentDuration() {
        return MAX_RENT_DURATION;
    }

    @Override
    protected double getInitialTax() {
        return INITIAL_TAX_VALUE;
    }

    @Override
    public int compareTo(TextBook o) {
        if (this.subject.compareTo(o.subject) == 0) {
            return this.getName().compareTo(o.getName());
        }
        return this.subject.compareTo(o.subject);
    }
}
