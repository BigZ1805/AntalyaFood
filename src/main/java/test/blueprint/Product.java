package test.blueprint;

import test.blueprint.entity.Ingredient;

import javax.persistence.*;
import java.util.List;

//@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private ProductType productType;

    @Column(columnDefinition = "TEXT")
    private ProductSize productSize;

    @OneToMany
    private List<Ingredient> ingredients;

    protected Product() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", productType=" + productType +
                ", productSize=" + productSize +
                ", ingredients=" + ingredients +
                '}';
    }
}
