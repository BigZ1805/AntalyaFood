package test.blueprint.entity;

import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private ProductType productType;
    private ProductSize productSize;

    @ManyToOne
    private Order order;

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
