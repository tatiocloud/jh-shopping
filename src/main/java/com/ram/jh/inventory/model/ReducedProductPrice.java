package com.ram.jh.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ram.jh.inventory.util.Constants;
import com.ram.jh.inventory.util.Utils;
import java.util.List;
import java.util.Objects;
import static com.ram.jh.inventory.util.Utils.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReducedProductPrice{

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("ColorSwatch")
    private List<ColorSwatchesRGB> colorSwatches;
    @JsonProperty("nowPrice")
    private String nowPrice;
    @JsonProperty("priceLabel")
    private String priceLabel;

    @JsonIgnore
    private static final String NOW_LITERAL = ", now ";
    @JsonIgnore
    private Double wasPriceDbl;
    @JsonIgnore
    private Double nowPriceDbl;
    @JsonIgnore
    private String currencySymbol;

    public ReducedProductPrice(final Product product, final String labelType) {
        this.productId = product.getProductId();
        this.title = product.getTitle();
        this.colorSwatches = colorSwatchToColorSwatchRGB(product.getColorSwatches());
        this.currencySymbol = lookupCurrency(product.getPrice().getCurrency());
        nowPriceDbl = priceNowObjectToDouble(product.getPrice().now);
        nowPrice =  formatPrice(nowPriceDbl);
        wasPriceDbl = priceNowObjectToDouble(product.getPrice().was);
        this.priceLabel = formatPriceLabel(product.getPrice(), labelType);
    }

    @JsonIgnore
    public Double getPriceReduction() {
        return this.wasPriceDbl - this.nowPriceDbl;
    }

    private String formatPriceLabel(Price price, final String pLabelType) {
        String result;
        String labelType = (pLabelType == null ? Constants.DEFAULT_LABELTYPE : pLabelType);
        switch (labelType.toLowerCase()) {
            case "showwasnow":
                result = formatShowWasNow();
                break;
            case "showwasthennow":
                result = formatShowWasThenNow(price);
                break;
            case "showpercdscount":
                result = formatShowPercDscount();
                break;
            default:
                result = formatShowWasNow();
                break;
        }
        return result;
    }

    private String formatShowPercDscount() {
        Double discount = calcDiscount();
        String result = "";
        if (discount > 0) {
            result = formatPrice(discount) + "% off - now " + this.nowPrice;
        } else {
            // a price increase (i.e PriceNow > PriceWas is an unsupported operation so returning empty discount.
        }
        return result;
    }

    private String formatShowWasThenNow(Price price) {
        String result;
        String wasPrice = currencySymbol + formatPrice(wasPriceDbl);
        String thenPrice = currencySymbol + formatPrice(calcThenPrice(price));

        if (!thenPrice.equals("£0.00")) {
            Double nowPriceTemp = convertToDouble(this.nowPrice);
            result = "Was " + wasPrice + ", then " + thenPrice + NOW_LITERAL + currencySymbol + formatPrice(convertToDouble(this.nowPrice));
        } else {
            result = "Was " + wasPrice + NOW_LITERAL + currencySymbol + formatPrice(convertToDouble(this.nowPrice));
        }
        return result;
    }

    private String formatShowWasNow() {
        String wasPrice = currencySymbol + formatPrice(wasPriceDbl);
        return "Was " + wasPrice + NOW_LITERAL + currencySymbol + formatPrice(convertToDouble(this.nowPrice));
    }

    private Double calcDiscount() {
        return ((getPriceReduction()) / (wasPriceDbl)) * 100;
    }

    private static Double calcThenPrice(Price price) {
        Double thenResult = 0D;
        Double then1Price = Utils.convertToDouble(price.then1);
        Double then2Price = Utils.convertToDouble(price.then2);

        if (then2Price != null && then2Price != 0) {
            thenResult = then2Price;
        } else if (then1Price != null && then1Price != 0) {
            thenResult = then1Price;
        }

        return thenResult;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ReducedProductPrice))
            return false;
        ReducedProductPrice that = (ReducedProductPrice) o;
        return Objects.equals(wasPriceDbl, that.wasPriceDbl) &&
               Objects.equals(nowPriceDbl, that.nowPriceDbl) &&
               Objects.equals(currencySymbol, that.currencySymbol) &&
               Objects.equals(productId, that.productId) &&
               Objects.equals(title, that.title) &&
               Objects.equals(colorSwatches, that.colorSwatches) &&
               Objects.equals(nowPrice, that.nowPrice) &&
               Objects.equals(priceLabel, that.priceLabel);
    }

    @Override public int hashCode() {
        return Objects.hash(wasPriceDbl, nowPriceDbl, currencySymbol, productId, title, colorSwatches, nowPrice, priceLabel);
    }

    @Override
    public String toString() {
        return "ReducedPriceProduct{" +
               "wasPriceDbl=" + wasPriceDbl +
               ", nowPriceDbl=" + nowPriceDbl +
               ", currencySymbol='" + currencySymbol + '\'' +
               ", productId='" + productId + '\'' +
               ", title='" + title + '\'' +
               ", colorSwatches=" + colorSwatches +
               ", nowPrice='" + nowPrice + '\'' +
               ", priceLabel='" + priceLabel + '\'' +
               '}';
    }
}
