package test.blueprint;

import org.springframework.beans.factory.annotation.Autowired;
import test.blueprint.entity.Ingredient;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Service
public class OrderService {

    /**
     * For single order use SHAORMA LARGE HOT_SAUCE
     * For multiple order use SHAORMA LARGE HOT_SAUCE
     * SHAORMA LARGE SWEET_SAUCE
     *
     * @param args SHAORMA LARGE HOT_SAUCE
     */

//    public final OrderRepository orderRepository;

//    @Autowired
//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

//    public static void main(String[] args) {
//
//        List<String[]> consoleLines = consoleLines();
//
//        List<Product> products = consoleLines.stream().map(OrderService::create).collect(Collectors.toList());
//
//        if (!products.contains(null) && !products.isEmpty()) {
//            Order order = new Order(products);
////          orderRepository.save(order);
//            System.out.println(order);
//        } else {
//            System.out.println("Order is incorrect!");
//
//        }
//    }

//    private static List<String[]> consoleLines() {
//        List<String[]> lines = new ArrayList<>();
//        Scanner input = new Scanner(System.in);
//        String finished;
//
//        do {
//            finished = input.nextLine();
//            if (!Objects.equals(finished, "y")) {
//                lines.add(finished.split("\\s"));
//            }
//        } while (!finished.equalsIgnoreCase("y"));
//        return lines;
//    }

//    public static Product create(String[] args) {
//        try {
//            ProductType productType = ProductType.valueOf(args[0]);
//            if (args.length == 1) return new Product(productType);
//            ProductSize productSize = ProductSize.valueOf(args[1]);
//            if (args.length == 2) return new Product(productType, productSize);
//
//            String[] restOfIngredients = Arrays.stream(args, 2, args.length).toArray(String[]::new);
//            List<Ingredient> ingredients = Stream.of(restOfIngredients).map(Ingredient::valueOf).collect(Collectors.toList());
//            return new Product(productType, productSize, ingredients);
//
//        } catch (IllegalArgumentException illegalArgumentException) {
//            System.out.println("No such Product! Order is not correct!");
//            return null;
//
//        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
//            System.out.println("No such Product or Order is empty! Order is not correct!");
//            return null;
//        }
//    }
}

/**
 * TODO This is the next level upgrade, but first fix the 3 TODOs above and after you can move on to this one
 * <p>
 * 1. Add spring-boot & spring-data dependency to the project. I don't want to write manual queries, i want to do them
 * spring-data style (or ORM - Object Relational Mapping). You need to familiarize with Spring Boot, Spring Data, Hibernate
 * JPA (Java persistence api)
 * <p>
 * 2. Add a Stock functionality when you Order. After an Order is processed i should be able to see how much Ingredients
 * i have consumed. Example: an order like SHAORMA LARGE HOT_SAUCE should need 1 LARGE WRAP, 1 HOT_SAUCE.
 * The Stock should have quantities of each ingredient (size included, LARGE WRAP, SMALL WRAP are 2 different ingredients)
 * The Stock should decrease in quantity after each order.
 */