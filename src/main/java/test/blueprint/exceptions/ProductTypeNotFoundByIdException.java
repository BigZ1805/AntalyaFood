package test.blueprint.exceptions;

public class ProductTypeNotFoundByIdException extends RuntimeException {
    public ProductTypeNotFoundByIdException(Long id) {
        super("The product type with the id: [" + id + "] does not exist!");
    }
}
