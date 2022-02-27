package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {

}
