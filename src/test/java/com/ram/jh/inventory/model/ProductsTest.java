package com.ram.jh.inventory.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductsTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldConvertJsonProductListIntoPrice() {
        Products readValue;
        readValue = createProductListRecordWithStringInPriceNow();
        assertEquals("3525085", readValue.getProducts().get(0).getProductId());
        assertEquals("hush Tasha Vest Dress", readValue.getProducts().get(0).getTitle());
        assertEquals("", readValue.getProducts().get(0).getPrice().getThen1());
        assertEquals("59.00", readValue.getProducts().get(0).getPrice().now);
        assertEquals("Red", readValue.getProducts().get(0).getColorSwatches().get(0).getBasicColor());
        assertEquals("237494589", readValue.getProducts().get(0).getColorSwatches().get(0).getSkuId());
    }

    @Test
    public void shouldConvertJsonProductListIntoPriceWhenNowAnObject() {
        Products readValue;
        readValue = createProductListRecordWithObjectInPriceNow();
        assertEquals("3525085", readValue.getProducts().get(0).getProductId());
        assertEquals("hush Tasha Vest Dress", readValue.getProducts().get(0).getTitle());
        assertEquals("", readValue.getProducts().get(0).getPrice().then1);
        List priceNowList = (List) readValue.getProducts().get(0).getPrice().now;
        assertEquals("55.00", ((Map) priceNowList.get(0)).get("from"));
        assertEquals("100.00", ((Map) priceNowList.get(0)).get("to"));
        assertEquals("Red", readValue.getProducts().get(0).getColorSwatches().get(0).getBasicColor());
        assertEquals("237494589", readValue.getProducts().get(0).getColorSwatches().get(0).getSkuId());
    }

    public static Products createProductListRecordWithStringInPriceNow(){
        String content = "{\"products\": [{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                         "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\", \"now\": \"59.00\", \"uom\": \"\",\"currency\": \"GBP\"}, " +
                         "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                         "}]}";
        Products readValue;
        try {
            readValue = objectMapper.readValue(content, Products.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }

    public static Products createProductListRecordWithObjectInPriceNow(){
        String content = "{\"products\": [{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                         "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\", \"now\": [{\"from\": \"55.00\", \"to\": \"100.00\"}], \"uom\": \"\",\"currency\": \"GBP\"}, " +
                         "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] " +
                         "}]}";
        Products readValue;
        try {
            readValue = objectMapper.readValue(content, Products.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }
}
