package module_three.test_three_exercise.library;

import java.time.LocalDate;

public class Book extends ReadingMaterial implements Comparable<Book> {

    private static final int MAX_RENT_DURATION = 300; // seconds
    private static final int INITIAL_TAX_VALUE = 2;

    enum Genre implements ReadingSeparator {
        LOVE, HORROR, SCI_FI, MYSTERY
    }

    private String author;
    private Genre genre;

    public Book(String name, String publisher, String author, LocalDate issueDate, Genre genre) {
        super(name, publisher, issueDate);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public Library.ReadingMaterialType getReadingMaterialType() {
        return Library.ReadingMaterialType.BOOK;
    }

    @Override
    public ReadingSeparator getSeparator() {
        return genre;
    }

    protected Book(String name, String publisher, LocalDate issueDate) {
        super(name, publisher, issueDate);
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
    public int compareTo(Book o) {
        return o.getIssueDate().compareTo(this.getIssueDate());
    }
}
