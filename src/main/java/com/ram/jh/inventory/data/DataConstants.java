package com.ram.jh.inventory.data;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataConstants {

    public static final Map<String, String> colorLookupMap = Stream.of(
                    new AbstractMap.SimpleImmutableEntry<>("Black", "000000"),
                    new AbstractMap.SimpleImmutableEntry<>("White", "FFFFFF"),
                    new AbstractMap.SimpleImmutableEntry<>("Red", "FF0000"),
                    new AbstractMap.SimpleImmutableEntry<>("Lime", "00FF00"),
                    new AbstractMap.SimpleImmutableEntry<>("Blue", "0000FF"),
                    new AbstractMap.SimpleImmutableEntry<>("Yellow", "FFFF00"),
                    new AbstractMap.SimpleImmutableEntry<>("Cyan", "00FFFF"),
                    new AbstractMap.SimpleImmutableEntry<>("Magenta", "FF00FF"),
                    new AbstractMap.SimpleImmutableEntry<>("Silver", "C0C0C0"),
                    new AbstractMap.SimpleImmutableEntry<>("Gray", "808080"),
                    new AbstractMap.SimpleImmutableEntry<>("Maroon", "800000"),
                    new AbstractMap.SimpleImmutableEntry<>("Olive", "808000"),
                    new AbstractMap.SimpleImmutableEntry<>("Green", "008000"),
                    new AbstractMap.SimpleImmutableEntry<>("Purple", "800080"),
                    new AbstractMap.SimpleImmutableEntry<>("Teal", "008080"),
                    new AbstractMap.SimpleImmutableEntry<>("Navy", "000080")
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public static final Map<String, String> cuurencyMap = Stream.of(
                    new AbstractMap.SimpleImmutableEntry<>("GBP", "£")
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

}
