package module_three.test_three_exercise.lutenica;

import module_three.test_three_exercise.lutenica.db.dbDAO;
import module_three.test_three_exercise.lutenica.model.Vegetable;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Pissaro extends Thread {

    public static void insertLutenicaRecordToDB(LocalDateTime date, int quantity, String babaName){
        // invoke when lutenica is ready (from baba)
        try {
            dbDAO.getInstance().createLutenicaRecord(date, quantity, babaName);
            System.out.println("Lutenica record was added to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNabranoRecord(String girlName, Vegetable vegetable, int quantity){
        // invoke when girl add vegetable to the besket in hut
        try{
            dbDAO.getInstance().createNabranoRecord(girlName, vegetable, quantity);
            System.out.println("Nabrano record was added to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true){

        }
    }
}
