package com.ram.jh.inventory.util;

import com.ram.jh.inventory.data.DataConstants;
import com.ram.jh.inventory.model.ColorSwatch;
import com.ram.jh.inventory.model.ColorSwatchesRGB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static String lookupCurrency(final String currencyTxt) {
        return DataConstants.cuurencyMap.entrySet()
                        .stream()
                        .filter(e -> e.getKey().equalsIgnoreCase(currencyTxt))
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .orElse(Constants.DEFAULT_CURRENCY);
    }

    public static String lookupColor(final String basicColor) {
        return DataConstants.colorLookupMap.entrySet()
                        .stream()
                        .filter(e -> e.getKey().equalsIgnoreCase(basicColor))
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .orElse(com.ram.jh.inventory.util.Constants.RGB_COLOR_NOT_FOUND);
    }

    public static Double priceNowObjectToDouble(final Object pNow) {
        //if Price.now is a Maped Object from Gson
        if(pNow instanceof Map){
            Map now = (HashMap) pNow;
            try {
                //assumption here is that to convert this complex object we return the average value
                Double from = Double.valueOf((String) now.get("from"));
                Double to = Double.valueOf((String) now.get("to"));
                return (from + to) / 2;
            } catch (NumberFormatException nfe) {
                return 0D;
            }
        }else if (pNow instanceof String) {
            String sNow = String.valueOf(pNow);
            return convertToDouble(sNow);
            //otherwise if Price.now is an Object
        } else {
            return 0D;
        }
    }

    public static double convertToDouble(String strToConvert) {
        try {
            return Double.parseDouble(strToConvert);
        } catch (NumberFormatException nfe) {
            return 0D;
        }
    }

    public static List<ColorSwatchesRGB> colorSwatchToColorSwatchRGB(final List<ColorSwatch> colorSwatchs) {

        return colorSwatchs.stream().map(
                        colorSwatch -> {
                            return new ColorSwatchesRGB(colorSwatch.getBasicColor(),
                                            Utils.lookupColor(colorSwatch.getBasicColor()),
                                            colorSwatch.getSkuId());
                        }
        ).collect(Collectors.toList());
    }

    public static String formatPrice(final Double doubleValue) {
        String result;
        if (doubleValue == null) {
            result = "0.00";
        } else if (doubleValue % 1 == 0) { //whole number
            if (doubleValue < 10) {
                result = String.format("%.2f", doubleValue);
            } else {
                result = String.valueOf(doubleValue.intValue());
            }
        } else { //floating point number
            result = String.format("%.2f", doubleValue);
        }
        return result;
    }
}
