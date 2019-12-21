package module_three.test_three_exercise.library;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {

        Library library = new Library();

        ReadingMaterial book = new Book("Book1", "Asd", "L.Geo", LocalDate.now(), Book.Genre.MYSTERY);
        ReadingMaterial book2 = new Book("Book2", "Asd", "L.Geo", LocalDate.now(), Book.Genre.HORROR);
        ReadingMaterial magazine = new Magazine("Magazine1", "Abv", LocalDate.now(), Magazine.Category.FASHION);
        ReadingMaterial textBook = new TextBook("TextBook1", "Svetlina", "A.Z", LocalDate.now(), TextBook.Subject.HISTORY);
        library.addReadingMaterial(book);
        library.addReadingMaterial(magazine);
        library.addReadingMaterial(textBook);

        new Client("Pesho", book, library).start();
        new Client("Tosho", book2, library).start();
        new Client("Gosho", magazine, library).start();
        new Client("Mimi", textBook, library).start();
    }
}
