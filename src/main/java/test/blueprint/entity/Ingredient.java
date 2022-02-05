package test.blueprint.entity;

import javax.persistence.*;


@Entity
public class Ingredient {

    //TODO
    @Id
    @GeneratedValue
    private Long id;
    public String label;

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
