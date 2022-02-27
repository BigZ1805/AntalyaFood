package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.domain.ProductSize;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Product;

@Repository
public interface ProductSizeRepository extends JpaRepository <ProductSize, Long> {
    ProductSize findByLabel(String label);
}
