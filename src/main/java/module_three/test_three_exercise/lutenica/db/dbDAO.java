package module_three.test_three_exercise.lutenica.db;

import module_three.test_three_exercise.lutenica.model.Vegetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class dbDAO {

    private static dbDAO INSTANCE = new dbDAO();

    private dbDAO() {
    }

    public synchronized static dbDAO getInstance() {
        return INSTANCE;
    }

    public void createLutenicaTable() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "CREATE TABLE `lutenica` (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "date TIMESTAMP NOT NULL," +
                "quantity INT NOT NULL," +
                "baba_name VARCHAR(50) NOT NULL" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 CHARSET=utf8;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public void createNabranoTable() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "CREATE TABLE nabrano (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "moma_name VARCHAR(50) NOT NULL," +
                "veggie_name VARCHAR(50) NOT NULL," +
                "quantity INT NOT NULL" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 CHARSET=utf8;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public void createLutenicaRecord(LocalDateTime date, int quantity, String babaName) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO lutenica (date, quantity, baba_name) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setTimestamp(1, Timestamp.valueOf(date));
        ps.setInt(2, quantity);
        ps.setString(3, babaName);
        ps.executeUpdate();
        ps.close();
    }

    public void createNabranoRecord(String girlName, Vegetable vegetable, int quantity) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO nabrano (moma_name, veggie_name, qunatity) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, girlName);
        ps.setString(2, Vegetable.getVeggieTypeAsString(vegetable));
        ps.setInt(3, quantity);
    }
}
