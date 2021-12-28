package net.javaguides.jdbc.h2.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create Statement JDBC Example
 * @author Ramesh Fadatare
 *
 */
public class H2CreateExample {

    private static final String createTableSQL = "drop table if exists stock;\r\n" +
            "create table stock (\r\n" +
            "  ingredient_id int primary key,\r\n" + "  ingredient_name varchar(20),\r\n" + "  unit varchar(20),\r\n" +
         "  qty_in_stock double\r\n" + "  );";

    public static void main(String[] argv) throws SQLException {
        H2CreateExample createTableExample = new H2CreateExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }
}