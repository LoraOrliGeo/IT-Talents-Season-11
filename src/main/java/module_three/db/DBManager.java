package module_three.db;

import java.sql.*;

public class DBManager {

//    enum Fuel {
//        GAS, PETROL, DIESEL;
//
//        Fuel getValue(String string) {
//            switch (string){
//                case "gas": return GAS;
//                default: return PETROL;
//            }
//        }
//    }

    public static final String DB_HOSTNAME = "localhost";
    public static final int DB_PORT = 3306;
    public static final String DB_NAME = "hr";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, driver not found, check dependencies");
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://" +
                DB_HOSTNAME + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD)) {
            System.out.println("Successfully connection to DB");
            Statement statement = connection.createStatement();
            String sql = "SELECT first_name FROM employees;";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                System.out.println(result.getString("first_name"));
            }
        } catch (SQLException e) {
            System.out.println("Error connecting DB - " + e.getMessage());
        }

    }
}
