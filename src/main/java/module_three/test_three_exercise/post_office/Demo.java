package module_three.test_three_exercise.post_office;

public class Demo {
    public static void main(String[] args) {

        PostOffice postOffice = PostOffice.getInstance();
        for (int i = 0; i < 12; i++) {
            Citizen citizen = new Citizen("Citizen " + (i + 1), "Georgiev", "Random address");
            new Thread(citizen).start();
        }

    }
}
