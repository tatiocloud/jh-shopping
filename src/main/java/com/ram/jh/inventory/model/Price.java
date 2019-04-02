package com.ram.jh.inventory.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Price {

    @SerializedName("was")
    String was;
    @SerializedName("then1")
    String then1;
    @SerializedName("then2")
    String then2;
    @SerializedName("now")
    Object now;
    @SerializedName("uom")
    String uom;
    @SerializedName("currency")
    String currency;

    //default constructor for Gson Parser
    public Price(){

    }

    public Object getNow(){
        return now;
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
