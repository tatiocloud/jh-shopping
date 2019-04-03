package com.ram.jh.inventory.service;

import com.ram.jh.inventory.model.Product;
import com.ram.jh.inventory.model.Products;
import com.ram.jh.inventory.model.ReducedProductPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private Products products;

    @Override
    public List<ReducedProductPrice> getReducedPriceList(String labelType) {

        Predicate<Product> wasNotEmpty = product -> !product.getPrice().getWas().isEmpty();
        Comparator<ReducedProductPrice> ascending = Comparator.comparing(ReducedProductPrice::getPriceReduction);
        return products.getProducts().stream()
                        .filter(wasNotEmpty)
                        .map(product -> new ReducedProductPrice(product, labelType))
                        .sorted(Collections.reverseOrder(ascending))
                        .collect(Collectors.toList());

    }
}
