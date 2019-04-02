package com.ram.jh.inventory;
import com.ram.jh.inventory.model.ColorSwatches;
import com.ram.jh.inventory.model.Product;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class ProductTest {

    private String productId = "101";
    private String title = "someTitle";
    private List<ColorSwatches> colorSwatches = Collections.emptyList();
    private String nowPrice = "£1.75";
    private String priceLabel = "ShowWasNow";

    @Test
    public void test_single_product(){

        Product product = new Product(productId, title, colorSwatches, nowPrice, priceLabel);
    }
}
