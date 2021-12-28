package net.javaguides.jdbc.h2.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Update PreparedStatement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class H2UpdateExample {

    private static final String UPDATE_STOCK_SQL = "update stock set qty_in_stock = ? where ingredient_id = ?;";

    public static void main(String[] argv) throws SQLException {
        H2UpdateExample updateStatementExample = new H2UpdateExample();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_STOCK_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK_SQL)) {
            preparedStatement.setString(1, "200");
            preparedStatement.setInt(2, 3);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}