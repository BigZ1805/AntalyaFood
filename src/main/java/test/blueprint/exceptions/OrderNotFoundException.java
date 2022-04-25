package test.blueprint.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("The order with the id: [" + id + "] does not exist!");
    }
}
