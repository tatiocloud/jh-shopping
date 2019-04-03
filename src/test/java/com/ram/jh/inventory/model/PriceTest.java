package com.ram.jh.inventory.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldConvertJsonIntoPrice() {
        Price readValue = createPriceRecordWithStringInPriceNow();
        assertEquals("", readValue.was);
        assertEquals("", readValue.then1);
        assertEquals("", readValue.then2);
        assertEquals("19.00", readValue.now);
        assertEquals("", readValue.uom);
        assertEquals("GBP", readValue.currency);
    }

    public Price createPriceRecordWithStringInPriceNow() {
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":\"19.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
        Price readValue;
        try {
            readValue = objectMapper.readValue(content, Price.class);
            return readValue;
        } catch (IOException e) {
            return null;
        }
    }

    public Price createPriceRecordWithObjectInPriceNow() {
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":{\"from\":\"55.00\",\"to\":\"100.00\"},\"uom\":\"\",\"currency\":\"GBP\"}";
        Price readValue;
        try {
            readValue = objectMapper.readValue(content, Price.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }
}
