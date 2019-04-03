package com.ram.jh.inventory.service;

import com.ram.jh.inventory.model.ReducedProductPrice;

import java.util.List;

public interface ProductsService {
    public List<ReducedProductPrice> getReducedPriceList(String labelType);
}
