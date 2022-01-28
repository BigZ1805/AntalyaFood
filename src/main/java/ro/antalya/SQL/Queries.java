package ro.antalya.SQL;

import test.blueprint.Ingredient;
import test.blueprint.Order;
import test.blueprint.Product;

import java.sql.*;
import java.util.List;

public class Queries {

    private static final String QUERY_SELECT_ALL_ORDERS = "select * from orders";
    private static final String INSERT_ORDERS_SQL = "INSERT INTO ORDERS" +
            "  (product,size,data,ingredients) VALUES " +
            " (?,?,?,?);";
    private static final String UPDATE_ORDERS_SQL = "update orders set ingredients = ? where id = ?;";
    private static final String SELECT_PRODUCT_QUERY = "select * from orders where id=?";
    private static final String DELETE_ORDERS_SQL = "delete from orders where id = ?;";

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

    public static void deleteOrder(int orderId) {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERS_SQL)) {
            preparedStatement.setInt(1, orderId);
            System.out.println(preparedStatement);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);

        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }


    public static void selectProduct(int orderId) {
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_QUERY)) {
            preparedStatement.setInt(1, orderId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String product = rs.getString("PRODUCT");
                System.out.println("ID: " + id + ", PRODUCT:" + product);
            }

        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
    }


    private static Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public static void insertOrder(Order order) {
        System.out.println(INSERT_ORDERS_SQL);
        for (Product product : order.getProducts()) {
            try (Connection connection = H2JDBCUtils.getConnection();

                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL)) {

                preparedStatement.setString(1, product.getProductType().toString());
                //TODO 3 No need for this try/catch. Always when you go to the DB, you have already validated the
                //data you're about to insert/update. And you already do that during the create, which is the correct
                //way to do it. Same applies for all other try/catch put with this intent
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


    public static void updateRecord(int id, List<Ingredient> ingredients) throws SQLException {
        System.out.println(UPDATE_ORDERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERS_SQL)) {
            preparedStatement.setString(1, String.valueOf(ingredients));
            preparedStatement.setInt(2, id);

            // Step 3: Execute the query or update query
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}
