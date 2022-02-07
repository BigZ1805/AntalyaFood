package test.blueprint.entity;

import javax.persistence.*;
import java.util.function.Function;


@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    public String label;

    @ManyToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Ingredient() {
    }

    public Ingredient(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
