package test.blueprint.entity;

import com.sun.istack.NotNull;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Provider;
import org.springframework.lang.Nullable;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = ProductType.class, cascade = CascadeType.ALL)
    @NotNull
    private ProductType productType;

    @OneToOne(targetEntity = ProductSize.class, cascade = CascadeType.ALL)
    @Nullable
    private ProductSize productSize;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    public Product() {    }

    public Product(ProductType productType, ProductSize productSize, List<Ingredient> ingredients) {
        this.productType = productType;
        this.productSize = productSize;
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
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

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
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
