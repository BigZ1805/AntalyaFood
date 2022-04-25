package test.blueprint;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.blueprint.component.CommandLineParser;
import test.blueprint.component.LoadDatabase;
import test.blueprint.dto.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Order;
import test.blueprint.exceptions.IncorrectProductSizeInputException;
import test.blueprint.exceptions.IncorrectProductTypeInputException;
import test.blueprint.service.IngredientService;
import test.blueprint.service.OrderService;
import test.blueprint.service.ProductService;
import test.blueprint.service.StockService;

import java.util.List;


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
    @Autowired
    private LoadDatabase loadDatabase;

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(ConsoleApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        loadDatabase.initDatabase();
        List<ProductDTO> products = commandLineParser.parseCommandLines();//validate

        try {
            Order order = orderService.process(products);
        } catch (RuntimeException e) {
            LOG.error(e.getMessage());
        }

        //exception.getMessage()

//      Get ingredients from all orders
//        LOG.info("{}", ingredientService.findAll());
//        List<Ingredient> allIngredients = orderService.getIngredientsFromOrders();
//        LOG.info("{}", allIngredients);

//      Refresh last order stock
        stockService.refreshStock();

    }
}