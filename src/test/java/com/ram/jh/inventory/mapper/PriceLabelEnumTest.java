package com.ram.jh.inventory.mapper;

import com.ram.jh.inventory.model.Price;
import org.junit.Assert;
import org.junit.Test;

public class PriceLabelEnumTest {

    @Test
    public void test_price_label_ShowWasNow() {
        String was = "";
        String now = "9";
        String currency = "£";
        String expected = "Was £0.00, now £9.00";

        PriceLabelEnum showWasNow = PriceLabelEnum.valueOf("ShowWasNow");
        String actualPrice = showWasNow.getPrice(was, now, currency);

        Assert.assertEquals(expected,actualPrice);
    }

    @Test
    public void test_price_label_ShowWasThenNow_then1_is_not_empty() {
        String was = "1";
        String now = "3";
        String then1 = "10";
        String then2 = "11";
        String uom = "";
        String currency = "£";
        String expected = "Was £1.00, then £10, now £3.00";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasThenNow");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);

    }

    @Test
    public void test_price_label_ShowWasThenNow_then1_empty_return_then2() {
        String was = "1";
        String now = "3";
        String then1 = "";
        String then2 = "11";
        String uom = "";
        String currency = "£";
        String expected = "Was £1.00, then £11, now £3.00";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasThenNow");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);

    }

    @Test
    public void test_price_label_ShowWasThenNow_then1_then2_empty_should_show_then() {
        String was = "1";
        String now = "3";
        String then1 = "";
        String then2 = "";
        String uom = "";
        String currency = "£";
        String expected = "Was £1.00, now £3.00";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasThenNow");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);

    }

    @Test
    public void test_price_label_was30_now10_with_label_ShowWasNow() {
        String was = "30";
        String now = "10";
        String then1 = "";
        String then2 = "";
        String uom = "";
        String currency = "£";
        String expected = "Was £30, now £10";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasNow");
        String actualPrice = showWasThenNow.getPrice(testObj.getWas(),testObj.getNow(),testObj.getCurrency());
        Assert.assertEquals(expected,actualPrice);

    }


    @Test
    public void test_price_label_then1Lessthan10_with_label_ShowWasThenNow() {
        String was = "30";
        String now = "10";
        String then1 = "1";
        String then2 = "";
        String uom = "";
        String currency = "£";
        String expected = "Was £30, then £1.00, now £10";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasThenNow");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);

    }

    @Test
    public void test_price_label_then2Greater10_with_label_ShowWasThenNow() {
        String was = "30";
        String now = "10";
        String then1 = "";
        String then2 = "20";
        String uom = "";
        String currency = "£";
        String expected = "Was £30, then £20, now £10";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowWasThenNow");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);

    }

    @Test
    public void test_price_label_ShowPercDscount() {
        String was = "30";
        String now = "10";
        String then1 = "";
        String then2 = "";
        String uom = "";
        String currency = "£";
        String expected = "20% off - now £10";

        Price testObj = createPricedObj(was, then1, then2, now, uom, currency);
        PriceLabelEnum showWasThenNow = PriceLabelEnum.valueOf("ShowPercDscount");
        String actualPrice = showWasThenNow.getPrice(testObj);
        Assert.assertEquals(expected,actualPrice);
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
