package module_three.test_three_exercise.test_three.models.garnish;

public class NotEnoughSpaceException extends Exception {
    public NotEnoughSpaceException() {
        super("There is not enough space in garnish pot!");
    }
}
