package com.ram.jh.inventory.util;

import com.ram.jh.inventory.data.LookupRGBMap;

import java.util.Map;

public class Utilities {

    public static String lookupColor(final String basicColor) {
        return LookupRGBMap.colorLookupMap.entrySet()
                        .stream()
                        .filter(e -> e.getKey().equalsIgnoreCase(basicColor))
                        .findFirst()
                        .map(Map.Entry::getValue)
                        .orElse(Constants.RGB_COLOR_NOT_FOUND);
    }


}
