package module_three.test_three_exercise.harbour.db;

import module_three.test_three_exercise.harbour.model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class EntityDAO {

    private static EntityDAO INSTANCE = new EntityDAO();

    private EntityDAO() {
    }

    public static EntityDAO getInstance() {
        return INSTANCE;
    }

    public void createTable() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "CREATE TABLE port_shipments (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "boat_name VARCHAR(50) NOT NULL," +
                "dock_id INT NOT NULL," +
                "crane_id VARCHAR(10) NOT NULL," +
                "unloading_time TIMESTAMP NOT NULL," +
                "package_id INT NOT NULL" +
                ") ENGINE=InnoDB AUTO_INCREMENT=0 CHARSET=utf8";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public void addEntity(Entity entity) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO port_shipments (boat_name, dock_id, crane_id, unloading_time, package_id)" +
                "VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getShipName());
        ps.setInt(2, entity.getDockId());
        ps.setString(3, entity.getCraneName());
        ps.setTimestamp(4, Timestamp.valueOf(entity.getUnloadDate()));
        ps.setInt(5, entity.getPackageId());
        ps.executeUpdate();
        ps.close();
    }
}
