package module_three.test_three_exercise.test_three.db;

import module_three.test_three_exercise.test_three.models.Order;
import module_three.test_three_exercise.test_three.models.breads.Bread;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBDao {


    private static DBDao INSTANCE = new DBDao();

    private DBDao() {
    }

    public synchronized static DBDao getInstance() {
        return INSTANCE;
    }

    public void insertOrder(Order order) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "INSERT INTO sales (shop_id, bread_type_id, meat_type_id, garnish_type_id, date_created" +
                "VALUES (?,?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, 3);
        int breadId = order.getBreadType().equals(Bread.BreadType.WHITE) ? 1 : 2;
        ps.setInt(2, breadId);
        int meatId = getMeatId(order);
        ps.setInt(3, meatId);
        int garnishId = getGarnishId(order);
        ps.setInt(4, garnishId);
        ps.setTimestamp(5, Timestamp.valueOf(order.getOrderTime()));

        ps.executeQuery();
        ps.close();
    }

    private int getGarnishId(Order order) {
        switch (order.getGarnishType()) {
            case RUSSIAN:
                return 1;
            case LUTENICA:
                return 2;
            case SNEJANKA:
                return 3;
            case CABBAGE_CARROT:
                return 4;
            default:
                return 5;
        }
    }

    private int getMeatId(Order order) {
        switch (order.getMeatType()) {
            case MEATBALL:
                return 1;
            case PLESKAVICA:
                return 2;
            default:
                return 3;
        }
    }

    public int getSumOfOrders() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT shop_id, SUM(shop_id) AS total_orders FROM sales GROUP BY shop_id HAVING shop_id = 3;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        int totalOrders = 0;
        while (result.next()) {
            totalOrders += result.getInt("total_orders");
        }
        ps.close();
        return totalOrders;
    }

    public String getMostSellMeatType() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT m.name AS meat, COUNT(meat_type_id) AS count FROM sales AS s\n" +
                "JOIN meat_types AS m ON (s.meat_type_id = m.id)\n" +
                "WHERE shop_id = 4 GROUP BY shop_id ORDER BY count;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        String res = "";
        while (result.next()) {
            res += "Most sold meat type: " + result.getString("meat");
        }
        ps.close();
        return res;
    }

    public String getShopWithHighestAmountOfWholegrainBread() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT s.name AS shop_name, COUNT(shop_id) AS wholegrain FROM sales AS a JOIN shops AS s GROUP BY a.bread_type_id HAVING a.bread_type_id = 2 \n" +
                "ORDER BY wholegrain DESC;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        String print = "";
        while (result.next()) {
            print += result.getString("shop_name" + ": " + result.getInt("wholegrain"));
        }
        ps.close();
        return print;
    }

    public void getTotalCountOfPLeskavici() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT COUNT(meat_type_id) AS total_pleskavici FROM sales WHERE meat_type_id = 2;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        System.out.println("Total count of pleskavici for all shops: " + result.getString("total_pleskavici"));
        ps.close();
    }

    public String getMostSoldGarnish() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT g.name AS name, COUNT(e.garnish_type_id) AS count FROM sales AS e\n" +
                "JOIN garnish_types AS g ON (e.garnish_type_id = g.id) GROUP BY e.garnish_type_id ORDER BY count DESC LIMIT 1;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        String res = "Most sellable garnish: " + result.getString("name") + " - " + result.getInt("count");
        ps.close();
        return res;
    }

    public String getLessSoldGarnishInMyShop() throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        String sql = "SELECT g.name AS name, COUNT(e.garnish_type_id) AS count " +
                "FROM sales AS e " +
                "JOIN garnish_types AS g ON (e.garnish_type_id = g.id) " +
                "WHERE e.shop_id = 3 " +
                "GROUP BY e.garnish_type_id  ORDER BY count LIMIT 1;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();

        String res = "Less sold garnish: " + result.getString("name");
        ps.close();
        return res;
    }
}
