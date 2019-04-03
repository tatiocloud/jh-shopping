package com.ram.jh.inventory.model;

import java.util.Objects;

public class ColorSwatchesRGB {

    private String color;
    private String rgbColor;
    private String skuId;

    public ColorSwatchesRGB(){
        //for jackson json parser
    }
    public ColorSwatchesRGB(String color, String rgbColor, String skuId) {
        this.color = color;
        this.rgbColor = rgbColor;
        this.skuId = skuId;
    }

    public String getColor() {
        return color;
    }

    public String getRgbColor() {
        return rgbColor;
    }

    public String getSkuId() {
        return skuId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ColorSwatchesRGB))
            return false;
        ColorSwatchesRGB that = (ColorSwatchesRGB) o;
        return Objects.equals(getColor(), that.getColor()) &&
               Objects.equals(getRgbColor(), that.getRgbColor()) &&
               Objects.equals(getSkuId(), that.getSkuId());
    }

    @Override public int hashCode() {
        return Objects.hash(getColor(), getRgbColor(), getSkuId());
    }

    @Override public String toString() {
        return "ColorSwatchesRGB{" +
               "color='" + color + '\'' +
               ", rgbColor='" + rgbColor + '\'' +
               ", skuId='" + skuId + '\'' +
               '}';
    }
}
