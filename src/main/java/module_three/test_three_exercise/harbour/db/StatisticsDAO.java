package module_three.test_three_exercise.harbour.db;

import module_three.test_three_exercise.harbour.model.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class StatisticsDAO {

    private static StatisticsDAO INSTANCE = new StatisticsDAO();

    private StatisticsDAO() {
    }

    public static StatisticsDAO getInstance() {
        return INSTANCE;
    }

    public Map<Integer, Set<Entity>> getAllUnloadedPackagesByDock() throws SQLException {
        Map<Integer, Set<Entity>> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT dock_id, package_id, boat_name, crane_id, unloading_time FROM port_shipments;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Entity entity = new Entity();
            int dockId = result.getInt("dock_id");
            entity.setDockId(dockId);
            map.putIfAbsent(dockId, new TreeSet<>((p1, p2) -> p1.getUnloadDate().compareTo(p2.getUnloadDate())));
            entity.setPackageId(result.getInt("package_id"));
            entity.setShipName(result.getString("boat_name"));
            entity.setCraneName(result.getString("crane_id"));
            entity.setUnloadDate(result.getTimestamp("unloading_time").toLocalDateTime());
            map.get(dockId).add(entity);
        }
        return map;
    }

    public Map<Integer, Integer> getCountOfShipsPerDock() throws SQLException {
        Map<Integer, Integer> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT dock_id, COUNT(boat_name) AS ships FROM port_shipments GROUP BY dock_id;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            map.put(result.getInt("dock_id"), result.getInt("ships"));
        }
        return map;
    }

    public Map<String, Integer> getPackageCountByCrane() throws SQLException {
        Map<String, Integer> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT crane_id, COUNT(package_id) AS package_count FROM port_shipments GROUP BY crane_id;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            map.put(result.getString("crane_id"), result.getInt("package_count"));
        }
        return map;
    }

    public String getShipUnloadedMostPackages() {
        try {
            Connection connection = DBManager.getInstance().getConnection();
            String sql = "SELECT boat_name, COUNT(*) AS count FROM port_shipments  GROUP BY boat_name ORDER BY count DESC LIMIT 1;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                return result.getString("boat_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
