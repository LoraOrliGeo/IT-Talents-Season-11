package module_three.test_three_exercise.gas_station.db;

import module_three.test_three_exercise.gas_station.model.Car;
import module_three.test_three_exercise.gas_station.model.LoadingEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class StatisticsDao {

    public static Map<Integer, Set<LoadingEntity>> getAllLoadingStandings() throws SQLException {
        Map<Integer, Set<LoadingEntity>> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT kolonka_id, fuel_type, fuel_quantity, loading_time FROM station_loadings;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            LoadingEntity entity = new LoadingEntity();
            entity.setColumnId(result.getInt("kolonka_id"));
            entity.setFuelType(Car.FuelType.valueOf(result.getString("fuel_type")));
            entity.setLiters(result.getInt("fuel_quantity"));
            entity.setLoadingTime(result.getTimestamp("loading_time").toLocalDateTime());

            map.putIfAbsent(entity.getColumnId(), new TreeSet<>((s1, s2) -> s1.getLoadingTime().compareTo(s2.getLoadingTime())));
            map.get(entity.getColumnId()).add(entity);
        }
        return map;
    }

    public static Map<Integer, Integer> getNumberOfCarsPerColumn() throws SQLException {
        Map<Integer, Integer> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT kolonka_id, COUNT(*) AS total_cars FROM station_loadings GROUP BY kolonka_id;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            map.put(result.getInt("kolonka_id"), result.getInt("total_cars"));
        }
        return map;
    }

    public static Map<String, Integer> getTotalLitersPerFuelType() throws SQLException {
        Map<String, Integer> map = new TreeMap<>();
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT fuel_type, SUM(fuel_quantity) AS liters FROM station_loadings GROUP BY fuel_type;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            map.put(result.getString("fuel_type"), result.getInt("liters"));
        }
        return map;
    }
}
