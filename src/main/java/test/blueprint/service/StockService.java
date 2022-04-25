package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Order;
import test.blueprint.entity.Product;
import test.blueprint.entity.Stock;
import test.blueprint.repository.StockRepository;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderService orderService;

    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    public void refreshStock() {
        List<Order> orders = orderService.findAll().stream().sorted(Comparator.comparingLong(Order::getId).reversed()).collect(Collectors.toList());
        Order lastOrder = orders.get(0);
        List<Product> lastOrderProducts = lastOrder.getProducts();
        for(Product product: lastOrderProducts) {
            List<Ingredient> lastOrderIngredients = product.getIngredients();
            for(Ingredient ingredient: lastOrderIngredients) {
                Stock lastOrderStock = stockRepository.findByIngredientId(ingredient.getId());
                lastOrderStock.setQuantity(lastOrderStock.getQuantity()- ingredient.getUsedQuantity());
                save(lastOrderStock);
            }
        }
    }
}
