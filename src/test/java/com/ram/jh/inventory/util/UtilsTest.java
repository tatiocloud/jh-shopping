package com.ram.jh.inventory.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.jh.inventory.model.ColorSwatch;
import com.ram.jh.inventory.model.ColorSwatchesRGB;
import com.ram.jh.inventory.model.Price;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.*;

public class UtilsTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturnRGBColourForInputColourBlack() {
        ColorSwatch colorSwatch = new ColorSwatch("Dark black", "black", "1234");
        ColorSwatchesRGB colorSwatchRGB = Utils.colorSwatchToColorSwatchRGB(Collections.singletonList(colorSwatch)).get(0);
        assertEquals("black", colorSwatchRGB.getColor());
        assertEquals("000000", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

    @Test
    public void shouldReturnRGBColourForInputColourGreen() {
        ColorSwatch colorSwatch = new ColorSwatch("Khaki", "green", "1234");
        ColorSwatchesRGB colorSwatchRGB = Utils.colorSwatchToColorSwatchRGB(Collections.singletonList(colorSwatch)).get(0);
        assertEquals("green", colorSwatchRGB.getColor());
        assertEquals("008000", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

    @Test
    public void shouldReturnMinusOneForInputColourNotFound() {
        ColorSwatch colorSwatch = new ColorSwatch("some", "xyz", "1234");
        ColorSwatchesRGB colorSwatchRGB = Utils.colorSwatchToColorSwatchRGB(Collections.singletonList(colorSwatch)).get(0);
        assertEquals("xyz", colorSwatchRGB.getColor());
        assertEquals("na", colorSwatchRGB.getRgbColor());
        assertEquals("1234", colorSwatchRGB.getSkuId());
    }

   @Test
    public void shouldReturnAverageOfNowPrice() {
        assertEquals(77.5D, Utils.priceNowObjectToDouble(createPriceRecordWithObjectInPriceNow().getNow()), 0);
    }

    @Test
    public void shouldReturnNowPriceAsInput() {
        assertEquals(19D, Utils.priceNowObjectToDouble(createPriceRecordWithStringInPriceNow().getNow()), 0);
    }

    @Test
    public void shouldDetectIntegerNotDouble() {
        String num = "20";
        try {
            assertEquals(20, Utils.convertToDouble(num), 0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

    @Test
    public void shouldDetectDoubleIsWhole() {
        Double num = Utils.convertToDouble("20.00");
        try {
            assertEquals(0, num % 1, 0.0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

    @Test
    public void shouldDetectDoubleIsNotWhole() {
        Double num = Utils.convertToDouble("20.10");
        try {
            assertNotEquals(0, num % 1, 0.0);
        } catch (NumberFormatException nfe) {
            fail();
        }
    }

    public Price createPriceRecordWithStringInPriceNow() {
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":\"19.00\",\"uom\":\"\",\"currency\":\"GBP\"}";
        Price readValue;
        try {
            readValue = objectMapper.readValue(content, Price.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }

    public Price createPriceRecordWithObjectInPriceNow() {
        String content = "{\"was\":\"\",\"then1\":\"\",\"then2\":\"\",\"now\":{\"from\":\"55.00\",\"to\":\"100.00\"},\"uom\":\"\",\"currency\":\"GBP\"}";
        Price readValue;
        try {
            readValue = objectMapper.readValue(content.getBytes(), Price.class);
        } catch (IOException e) {
            return null;
        }
        return readValue;
    }

}
