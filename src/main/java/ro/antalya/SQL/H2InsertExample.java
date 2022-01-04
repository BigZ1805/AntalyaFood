package ro.antalya.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Insert PrepareStatement JDBC Example
 *
 * @author Ramesh Fadatare
 *
 */
public class H2InsertExample {
    private static final String INSERT_ORDER_SQL = "INSERT INTO order" +
            "  (id,product, data, ingredients) VALUES " +
            " (?,?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        H2InsertExample createTableExample = new H2InsertExample();
        createTableExample.insertRecord();
    }

    public void insertRecord() throws SQLException {
        System.out.println(INSERT_ORDER_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "product");
            preparedStatement.setString(3, "KG");
            preparedStatement.setString(4, "300");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
    public void insertOrder() throws SQLException {
        System.out.println(INSERT_ORDER_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "productType");
            preparedStatement.setString(3, "KG");
            preparedStatement.setString(4, "300");

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}