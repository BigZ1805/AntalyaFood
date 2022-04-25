package test.blueprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blueprint.domain.ProductType;
import test.blueprint.repository.ProductTypeRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    public ProductType findByLabel(String label) {
        return productTypeRepository.findByLabel(label);
    }
}
