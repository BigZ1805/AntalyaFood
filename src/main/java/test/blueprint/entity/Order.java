package test.blueprint.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date = new Date(System.currentTimeMillis());

    @OneToMany (targetEntity = Product.class, fetch = FetchType.EAGER,cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", product=" + products +
                '}';
    }
}
