package test.blueprint.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.component.LoadDatabase;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.dto.ProductDTO;
import test.blueprint.exceptions.IncorrectProductSizeInputException;
import test.blueprint.exceptions.IncorrectProductTypeInputException;
import test.blueprint.repository.ProductSizeRepository;
import test.blueprint.repository.ProductTypeRepository;

import java.util.List;
import java.util.ServiceLoader;

@Service
public class ProductValidator {

    @Autowired
    private LoadDatabase loadDatabase;
    @Autowired
    private IngredientValidator ingredientValidator;

    private static final Logger LOG = LoggerFactory.getLogger(ProductValidator.class);

    public void validate(ProductDTO product) {
        validateProductType(product);
        if (product.getProductSize() != null) {
            validateProductSize(product);
        }
        if (product.getIngredients() != null) {
            ingredientValidator.validateIngredients(product);
        }
    }

    private void validateProductType(ProductDTO product) {
        boolean productTypeExists = loadDatabase.productTypeList.stream().anyMatch(productType -> product.getProductType().equals(productType));
        if (!productTypeExists) {
            throw new IncorrectProductTypeInputException(product.getProductType());
        }
    }

    private void validateProductSize(ProductDTO product) {
        boolean productSizeExists = loadDatabase.productSizeList.stream().anyMatch(productSize -> product.getProductSize().equals(productSize));
        if (!productSizeExists) {
            throw new IncorrectProductSizeInputException("This product size does not exist: " + product.getProductSize());
        }
    }

}
