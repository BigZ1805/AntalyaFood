package test.blueprint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.blueprint.entity.Ingredient;
import test.blueprint.service.IngredientService;
import test.blueprint.service.OrderService;

import java.util.*;


@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private OrderService orderService;

    private static Logger LOG = LoggerFactory
            .getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(ConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) throws Exception {
//        List<String[]> consoleLines = consoleLines();
        LOG.info("{}", ingredientService.findAll());


//        Ingredient newIngredient = ingredientService.create(new Ingredient("BIG_BUN"));
//
//        LOG.info("{}",newIngredient);
        ingredientService.populateIngredientList();

        orderService.orderProcess();
        LOG.info(orderService.orderProcess().toString());
        //order service ???
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