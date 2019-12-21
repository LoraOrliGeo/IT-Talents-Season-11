package module_three.test_three_exercise.post_office_1;

import module_three.test_three_exercise.post_office_1.db.DbDao;
import module_three.test_three_exercise.post_office_1.models.PostOffice;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) {

//        try {
//            DbDao.getInstance().createTable();
//            System.out.println("Table created successfully");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        PostOffice instance = PostOffice.getInstance();
    }
}
