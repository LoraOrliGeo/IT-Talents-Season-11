package module_three.test_three_exercise.lutenica.model;

import module_three.test_three_exercise.lutenica.db.dbDAO;

import java.sql.SQLException;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

//        try {
//            dbDAO.getInstance().createLutenicaTable();
//            dbDAO.getInstance().createNabranoTable();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        for (int i = 0; i < 5; i++) {
            int age = new Random().nextInt(6) + 14;
            Girl girl = new Girl("Girl" + (i + 1), age);
            new Thread(girl).start();

            Boy boy = new Boy("Boy " + (i + 1), age + 3);
            new Thread(boy).start();
        }

        for (int i = 0; i < 3; i++) {
            Baba baba = new Baba("Baba " + (i + 1), 65 + i);
            new Thread(baba).start();
        }
    }
}
