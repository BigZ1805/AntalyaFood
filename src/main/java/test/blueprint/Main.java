package test.blueprint;


import ro.antalya.SQL.Queries;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static boolean incorrectOrder;

    /**
     * For single order use SHAORMA LARGE HOT_SAUCE
     * For multiple order use SHAORMA LARGE HOT_SAUCE
     * SHAORMA LARGE SWEET_SAUCE
     *
     * @param args SHAORMA LARGE HOT_SAUCE
     */
    public static void main(String[] args) throws SQLException {
        List<String[]> consoleLines = consoleLines();

        List<Product> products = consoleLines.stream().map(Main::create).collect(Collectors.toList());
        Order order = new Order(products);
        System.out.println(order);

        if (!incorrectOrder) Queries.insertOrder(order);

//    // UPDATE ORDER INGREDIENTS BY ORDER ID:
//        List<Ingredient> ingredientList = new ArrayList<>();
//          int id = 25;
//          ingredientList.add(Ingredient.BUN);
//          ingredientList.add(Ingredient.HOT_SAUCE);
//          ingredientList.add(Ingredient.FRIES);
//        Queries.updateRecord(id,ingredientList);

//    // SELECT PRODUCT BY ORDER ID:
//        Queries.selectProduct(23);

//    // SELECT ALL ORDERS:
//        Queries.getAllOrders();

//    // DELETE ORDER BY ORDER ID:
//        Queries.deleteOrder(16);
    }

    private static List<String[]> consoleLines() {
        List<String[]> lines = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String finished;

        do {
            finished = input.nextLine();
            if (!Objects.equals(finished, "y")) {
                lines.add(finished.split("\\s"));
            }
        } while (!finished.equalsIgnoreCase("y"));
        return lines;
    }

    public static Product create(String[] args) {
        try {
            ProductType productType = ProductType.valueOf(args[0]);
            if (args.length == 1) return new Product(productType);
            ProductSize productSize = ProductSize.valueOf(args[1]);
            if (args.length == 2) return new Product(productType, productSize);

            String[] restOfIngredients = Arrays.stream(args, 2, args.length).toArray(String[]::new);
            List<Ingredient> ingredients = Stream.of(restOfIngredients).map(Ingredient::valueOf).collect(Collectors.toList());
            return new Product(productType, productSize, ingredients);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("No such Product! Order is not correct!");
            incorrectOrder = true;
            return null;
        }
    }
}
