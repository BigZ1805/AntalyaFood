package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.entity.Ingredient;
import test.blueprint.repository.IngredientRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientService {

    @Autowired
    private IngredientRepository repository;

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Optional<Ingredient> select(Ingredient ingredient) {
        return repository.findById(ingredient.getId());
    }

    public Ingredient create(Ingredient ingredient) {
        return repository.save(ingredient);
    }


    public List<Ingredient> ingredientList = new ArrayList<>();

    public List<Ingredient> populateIngredientList() {
        ingredientList.add(new Ingredient("BIG_BUN"));
        ingredientList.add(new Ingredient("SMALL_BUN"));
        ingredientList.add(new Ingredient("BIG_WRAP"));
        ingredientList.add(new Ingredient("SMALL_WRAP"));
        ingredientList.add(new Ingredient("FRIES"));
        ingredientList.add(new Ingredient("CABBAGE"));
        ingredientList.add(new Ingredient("HOT_SAUCE"));
        ingredientList.add(new Ingredient("SWEET_SAUCE"));
        return repository.saveAll(ingredientList);
    }
}

