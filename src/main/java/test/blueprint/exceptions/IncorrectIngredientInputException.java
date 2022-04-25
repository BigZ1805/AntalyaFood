package test.blueprint.exceptions;

public class IncorrectIngredientInputException extends RuntimeException {
    public IncorrectIngredientInputException(String message) {
        super(message);
    }
}
