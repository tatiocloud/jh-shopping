package com.ram.jh.inventory.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String productId;

    private String title;

    private List<ColorSwatch> colorSwatches;

    private Price price;

    public Product() {
        //for Jackson to construct object
    }

    @JsonCreator
    public Product(@JsonProperty("productId") String productId,
                    @JsonProperty("title") String title,
                    @JsonProperty("colorSwatches") List<ColorSwatch> colorSwatches,
                    @JsonProperty("price") Price price) {
        this.productId = productId;
        this.title = title;
        this.colorSwatches = colorSwatches;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(List<ColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
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
