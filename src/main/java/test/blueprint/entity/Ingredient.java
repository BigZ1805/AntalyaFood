package test.blueprint.entity;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String label;
    private Double usedQuantity;
    private String unit;

    public Ingredient() {    }

    public Ingredient(String label) {
        this.label = label;
    }

    public Ingredient(String label, Double usedQuantity, String unit) {
        this.label = label;
        this.usedQuantity = usedQuantity;
        this.unit = unit;
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

    public Double getUsedQuantity() {
        return usedQuantity;
    }

    public void setUsedQuantity(Double usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", usedQuantity=" + usedQuantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
