package test.blueprint;

import test.blueprint.entity.Ingredient;

import javax.persistence.*;
import java.util.List;



//@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double quantity_used_in_recipe;
    private Double quantity_in_stock;

    @OneToMany
    private List<Ingredient> ingredient;

    public Stock() {
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }

    public Stock(Double quantity_used_in_recipe, Double quantity_in_stock, List<Ingredient> ingredient) {
        this.quantity_used_in_recipe = quantity_used_in_recipe;
        this.quantity_in_stock = quantity_in_stock;
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQuantity_used_in_recipe() {
        return quantity_used_in_recipe;
    }

    public void setQuantity_used_in_recipe(Double quantity_used_in_recipe) {
        this.quantity_used_in_recipe = quantity_used_in_recipe;
    }

    public Double getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(Double quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", quantity_used_in_recipe=" + quantity_used_in_recipe +
                ", quantity_in_stock=" + quantity_in_stock +
                ", ingredient=" + ingredient +
                '}';
    }
}
