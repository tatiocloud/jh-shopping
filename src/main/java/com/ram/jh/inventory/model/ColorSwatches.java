package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ColorSwatches {

    @SerializedName("color")
    private final String color;
    @SerializedName("rgbColor")
    private final String rgbColor;
    @SerializedName("skuId")
    private final String skuId;

    public ColorSwatches(String color, String rgbColor, String skuId) {
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

    public String getSkuid() {
        return skuId;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ColorSwatches))
            return false;
        ColorSwatches that = (ColorSwatches) o;
        return Objects.equals(getColor(), that.getColor()) &&
               Objects.equals(getRgbColor(), that.getRgbColor()) &&
               Objects.equals(getSkuid(), that.getSkuid());
    }

    @Override public int hashCode() {
        return Objects.hash(getColor(), getRgbColor(), getSkuid());
    }

    @Override public String toString() {
        return "ColorSwatches{" +
               "color='" + color + '\'' +
               ", rgbColor='" + rgbColor + '\'' +
               ", skuId='" + skuId + '\'' +
               '}';
    }
}
