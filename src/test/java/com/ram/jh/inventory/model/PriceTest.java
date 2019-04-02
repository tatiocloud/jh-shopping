package com.ram.jh.inventory.model;

import org.junit.Assert;
import org.junit.Test;

public class PriceTest {

    String was = "";
    String then1 = "";
    String then2 = "";
    String now = "";
    String uom = "";
    String currency = "£";

    Price price = new Price(was, then1, then2, now, uom, currency);

    @Test
    public void test_now_and_was_empty_and_returns_zero() {
        String was = "";
        String then1 = "";
        String then2 = "";
        String now = "";
        String uom = "";
        String currency = "£";

        Price price = createPricedObj(was, then1, then2, now, uom, currency);
        String formatedPrice = price.calculatePriceReduction();
        Assert.assertTrue(formatedPrice.equalsIgnoreCase("0.0"));
    }

    @Test
    public void test_was_empty_returns_now() {
        String was = "";
        String then1 = "";
        String then2 = "";
        String now = "10";
        String uom = "";
        String currency = "£";

        Price price = createPricedObj(was, then1, then2, now, uom, currency);
        String formatedPrice = price.calculatePriceReduction();
        Assert.assertTrue(formatedPrice.equalsIgnoreCase("10"));
    }

    private Price createPricedObj(
                    String was,
                    String then1,
                    String then2,
                    String now,
                    String uom,
                    String currency) {
        return new Price(was, then1, then2, now, uom, currency);
    }
}
