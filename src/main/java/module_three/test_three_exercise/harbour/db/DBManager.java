package module_three.test_three_exercise.harbour.db;

import java.sql.*;

public class DBManager {
    private static final String DB_HOSTNAME = "localhost";
    private static final int DB_PORT = 3306;
    private static final String DB_NAME = "harbour";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private static DBManager INSTANCE = new DBManager();

    private Connection connection;

    private DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry, driver not found, check dependencies");
        }

        connection = createConnection();
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" +
                    DB_HOSTNAME + ":" + DB_PORT + "/" + DB_NAME, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized static DBManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            return createConnection();
        }

        return connection;
    }
}
