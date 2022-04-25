package test.blueprint.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.component.LoadDatabase;
import test.blueprint.dto.ProductDTO;
import test.blueprint.exceptions.IncorrectIngredientInputException;
import test.blueprint.repository.IngredientRepository;

@Service
public class IngredientValidator {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private LoadDatabase loadDatabase;

    private static final Logger LOG = LoggerFactory.getLogger(IngredientValidator.class);

    public void validate(String ingredient) {
        if (loadDatabase.ingredientList.stream()
                .noneMatch(ingredient::equals)) {
            throw new IncorrectIngredientInputException("This ingredient does not exist: " + ingredient);
        }
    }

    public void validateIngredients(ProductDTO product) {
        product.getIngredients().forEach(this::validate);
    }
}
