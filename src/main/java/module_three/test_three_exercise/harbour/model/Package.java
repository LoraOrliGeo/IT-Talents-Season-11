package module_three.test_three_exercise.harbour.model;

public class Package {
    public static int uniqueId = 1;
    private int id;

    public Package() {
        this.id = uniqueId++;
    }

    public int getId() {
        return id;
    }
}
