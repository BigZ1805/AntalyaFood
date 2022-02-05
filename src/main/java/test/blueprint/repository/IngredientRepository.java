package test.blueprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.blueprint.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
