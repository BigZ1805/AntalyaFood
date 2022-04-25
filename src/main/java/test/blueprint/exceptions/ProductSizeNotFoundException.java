package test.blueprint.exceptions;

public class ProductSizeNotFoundException extends RuntimeException{
    public ProductSizeNotFoundException(Long id) {
        super("The product size with the id: [" + id + "] does not exist!");
    }
}
