package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Stock;
import test.blueprint.repository.IngredientRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void populateIngredientStock() {
        ArrayList<String> defaultIngredientList = new ArrayList<>(Arrays.asList("BIG_BUN", "SMALL_BUN", "BIG_WRAP","SMALL_WRAP","FRIES", "CABBAGE", "HOT_SAUCE", "SWEET_SAUCE"));
        for(String label: defaultIngredientList) {
            Ingredient newIngredient = save(new Ingredient(label, 1d , "PCS"));
            Stock newStock = stockService.save(new Stock(100d, newIngredient));
        }

        Ingredient updateIngredient = findById(5L).get();
        updateIngredient.setUsedQantity(0.1d);
        updateIngredient.setUnit("KG");
        save(updateIngredient);

        Ingredient updateIngredient2 = findById(6L).get();
        updateIngredient2.setUsedQantity(0.1d);
        updateIngredient2.setUnit("KG");
        save(updateIngredient2);

        Ingredient updateIngredient3 = findById(7L).get();
        updateIngredient3.setUsedQantity(0.025d);
        updateIngredient3.setUnit("Liter");
        save(updateIngredient3);

        Ingredient updateIngredient4 = findById(8L).get();
        updateIngredient4.setUsedQantity(0.025d);
        updateIngredient4.setUnit("Liter");
        save(updateIngredient4);
    }
}

