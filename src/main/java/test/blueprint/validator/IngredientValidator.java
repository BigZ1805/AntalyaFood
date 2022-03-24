package test.blueprint.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.entity.Ingredient;
import test.blueprint.entity.Product;
import test.blueprint.repository.IngredientRepository;

import java.util.List;

@Service
//TODO 2. totally inefficient why ? how to ?
public class IngredientValidator {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void validate(String ingredient) {
        List<Ingredient> ingredientsFromDB = ingredientRepository.findAll();
        boolean ingredientExists = false;
        //TODO 4 foreach works, but try alternative with stream, google java stream find in list
        for (Ingredient ingredientFromDB : ingredientsFromDB) {
            if (ingredientFromDB.getLabel().equals(ingredient)) {
                ingredientExists = true;
                break;
            }
        }
            if (!ingredientExists) {
                //TODO 1. use custom exceptions https://www.baeldung.com/java-new-custom-exception
                throw new RuntimeException("Ingredient " + ingredient + " does not exists");
            }

    }

    public void validateIngredients(ProductDTO product){
        //TODO 4 foreach works, but try alternative with stream, google java stream foreach
        //TODO 5, apply TODO 4 to product validator
        for (String ingredient : product.getIngredients()) {
            validate(ingredient);
        }
    }
}
