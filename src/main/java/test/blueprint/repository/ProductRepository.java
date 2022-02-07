package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.blueprint.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
