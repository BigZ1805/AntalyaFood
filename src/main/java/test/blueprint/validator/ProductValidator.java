package test.blueprint.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.domaindtos.ProductDTO;
import test.blueprint.repository.ProductSizeRepository;
import test.blueprint.repository.ProductTypeRepository;

import java.util.List;

@Service
//TODO last: totally inefficient why ? how to ?
public class ProductValidator {

    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private IngredientValidator ingredientValidator;

    public void validate(ProductDTO product) {//product requested by client
        validateProductType(product);
        if (product.getProductSize() != null) {
            validateProductSize(product);
            ingredientValidator.validateIngredients(product);
        }
    }

    private void validateProductType(ProductDTO product) {
        List<ProductType> productTypesFromDB = productTypeRepository.findAll();
        boolean productTypeExists = false;
            for (ProductType productTypeFromDB : productTypesFromDB) {
                    if (productTypeFromDB.getLabel().equals(product.getProductType())) {
                        productTypeExists = true;
                        break;
                    }
            }
        if (!productTypeExists) {
//            //TODO use custom exceptions
            throw new RuntimeException("ProductType " + product.getProductType() +" does not exists");

        }
    }

    private void validateProductSize(ProductDTO product) {
        List<ProductSize> productSizesFromDB = productSizeRepository.findAll();
        boolean productSizeExists = false;
        for (ProductSize productSizeFromDB : productSizesFromDB) {
            if (productSizeFromDB.getLabel().equals(product.getProductSize())|| product.getProductSize() == null) {
                productSizeExists = true;
                break;
            }
        }
        if (!productSizeExists) {
            //TODO use custom exceptions
            throw new RuntimeException("ProductSize " + product.getProductSize() + " does not exists");
        }
    }

}
