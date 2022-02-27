package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findByLabel(String label);
}
