package test.blueprint.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.blueprint.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
    public Ingredient findByLabel(String label);

}
