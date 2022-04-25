package test.blueprint.controller;

import org.springframework.web.bind.annotation.*;
import test.blueprint.domain.ProductType;
import test.blueprint.exceptions.ProductTypeNotFoundByIdException;
import test.blueprint.repository.ProductTypeRepository;

import java.util.List;

@RestController
public class ProductTypeController {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeController(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @GetMapping("/product-types")
    List<ProductType> all() {
        return productTypeRepository.findAll();
    }

    @PostMapping("/product-types")
    ProductType newProductType(@RequestBody ProductType newProductType) {
        return productTypeRepository.save(newProductType);
    }

    @GetMapping("/product-types/{id}")
    ProductType one(@PathVariable Long id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new ProductTypeNotFoundByIdException(id));
    }

    @PostMapping("/product-types/{id}")
    ProductType replaceProductType(@RequestBody ProductType newProductType, @PathVariable Long id) {
        return productTypeRepository.findById(id)
                .map( productType -> {
                    productType.setLabel(newProductType.getLabel());
                    return productTypeRepository.save(productType);
                })
                .orElseGet(() -> {
                    newProductType.setId(id);
                    return productTypeRepository.save(newProductType);
                });
    }

    @DeleteMapping("/product-types/{id}")
    void deleteProductType(@PathVariable Long id) {
        productTypeRepository.deleteById(id);
    }

}