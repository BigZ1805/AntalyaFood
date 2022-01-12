package test.blueprint;

import java.util.List;


public class Product {
    private final ProductType productType;
    private ProductSize productSize;
    private List<Ingredient> ingredients;

    public Product(ProductType productType, ProductSize productSize, List<Ingredient> ingredients) {
        this.productType = productType;
        this.productSize = productSize;
        this.ingredients = ingredients;
    }

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public Product(ProductType productType, ProductSize productSize) {
        this.productType = productType;
        this.productSize = productSize;
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
