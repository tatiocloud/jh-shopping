package com.ram.jh.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    @JsonProperty("was")
    String was;

    @JsonProperty("then1")
    String then1;
    @JsonProperty("then2")
    String then2;

    @JsonProperty("now")
    Object now;

    @JsonProperty("uom")
    String uom;

    @JsonProperty("currency")
    String currency;

    public Price(){
        //empty constructor for Jackson JSON Parser
    }
    public Price(String was, String then1, String then2, Object now, String uom, String currency) {
        this.was = was;
        this.then1 = then1;
        this.then2 = then2;
        this.now = now;
        this.uom = uom;
        this.currency = currency;
    }

    public String getWas() {
        return was;
    }

    public void setWas(String was) {
        this.was = was;
    }

    public String getThen1() {
        return then1;
    }

    public void setThen1(String then1) {
        this.then1 = then1;
    }

    public String getThen2() {
        return then2;
    }

    public void setThen2(String then2) {
        this.then2 = then2;
    }

    public Object getNow() {
        return now;
    }

    public void setNow(Object now) {
        this.now = now;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
