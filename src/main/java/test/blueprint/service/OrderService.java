package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.dto.ProductDTO;
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
    @Lazy
    private IngredientService ingredientService;
    @Autowired
    private ProductValidator productValidator;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductSizeService productSizeService;

    public Order process(List<ProductDTO> productsDtos) {
        productsDtos.forEach(productValidator::validate);
        List<Product> products = productsDtos.stream().map(this::convert).collect(Collectors.toList());
        return save(new Order(products));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Ingredient> getIngredientsFromOrders() {
        List<Order> orders = findAll();
        return orders.stream()
                .flatMap(order -> order.getProducts().stream()
                        .flatMap(product -> product.getIngredients().stream())).collect(Collectors.toList());
    }

    private Product convert(ProductDTO productDTO) {
        ProductType productType = productTypeService.findByLabel(productDTO.getProductType());
        ProductSize productSize = productSizeService.findByLabel(productDTO.getProductSize());
        List<Ingredient> ingredients = productDTO.getIngredients() != null ? ingredientsConvertor(productDTO.getIngredients()) : null;
        return new Product(productType, productSize, ingredients);
    }

    private List<Ingredient> ingredientsConvertor(List<String> productDTOIngredients) {
        List<Ingredient> convertedIngredients = new ArrayList<>();
        for (String ingredient : productDTOIngredients) {
            convertedIngredients.add(ingredientService.findByLabel(ingredient));
        }
        return convertedIngredients;
    }
}