package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {

    @SerializedName("products")
    public List<Product> products;

    public Products() {

    }

    public List<Product> getProducts() {
        return products;
    }

    @Override public String toString() {
        return "Products{" +
               "products=" + products +
               '}';
    }
}
