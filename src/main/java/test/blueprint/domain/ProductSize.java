package test.blueprint.domain;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private String label;

    public ProductSize() {
    }

    public ProductSize(String label) {
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
        return "ProductSize{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
