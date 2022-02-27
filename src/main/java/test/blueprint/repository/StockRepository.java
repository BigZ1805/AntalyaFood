package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
