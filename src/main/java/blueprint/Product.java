package blueprint;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Product {
    private final ProductType productType;
    private final ProductSize productSize;
    private final List<Ingredient> ingredients;

    private Product(ProductType productType, ProductSize productSize, List<Ingredient> ingredients) {
        this.productType = productType;
        this.productSize = productSize;
        this.ingredients = ingredients;
    }

    public static Product create(String[] args) {
        ProductType productType = ProductType.valueOf(args[0]);
        ProductSize productSize = ProductSize.valueOf(args[1]);
        String[] restOfIngredients = Arrays.stream(args, 2, args.length).toArray(String[]::new);
        List<Ingredient> ingredients = Stream.of(restOfIngredients).map(Ingredient::valueOf).collect(Collectors.toList());
        return new Product(productType, productSize, ingredients);
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", productSize=" + productSize +
                ", ingredients=" + ingredients +
                '}';
    }
}
