package test.blueprint.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String label;
    private Double usedQantity;
    private String unit;

    public Ingredient() {    }

    public Ingredient(String label) {
        this.label = label;
    }

    public Ingredient(String label, Double usedQantity, String unit) {
        this.label = label;
        this.usedQantity = usedQantity;
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

    public Double getUsedQantity() {
        return usedQantity;
    }

    public void setUsedQantity(Double usedQantity) {
        this.usedQantity = usedQantity;
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
                ", usedQantity=" + usedQantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
