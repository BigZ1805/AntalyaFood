package test.blueprint.controller;

import org.springframework.web.bind.annotation.*;
import test.blueprint.entity.Order;
import test.blueprint.exceptions.OrderNotFoundException;
import test.blueprint.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    List<Order> all() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    Order newOrder(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @GetMapping("/orders/{id}")
    Order one(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PostMapping("/orders/{id}")
    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return orderRepository.findById(id)
                .map( order -> {
                    order.setProducts(newOrder.getProducts());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderRepository.save(newOrder);
                });
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

}
