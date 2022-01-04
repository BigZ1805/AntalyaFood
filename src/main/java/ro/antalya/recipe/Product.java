package ro.antalya.recipe;

import org.h2.util.StringUtils;
import ro.antalya.SQL.*;
import java.sql.*;
import java.util.*;

public class Product {

    H2SelectExample selectIngredientInstance = new H2SelectExample();

    private static final String INSERT_ORDERS_SQL = "INSERT INTO ORDERS" +
            "  (product,size,data,ingredients) VALUES " +
            " (?,?,?,?);";

    public List<String> ingredients;

    Scanner scanner = new Scanner(System.in);

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    int count = 0;
    int maxTries = 3;

    private void log(String message) {
        System.out.println(message);
    }

    public Product() throws SQLException {
        ingredients = new ArrayList<>();
        getProduct(scanner);
    }

    String productType;
    String dimension;

    public void getProduct(Scanner scanner) throws SQLException {
        log("What product would you like? ***SHAORMA/KEBAB/SANDWICH***");
        productType = scanner.next();
        if (productType.equals("SHAORMA")) {
            getDimension(scanner);
            getMeat(scanner);
            getSpiciness(scanner);
            getRestOfIngredients(scanner);
        } else if (productType.equals("KEBAB")) {
            ingredients.add("CHIFLA_KEBAB");
            getMeat(scanner);
            getSpiciness(scanner);
            getRestOfIngredients(scanner);

        } else if (productType.equals("SANDWICH")) {
            ingredients.add("CHIFLA_SANDWICH");
            getMeat(scanner);
            getSpiciness(scanner);
            getRestOfIngredients(scanner);
        } else {
            log("There is no such product! Try again!");
            getProduct(scanner);
        }
    }

    public void getDimension(Scanner scanner) {
        log("What size? ***SMALL/BIG***");
        dimension = scanner.next();
        if (dimension.equals("SMALL")) {
            ingredients.add("LIPIE_MICA");
        } else if (dimension.equals("BIG")) {
            ingredients.add("LIPIE_MARE");
        } else {
            log("There is no such size! Please try again!");
            getDimension(scanner);
        }
    }

    private void getSpiciness(Scanner scanner) {
        log("Hot or not? ***TRUE/FALSE***");

        try {
            boolean hot = scanner.nextBoolean();
            if (hot) {
                log("Hot it is!");
                ingredients.add("SOS_IUTE");
            } else {
                log("Not hot!");
                ingredients.add("KETCHUP_DULCE");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Please state TRUE or FALSE! Try again!");
            throw ex;
        }
    }


    private void getMeat(Scanner scanner) {
        log("What meat? ***CHICKEN/BEEF/MIX***");
        String meat = scanner.next();
        switch (meat) {
            case "CHICKEN":
                ingredients.add("CARNE_PUI");
                break;
            case "BEEF":
                ingredients.add("CARNE_VITA");
                break;
            case "MIX":
                ingredients.add("CARNE_PUI");
                ingredients.add("CARNE_VITA");
                ingredients.add("CARNE_PORC");
                break;
            default: {
                log("There is no such meat! Please try again!");
                getMeat(scanner);
            }
        }

    }

    private void getRestOfIngredients(Scanner scanner) throws SQLException {
        log("Please select the rest of ingredients! ***Separated by comma [value1,value2,etc.]***");
        log("Possible ingredients are: CEAPA,ROSII,SOS_USTUROI,SOS_TZATZIKI,CARTOFI_PRAJITI,SALATA_VARZA,CASTRAVETI_MURATI");
        String restOfIngredients = scanner.next();
        List<String> ingredientList = Arrays.asList(restOfIngredients.split(","));

        for (int i = 0; i < ingredientList.size(); i++) {
            if (StringUtils.isNullOrEmpty(selectIngredientInstance.selectIngredient(ingredientList.get(i)))) {
                System.out.println("There is no such ingredient: "+ingredientList.get(i) +"! It will not be added to the list!");
            }
            else {
                ingredients.add(ingredientList.get(i));
            System.out.println(ingredientList.get(i) + " was added to the final ingredient list!");
            }

        }
        System.out.println("The final list of ingredients is: " + ingredients);
        insertOrder();
    }


    public void insertOrder() throws SQLException {
        System.out.println(INSERT_ORDERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL)) {
            preparedStatement.setString(1, productType);
            preparedStatement.setString(2, dimension);
            preparedStatement.setTimestamp(3, timestamp);
            preparedStatement.setString(4, ingredients.toString());

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



