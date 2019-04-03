package com.ram.jh.inventory.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.jh.inventory.model.ReducedProductPrice;
import com.ram.jh.inventory.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/{category}/products")
    public String getProducts(
                    @PathVariable("category")
                                    String category,
                    @RequestParam(value = "priceLabel", required = false, defaultValue = "ShowWasNow ")
                                    String priceLabel) {
        List<ReducedProductPrice> reducedPriceList = productsService.getReducedPriceList(priceLabel);
        try {
            return objectMapper.writeValueAsString(reducedPriceList);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
