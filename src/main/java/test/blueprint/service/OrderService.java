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
        List<Product> productsToProcess = new ArrayList<>() {};
        for(ProductDTO product : products) {
            productValidator.validate(product);
            productsToProcess.add(convertProductArguments(product));
        }
            Order order = new Order(productsToProcess);
            save(order);
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
        List<Order> orders = findAll();
        List<Ingredient> allIngredients = new ArrayList<>();
        for (Order order : orders) {
            List<Product> products = order.getProducts();
            for (Product product: products) {
                allIngredients.addAll(product.getIngredients());
            }
        }
        return allIngredients;
    }

    private Product convertProductArguments(ProductDTO productDTO) {
        if(productDTO.getProductSize() != null) {
            if (productDTO.getIngredients() != null)
        return new Product(productTypeService.findByLabel(productDTO.getProductType()),
        productSizeService.findByLabel(productDTO.getProductSize()),
        ingredientsConvertor(productDTO.getIngredients()));
            else return new Product(productTypeService.findByLabel(productDTO.getProductType()),
                    productSizeService.findByLabel(productDTO.getProductSize()));}
        else return new Product(productTypeService.findByLabel(productDTO.getProductType()));

    }

    private List<Ingredient> ingredientsConvertor (List<String> productDTOIngredients) {
        List<Ingredient> convertedIngredients = new ArrayList<>();
        for(String ingredient : productDTOIngredients) {
            convertedIngredients.add(ingredientService.findByLabel(ingredient));
        }
        return convertedIngredients;
    }
}