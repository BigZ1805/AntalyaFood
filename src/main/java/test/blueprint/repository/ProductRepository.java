package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
}
