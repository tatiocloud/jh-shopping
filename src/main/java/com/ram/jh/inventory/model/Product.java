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

    @SerializedName("price")
    private final Price price;

    public Product(String productId,
                    String title,
                    List<ColorSwatches> colorSwatches,
                    Price price) {
        this.productId = productId;
        this.title = title;
        this.colorSwatches = colorSwatches;
        this.price = price;
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

    public Price getPrice() {
        return price;
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
               Objects.equals(getPrice(), product.getPrice());
    }

    @Override public int hashCode() {
        return Objects.hash(getProductId(), getTitle(), getColorSwatches(), getPrice());
    }

    @Override public String toString() {
        return "Product{" +
               "productId='" + productId + '\'' +
               ", title='" + title + '\'' +
               ", colorSwatches=" + colorSwatches +
               ", price=" + price +
               '}';
    }
}
