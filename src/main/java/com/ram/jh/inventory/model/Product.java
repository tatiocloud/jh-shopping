package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Product {

    @SerializedName("productId")
    private final String productId;
    @SerializedName("title")
    private final String title;
    @SerializedName("colorSwatches")
    private final List<ColorSwatches> colorSwatches;
    @SerializedName("nowPrice")
    private final String nowPrice;
    @SerializedName("priceLabel")
    private final String priceLabel;

    public Product(String productId, String title, List<ColorSwatches> colorSwatches, String nowPrice, String priceLabel) {
        this.productId = productId;
        this.title = title;
        this.colorSwatches = colorSwatches;
        this.nowPrice = nowPrice;
        this.priceLabel = priceLabel;
    }

    public String getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public List<ColorSwatches> getColorSwatches() {
        return colorSwatches;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public String getPriceLabel() {
        return priceLabel;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId()) &&
               Objects.equals(getTitle(), product.getTitle()) &&
               Objects.equals(getColorSwatches(), product.getColorSwatches()) &&
               Objects.equals(getNowPrice(), product.getNowPrice()) &&
               Objects.equals(getPriceLabel(), product.getPriceLabel());
    }

    @Override public int hashCode() {
        return Objects.hash(getProductId(), getTitle(), getColorSwatches(), getNowPrice(), getPriceLabel());
    }

    @Override public String toString() {
        return "Product{" +
               "productId='" + productId + '\'' +
               ", title='" + title + '\'' +
               ", colorSwatches=" + colorSwatches +
               ", nowPrice='" + nowPrice + '\'' +
               ", priceLabel='" + priceLabel + '\'' +
               '}';
    }
}
