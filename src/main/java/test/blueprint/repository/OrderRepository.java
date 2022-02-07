package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.blueprint.entity.Order;

public interface OrderRepository extends JpaRepository <Order, Long> {

}
