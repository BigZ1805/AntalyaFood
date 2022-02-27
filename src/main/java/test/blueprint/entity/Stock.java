package test.blueprint.entity;

import javax.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;

    @OneToOne(targetEntity = Ingredient.class, fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private Ingredient ingredient;

    public Stock() {
    }

    public Stock(Double quantity, Ingredient ingredient) {
        this.quantity = quantity;
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
