package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.entity.Ingredient;
import test.blueprint.repository.IngredientRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IngredientService {

    @Autowired
    private IngredientRepository repository;

    public List<Ingredient> findAll() {
        return repository.findAll();
    }

    public Ingredient create(Ingredient ingredient) {
        return repository.save(ingredient);
    }
}
