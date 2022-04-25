package test.blueprint.exceptions;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(Long id) {
        super("The ingredient with the id: [" + id + "] does not exist!");
    }
}