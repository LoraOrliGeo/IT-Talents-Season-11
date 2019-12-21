package module_three.test_three_exercise.test_three;

import module_three.test_three_exercise.test_three.models.Client;
import module_three.test_three_exercise.test_three.models.StreetGrill;

public class Demo {
    public static void main(String[] args) {

        StreetGrill streetGrill = StreetGrill.getInstance();

        Client client = new Client();
        client.start();

    }
}
