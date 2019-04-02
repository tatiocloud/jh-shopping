package com.ram.jh.inventory.controller;

import com.google.gson.Gson;
import com.ram.jh.inventory.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class ProductSearchService {

    @Autowired
    private Products products;

    @Autowired
    private Gson gson;

    @GetMapping(path = "/{category}/products")
    public String getProducts(@PathVariable("category") String category) {

        return "Greetings from Spring Boot! >>>> \n\n\n"+ category +" :::: >>>>>> \n\n\n"+ gson.toJson(products.getProducts().get(0));
    }
}
