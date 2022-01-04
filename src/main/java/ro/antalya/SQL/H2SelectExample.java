package ro.antalya.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Select PreparedStatement JDBC Example
 *
 * @author Ramesh Fadatare
 *
 */
public class H2SelectExample {
    private static final String QUERY = "select * from ingredient where ingredient=?";

    public static void main(String[] args) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
            preparedStatement.setInt(1,1);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String ingredient = rs.getString("ingredient");

                System.out.println(id + "," + ingredient);
            }
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    }
    public static final String SELECT_INGREDIENT_QUERY = "select * from ingredient where ingredient=?";
        public String  selectIngredient(String selectedIngredient) {

        // using try-with-resources to avoid closing resources (boiler plate code)

        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();

             // Step 2:Create a statement using connection object

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INGREDIENT_QUERY);) {
            preparedStatement.setString(1,selectedIngredient);
         //   System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");

                String ingredient = rs.getString("ingredient");
             //   System.out.println(id + "," + ingredient);
             //   System.out.println(rs);
                return rs.toString();
            }

        } catch (SQLException e) {
            H2JDBCUtils.printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
    return null;
    }
}