package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.Math.subtractExact;

public class Price {

    @SerializedName("was")
    String was;
    @SerializedName("then1")
    String then1;
    @SerializedName("then2")
    String then2;
    @SerializedName("now")
    String now;
    @SerializedName("uom")
    String uom;

    @SerializedName("currency")
    String currency;

    public Price(String was, String then1, String then2, String now, String uom, String currency) {
        this.was = was;
        this.then1 = then1;
        this.then2 = then2;
        this.now = now;
        this.uom = uom;
        this.currency = currency;
    }

    //default constructor for Gson Parser

    public Price() {

    }

    public String getWas() {
        return was;
    }

    public String getThen1() {
        return then1;
    }

    public String getThen2() {
        return then2;
    }

    public String getNow() {
        return now;
    }

    public String getUom() {
        return uom;
    }

    public String getCurrency() {
        return currency;
    }

    public String calculatePriceReduction() {

        if (!getWas().isEmpty()) {

            if (!getNow().isEmpty()) {

                int wasInt = parseInt(getWas());
                int nowInt = parseInt(getNow());
                return String.valueOf(subtractExact(wasInt, nowInt));
            } else {
                getWas();
            }
        } else {
            if (!getNow().isEmpty()) {
                return getNow();
            } else {
                return "0.0";
            }
        }

        return "0";
    }

    public Double calcPriceReduction() {

        if (!getWas().isEmpty()) {

            if (!getNow().isEmpty()) {
                double wasDouble = Double.parseDouble(getWas());
                double nowDouble = Double.parseDouble(getNow());
                return wasDouble - nowDouble;
            } else {
                return Double.parseDouble(getWas());
            }
        } else {
            if (!getNow().isEmpty()) {
                return Double.parseDouble(getNow());
            } else {
                return 0D;
            }
        }
    }

    private Double calcDiscount() {
        return ((Double.parseDouble(calculatePriceReduction())) / (Double.parseDouble(getWas()))) * 100;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Price))
            return false;
        Price price = (Price) o;
        return Objects.equals(was, price.was) &&
               Objects.equals(then1, price.then1) &&
               Objects.equals(then2, price.then2) &&
               Objects.equals(getNow(), price.getNow()) &&
               Objects.equals(uom, price.uom) &&
               Objects.equals(currency, price.currency);
    }

    @Override public int hashCode() {
        return Objects.hash(was, then1, then2, getNow(), uom, currency);
    }

    @Override public String toString() {
        return "Price{" +
               "was='" + was + '\'' +
               ", then1='" + then1 + '\'' +
               ", then2='" + then2 + '\'' +
               ", now=" + now +
               ", uom='" + uom + '\'' +
               ", currency='" + currency + '\'' +
               '}';
    }
}
