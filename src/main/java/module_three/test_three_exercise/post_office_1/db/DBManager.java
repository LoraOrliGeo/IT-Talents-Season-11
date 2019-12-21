package module_three.test_three_exercise.post_office_1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String DB_HOSTNAME = "localhost";
    private static final int DB_PORT = 3306;
    private static final String SCHEMA_NAME = "post_office";
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
                    DB_HOSTNAME + ":" + DB_PORT + "/" + SCHEMA_NAME, DB_USERNAME, DB_PASSWORD);
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
