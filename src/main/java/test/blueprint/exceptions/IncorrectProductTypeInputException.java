package test.blueprint.exceptions;

public class IncorrectProductTypeInputException extends RuntimeException {
    public IncorrectProductTypeInputException(String productType) {
        super("This product type does not exist: " + productType);
    }
}
