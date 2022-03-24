package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Order;
import test.blueprint.entity.Product;
import test.blueprint.repository.OrderRepository;
import test.blueprint.repository.ProductRepository;
import test.blueprint.validator.ProductValidator;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    /**
     * For single order use SHAORMA LARGE HOT_SAUCE
     * For multiple order use SHAORMA LARGE HOT_SAUCE
     * SHAORMA LARGE SWEET_SAUCE
     *
     * @param args SHAORMA LARGE HOT_SAUCE
     */
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private ProductValidator productValidator;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductSizeService productSizeService;

    public Order process(List<ProductDTO> products) {
        //TODO 6 lines 42 -> 46 should be splitted in 2 separate operations: one validates the DTO,
        // the other one, by using stream map wil convert from dto to entity
        List<Product> productsToProcess = new ArrayList<>();
        for (ProductDTO product : products) {
            productValidator.validate(product);
            productsToProcess.add(convertProductArguments(product));
        }
        //TODO 9 write lines 49 -> 53 as a one liner (logging can be moved to save method for example, or completely removed)
        Order order = new Order(productsToProcess);
        save(order);
        //TODO 8 no more system out, introduce logging maven dependency and replace all system.out with logger
        System.out.println(order);
        return order;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Ingredient> getIngredientsFromOrders() {
        //TODO 10 instead of 2 foreach, try stream flatmap. It's a difficult todo, you need to understand streams
        List<Order> orders = findAll();
        List<Ingredient> allIngredients = new ArrayList<>();
        for (Order order : orders) {
            List<Product> products = order.getProducts();
            for (Product product : products) {
                allIngredients.addAll(product.getIngredients());
            }
        }
        return allIngredients;
    }

    //TODO 11 insanely inefficient
    private Product convertProductArguments(ProductDTO productDTO) {
        if (productDTO.getProductSize() != null) {
            if (productDTO.getIngredients() != null)
                return new Product(productTypeService.findByLabel(productDTO.getProductType()),
                        productSizeService.findByLabel(productDTO.getProductSize()),
                        ingredientsConvertor(productDTO.getIngredients()));
            else return new Product(productTypeService.findByLabel(productDTO.getProductType()),
                    productSizeService.findByLabel(productDTO.getProductSize()));
        } else return new Product(productTypeService.findByLabel(productDTO.getProductType()));

    }

    //TODO 11 insanely inefficient
    private List<Ingredient> ingredientsConvertor(List<String> productDTOIngredients) {
        List<Ingredient> convertedIngredients = new ArrayList<>();
        for (String ingredient : productDTOIngredients) {
            convertedIngredients.add(ingredientService.findByLabel(ingredient));
        }
        return convertedIngredients;
    }
}