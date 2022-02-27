package test.blueprint.domaindtos;

import java.util.List;

public class ProductDTO {

    private String productType;
    private String productSize;
    private List<String> ingredients;

    public ProductDTO(String productType) {
        this.productType = productType;
    }

    public ProductDTO(String productType, String productSize) {
        this.productType = productType;
        this.productSize = productSize;
    }

    public ProductDTO(String productType, String productSize, List<String> ingredients) {
        this.productType = productType;
        this.productSize = productSize;
        this.ingredients = ingredients;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
