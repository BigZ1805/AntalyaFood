package test.blueprint.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Stock;
import test.blueprint.repository.IngredientRepository;
import test.blueprint.repository.ProductSizeRepository;
import test.blueprint.repository.ProductTypeRepository;
import test.blueprint.repository.StockRepository;

import java.util.List;


@Configuration
public class LoadDatabase {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;


    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    public List<String> productTypeList = List.of("SHAORMA", "KEBAB", "PEPSI", "FANTA");
    public List<String> productSizeList = List.of("LARGE", "SMALL");
    public List<String> ingredientList = List.of("BIG_BUN", "SMALL_BUN", "BIG_WRAP","SMALL_WRAP","FRIES", "CABBAGE", "HOT_SAUCE", "SWEET_SAUCE");

    @Bean
    public void initDatabase() {
            log.info("Preloading product types...");
            for(String label: productTypeList) {
                productTypeRepository.save(new ProductType(label));
            }

            log.info("Preloading product sizes...");
            for(String label: productSizeList) {
                productSizeRepository.save(new ProductSize(label));
            }

            log.info("Preloading ingredients...");
            Ingredient newIngredient = new Ingredient();
            for(String label: ingredientList) {
                newIngredient = ingredientRepository.save(new Ingredient(label, 1d , "PCS"));
                stockRepository.save(new Stock(100d, newIngredient));
            }
            Ingredient updateIngredient = ingredientRepository.findById(5L).get();
            updateIngredient.setUsedQuantity(0.1d);
            updateIngredient.setUnit("KG");
            ingredientRepository.save(updateIngredient);

            Ingredient updateIngredient2 = ingredientRepository.findById(6L).get();
            updateIngredient2.setUsedQuantity(0.1d);
            updateIngredient2.setUnit("KG");
            ingredientRepository.save(updateIngredient2);

            Ingredient updateIngredient3 = ingredientRepository.findById(7L).get();
            updateIngredient3.setUsedQuantity(0.025d);
            updateIngredient3.setUnit("Liter");
            ingredientRepository.save(updateIngredient3);

            Ingredient updateIngredient4 = ingredientRepository.findById(8L).get();
            updateIngredient4.setUsedQuantity(0.025d);
            updateIngredient4.setUnit("Liter");
            ingredientRepository.save(updateIngredient4);
            log.info("Database loaded.");
        };
    }

