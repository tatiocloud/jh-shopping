package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ProductAfterReducedPrice {

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

    public ProductAfterReducedPrice(
                    String productId,
                    String title,
                    List<ColorSwatches> colorSwatches,
                    String nowPrice,
                    String priceLabel) {
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
        if (!(o instanceof ProductAfterReducedPrice))
            return false;
        ProductAfterReducedPrice that = (ProductAfterReducedPrice) o;
        return Objects.equals(getProductId(), that.getProductId()) &&
               Objects.equals(getTitle(), that.getTitle()) &&
               Objects.equals(getColorSwatches(), that.getColorSwatches()) &&
               Objects.equals(getNowPrice(), that.getNowPrice()) &&
               Objects.equals(getPriceLabel(), that.getPriceLabel());
    }

    @Override public int hashCode() {
        return Objects.hash(getProductId(), getTitle(), getColorSwatches(), getNowPrice(), getPriceLabel());
    }

    @Override public String toString() {
        return "ProductAfterReducedPrice{" +
               "productId='" + productId + '\'' +
               ", title='" + title + '\'' +
               ", colorSwatches=" + colorSwatches +
               ", nowPrice='" + nowPrice + '\'' +
               ", priceLabel='" + priceLabel + '\'' +
               '}';
    }
}
