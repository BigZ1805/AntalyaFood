package test.blueprint.controller;

import org.springframework.web.bind.annotation.*;
import test.blueprint.domain.ProductSize;
import test.blueprint.exceptions.ProductSizeNotFoundException;
import test.blueprint.repository.ProductSizeRepository;

import java.util.List;

@RestController
public class ProductSizeController {

    private final ProductSizeRepository productSizeRepository;

    public ProductSizeController(ProductSizeRepository productSizeRepository) {
        this.productSizeRepository = productSizeRepository;
    }

    @GetMapping("/product-sizes")
    List<ProductSize> all() {
        return productSizeRepository.findAll();
    }

    @PostMapping("/product-sizes")
    ProductSize getNewProductSize(@RequestBody ProductSize newProductSize) {
        return productSizeRepository.save(newProductSize);
    }

    @GetMapping("/product-sizes/{id}")
    ProductSize one(@PathVariable Long id) {
        return productSizeRepository.findById(id)
                .orElseThrow(() -> new ProductSizeNotFoundException(id));
    }

    @PostMapping("/product-sizes/{id}")
    ProductSize replaceProductSize(@RequestBody ProductSize newProductSize, @PathVariable Long id) {
        return productSizeRepository.findById(id)
                .map( productSize -> {
                    productSize.setLabel(newProductSize.getLabel());
                    return productSizeRepository.save(productSize);
                })
                .orElseGet(() -> {
                    newProductSize.setId(id);
                    return productSizeRepository.save(newProductSize);
                });
    }

    @DeleteMapping("/product-sizes/{id}")
    void deleteProductSize(@PathVariable Long id) {
        productSizeRepository.deleteById(id);
    }

}