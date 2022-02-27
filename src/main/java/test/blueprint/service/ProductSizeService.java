package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domain.ProductSize;
import test.blueprint.domain.ProductType;
import test.blueprint.repository.ProductSizeRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductSizeService {
    @Autowired
    private ProductSizeRepository productSizeRepository;
    public ProductSize findByLabel(String label) {
        return productSizeRepository.findByLabel(label);
    }

}
