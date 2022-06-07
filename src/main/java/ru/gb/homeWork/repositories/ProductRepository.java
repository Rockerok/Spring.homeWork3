package ru.gb.homeWork.repositories;

import org.springframework.stereotype.Component;
import ru.gb.homeWork.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private  List <Product>prodRepo;

    public List<Product> getProdRepo() {
        return prodRepo;
    }
    public void setProdRepo(List<Product> prodRepo) {
        this.prodRepo = prodRepo;
    }

    @PostConstruct
    private void init() {
        this.prodRepo = new ArrayList<>(Arrays.asList(
                new Product(1L,"tomatoes", 25)
        ));
    }

    public List<Product> displayAll(){
        return Collections.unmodifiableList(prodRepo);
    }

    public void save(Product product) {
        prodRepo.add(product);
    }

    public Product showById (Long id){
        return  prodRepo.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }
}
