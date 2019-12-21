package module_three.test_three_exercise.harbour.model;

import module_three.test_three_exercise.harbour.db.EntityDAO;

import java.sql.SQLException;
import java.util.Random;

public class Demo {
    static int i = 1;

    public static void main(String[] args) {

//        try {
//            EntityDAO.getInstance().createTable();
//            System.out.println("Database created successfully");
//        } catch (SQLException e) {
//            System.out.println("Error creating database " + e.getMessage());
//        }

        while (true) {
            Harbour.getInstance().addShip(new Ship(nameShip()));
        }
    }

    private static String nameShip() {
        String[] names = {"Poseidon", "Anabel", "Black Pearl", "Locki", "Ramzes", "Viktoria", "Titanic"};
        return names[new Random().nextInt(names.length)] + i;
    }
}
