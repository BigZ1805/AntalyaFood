package test.blueprint.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Product;
import test.blueprint.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientValidator {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void validate(String ingredient) {
        List<Ingredient> ingredientsFromDB = ingredientRepository.findAll();
        boolean ingredientExists = false;
        for (Ingredient ingredientFromDB : ingredientsFromDB) {
            if (ingredientFromDB.getLabel().equals(ingredient)) {
                ingredientExists = true;
                break;
            }
        }
            if (!ingredientExists) {
                //TODO use custom exceptions
                throw new RuntimeException("Ingredient " + ingredient + " does not exists");
            }

    }

    public void validateIngredients(ProductDTO product){
        for (String ingredient : product.getIngredients()) {
            validate(ingredient);
        }
    }
}
