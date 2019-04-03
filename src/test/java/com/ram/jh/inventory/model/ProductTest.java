package com.ram.jh.inventory.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldConvertJsonProductIntoPrice() {
        Product readValue = createProductRecordWithStringInPriceNow();
        assertEquals("3525085", readValue.getProductId());
        assertEquals("hush Tasha Vest Dress", readValue.getTitle());
        assertEquals("", readValue.getPrice().getThen1());
        assertEquals("55.00", readValue.getPrice().getNow());
        assertEquals("Blue", readValue.getColorSwatches().get(1).getBasicColor());
        assertEquals("237494562", readValue.getColorSwatches().get(1).getSkuId());
    }

    public Product createProductRecordWithStringInPriceNow(String content) {
        Product readValue;
        try {
            readValue = objectMapper.readValue(content, Product.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }

    public Product createProductRecordWithStringInPriceNow() {
        Product readValue;
        JavaType valueType = objectMapper.constructType(Product.class);
        try {
            String content = "{\"productId\": \"3525085\",\"title\": \"hush Tasha Vest Dress\", " +
                             "\"price\": {\"was\": \"\",\"then1\": \"\",\"then2\": \"\",\"now\": \"55.00\",\"uom\": \"\",\"currency\": \"GBP\"}, " +
                             "\"colorSwatches\": [{\"basicColor\": \"Red\",\"skuId\": \"237494589\"},{\"basicColor\": \"Blue\",\"skuId\": \"237494562\"}] "
                             +
                             "}";
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            readValue = objectMapper.readValue(content, valueType);
            return readValue;
        } catch (IOException e) {
            return null;
        }
    }

}
