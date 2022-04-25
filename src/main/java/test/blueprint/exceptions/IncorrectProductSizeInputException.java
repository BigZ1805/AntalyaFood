package test.blueprint.exceptions;

public class IncorrectProductSizeInputException extends RuntimeException {
    public IncorrectProductSizeInputException(String message) {
        super(message);
    }
}
