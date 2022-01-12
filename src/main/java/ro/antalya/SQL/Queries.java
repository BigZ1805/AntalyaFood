package ro.antalya.SQL;

import test.blueprint.Order;
import test.blueprint.Product;

import java.sql.*;

public class Queries {

    private static final String QUERY_SELECT_ALL_ORDERS = "select * from orders";

    public static void getAllOrders() {
        try (
                Connection connection = H2JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_ALL_ORDERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String product = rs.getString("product");
                String size = rs.getString("size");
                Timestamp timestamp = rs.getTimestamp("DATA");
                String ingredients = rs.getString("ingredients");
                System.out.println("ALL ORDERS:\nID: " + id + " | " +
                        "PRODUCT: " + product + " | " +
                        "SIZE: " + size + " | " +
                        "DATE: " + timestamp + " | " +
                        "INGREDIENTS: " + ingredients);
            }
        } catch (
                SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }

    private static final String SELECT_INGREDIENT_QUERY = "select * from ingredient where ingredient=?";

//    public static String selectIngredient(String selectedIngredient) {
//        try (Connection connection = H2JDBCUtils.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INGREDIENT_QUERY)) {
//            preparedStatement.setString(1, selectedIngredient);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String ingredient = rs.getString("ingredient");
//
//                return rs.toString();
//            }
//
//        } catch (SQLException e) {
//            H2JDBCUtils.printSQLException(e);
//        }
//        return null;
//    }

    private static final String INSERT_ORDERS_SQL = "INSERT INTO ORDERS" +
            "  (product,size,data,ingredients) VALUES " +
            " (?,?,?,?);";

    private static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static void insertOrder(Order order) {
        System.out.println(INSERT_ORDERS_SQL);
        for (Product product : order.getProducts()) {
            try (Connection connection = H2JDBCUtils.getConnection();

                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL)) {

                preparedStatement.setString(1, product.getProductType().toString());
                try {
                    preparedStatement.setString(2, product.getProductSize().toString());
                } catch (NullPointerException nullPointerException) {
                    preparedStatement.setString(2, null);
                }
                preparedStatement.setTimestamp(3, timestamp);
                try {
                    preparedStatement.setString(4, product.getIngredients().toString());
                } catch (NullPointerException nullPointerException) {
                    preparedStatement.setString(4, null);
                }
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                H2JDBCUtils.printSQLException(e);
            }
        }
    }
}
