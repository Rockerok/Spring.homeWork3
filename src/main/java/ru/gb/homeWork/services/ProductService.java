package ru.gb.homeWork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homeWork.model.Product;
import ru.gb.homeWork.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> displayAll() {
        return productRepository.displayAll();
    }

    public void save (Product product){
        productRepository.save(product);
    }

    public Product showById (Long id){
        return productRepository.showById(id);
    }
}
