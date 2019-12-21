package module_three.test_three_exercise.library;

public class InvalidRentException extends Exception {
    public InvalidRentException() {
        super("Sorry, your are not allowed to rent this reading material!");
    }
}
