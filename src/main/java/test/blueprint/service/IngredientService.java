package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.entity.Ingredient;
import test.blueprint.repository.IngredientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private StockService stockService;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findByLabel(String label) {
        return ingredientRepository.findByLabel(label);
    }

}

