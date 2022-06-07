package ru.gb.homeWork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homeWork.model.Product;
import ru.gb.homeWork.services.ProductService;

import java.util.List;


@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //   http://localhost:8189/app/show_all
    @GetMapping (value = "/show_all")
    public String showAll(Model model){
        model.addAttribute("productPerository", productService.displayAll());
        return "productPerository";
    }

    @GetMapping (value = "/show/{id}")
    public String showProductId(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.showById(id));
        return "product";
    }

    @GetMapping (value = "/create")
    public String createProduct(){
        return "createProduct";
    }
    @PostMapping (value = "/create")
    public String saveProduct(@RequestParam Long id,
                              @RequestParam String title,
                              @RequestParam int cost){
        productService.save(new Product(id, title, cost));
        return "redirect:/show_all";
    }
}
