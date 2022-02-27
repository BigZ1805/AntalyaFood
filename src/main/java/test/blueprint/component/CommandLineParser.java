package test.blueprint.component;

import org.springframework.stereotype.Component;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CommandLineParser {

    private List<String[]> consoleLines() {
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

    private ProductDTO parseCommandLine(String[] args) {
        try {
            String productType = args[0];
            if (args.length == 1) {
                return new ProductDTO(productType);
            }
            String productSize = args[1];
            if (args.length == 2) return new ProductDTO(productType, productSize);
            String[] restOfIngredients = Arrays.stream(args, 2, args.length).toArray(String[]::new);
            List<String> ingredients = Stream.of(restOfIngredients).map(String::new).collect(Collectors.toList());
            return new ProductDTO(productType, productSize, ingredients);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("No such Product! Order is not correct!");
            return null;

        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println("No such Product or Order is empty! Order is not correct!");
            return null;
        }
    }

    public List<ProductDTO> parseCommandLines() {
        List<String[]> consoleLines = consoleLines();
        return consoleLines.stream().map(this::parseCommandLine).collect(Collectors.toList());
    }
}
