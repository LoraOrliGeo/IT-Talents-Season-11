package module_three.test_three_exercise.post_office_1.db;

import module_three.test_three_exercise.post_office_1.models.Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DbDao {

    private static DbDao INSTANCE = new DbDao();

    private DbDao() {
    }

    public synchronized static DbDao getInstance() {
        return INSTANCE;
    }

    public void createTable() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "CREATE TABLE post_office_backup (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "package_type VARCHAR(15) NOT NULL," +
                "sender_name VARCHAR(50) NOT NULL," +
                "receiver_name VARCHAR(50) NOT NULL," +
                "fragile BOOLEAN NOT NULL," +
                "oversize BOOLEAN NOT NULL," +
                "date TIMESTAMP NOT NULL" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 CHARSET=utf8";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public void addEntity(Package p) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO post_office_backup (package_type, sender_name, receiver_name,fragile, oversize, date)" +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, p.getType());
        ps.setString(2, p.getSenderName());
        ps.setString(3, p.getReceiverName());
        ps.setBoolean(4, p.isFragile());
        ps.setBoolean(5, p.isOversize());
        ps.setTimestamp(6, Timestamp.valueOf(p.getReceivingDate().toString()));
        ps.executeUpdate();
        ps.close();
    }
}
