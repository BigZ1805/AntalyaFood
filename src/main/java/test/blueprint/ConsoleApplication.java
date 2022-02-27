package test.blueprint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.blueprint.component.CommandLineParser;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Order;
import test.blueprint.entity.Product;
import test.blueprint.entity.Stock;
import test.blueprint.service.IngredientService;
import test.blueprint.service.OrderService;
import test.blueprint.service.ProductService;
import test.blueprint.service.StockService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CommandLineParser commandLineParser;
    @Autowired
    private StockService stockService;

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(ConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {

        ingredientService.populateIngredientStock();

        List<ProductDTO> products = commandLineParser.parseCommandLines();//validate

        Order order = orderService.process(products);

//      Get ingredients from all orders
        LOG.info("{}", ingredientService.findAll());
        List<Ingredient> allIngredients = orderService.getIngredientsFromOrders();

//      Refresh last order stock
        stockService.refreshStock();

    }
}