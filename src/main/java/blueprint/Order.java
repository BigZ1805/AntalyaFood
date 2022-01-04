package blueprint;

import java.util.List;

public class Order {
    private final List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public static Order create(List<Product> products) {
        return new Order(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                '}';
    }
}
