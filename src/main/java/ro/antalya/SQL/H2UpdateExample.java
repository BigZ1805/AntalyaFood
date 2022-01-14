package ro.antalya.SQL;

import test.blueprint.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Update PreparedStatement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class H2UpdateExample {

    private static final String UPDATE_ORDERS_SQL = "update orders set ingredients = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        H2UpdateExample updateStatementExample = new H2UpdateExample();
//        updateStatementExample.updateRecord();
    }

    public void updateRecord(List<Ingredient> ingredients) throws SQLException {
        System.out.println(UPDATE_ORDERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERS_SQL)) {
            preparedStatement.setString(1, String.valueOf(ingredients));
            preparedStatement.setInt(2, 25);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}