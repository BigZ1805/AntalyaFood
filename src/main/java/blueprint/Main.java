package blueprint;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    /**
     *  For single order use SHAORMA LARGE HOT_SAUCE
     *  For multiple order use SHAORMA LARGE HOT_SAUCE
     *                          SHAORMA LARGE SWEET_SAUCE
     *
     * @param args SHAORMA LARGE HOT_SAUCE
     */
    public static void main(String[] args) {
        List<String[]> consoleLines = consoleLines();

        List<Product> products = consoleLines.stream().map(Product::create).collect(Collectors.toList());
        Order order = new Order(products);

        System.out.println(order);
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
}
