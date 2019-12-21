package module_three.test_three_exercise.gas_station.db;

import module_three.test_three_exercise.gas_station.model.LoadingEntity;

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
        String sql = "CREATE TABLE station_loadings (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "kolonka_id INT NOT NULL," +
                "fuel_type VARCHAR(50) NOT NULL," +
                "fuel_quantity INT NOT NULL," +
                "loading_time TIMESTAMP NOT NULL" +
                ") Engine=InnoDB AUTO_INCREMENT=0 CHARSET=utf8";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }

    public void insertEntity(LoadingEntity loadingEntity) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO station_loadings (kolonka_id, fuel_type, fuel_quantity, loading_time)" +
                "VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, loadingEntity.getColumnId());
        ps.setString(2, loadingEntity.getFuelType().toString());
        ps.setInt(3, loadingEntity.getLiters());
        ps.setTimestamp(4, Timestamp.valueOf(loadingEntity.getLoadingTime()));
        ps.executeUpdate();
        ps.close();
    }
}
