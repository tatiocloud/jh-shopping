package com.ram.jh.inventory.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ColorSwatch {

    private final String color;
    private final String basicColor;
    private final String skuId;

    public ColorSwatch(@JsonProperty("color") String color,
                    @JsonProperty("basicColor") String basicColor,
                    @JsonProperty("skuId") String skuId) {
        this.color = color;
        this.basicColor = basicColor;
        this.skuId = skuId;
    }

    public String getColor() {
        return color;
    }

    public String getBasicColor() {
        return basicColor;
    }

    public String getSkuId() {
        return skuId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ColorSwatch))
            return false;
        ColorSwatch that = (ColorSwatch) o;
        return Objects.equals(getColor(), that.getColor()) &&
               Objects.equals(getBasicColor(), that.getBasicColor()) &&
               Objects.equals(getSkuId(), that.getSkuId());
    }

    @Override public int hashCode() {
        return Objects.hash(getColor(), getBasicColor(), getSkuId());
    }

    @Override public String toString() {
        return "ColorSwatch{" +
               "color='" + color + '\'' +
               ", rgbColor='" + basicColor + '\'' +
               ", skuId='" + skuId + '\'' +
               '}';
    }
}
