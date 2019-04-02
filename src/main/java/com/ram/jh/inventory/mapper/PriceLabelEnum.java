package com.ram.jh.inventory.mapper;

import com.ram.jh.inventory.model.Price;

public enum PriceLabelEnum {

    ShowWasNow {
        @Override
        public String getPrice(Price price) {
            return null;
        }

        @Override
        public String getPrice(String was, String now, String currency) {
            String wasStr = null;
            wasStr = String.format("Was %s%s", currency, formatPrice(convertToDouble(was)));

            String nowStr = null;
            nowStr = String.format("now %s%s", currency, formatPrice(convertToDouble(now)));

            return String.format("%s, %s", wasStr, nowStr);
        }
    },
    ShowWasThenNow {
        @Override
        public String getPrice(Price price) {
            String currency = price.getCurrency();
            double then = 0D;

            Double was = Double.parseDouble(price.getWas());
            String wasStr = String.format("Was %s%s", currency, formatPrice(was));

            if (!price.getThen1().isEmpty()) {
                then = convertToDouble(price.getThen1());
            } else if (!price.getThen2().isEmpty()) {
                then = convertToDouble(price.getThen2());
            } else {
                then = 0D;
            }

            String thenStr = String.format("then %s%s", currency, formatPrice(then));

            Double now = Double.parseDouble(price.getNow());
            String nowStr = String.format("now %s%s", currency, formatPrice(now));

            if (price.getThen1().isEmpty() && price.getThen2().isEmpty()) {
                return String.format("%s, %s", wasStr, nowStr);
            } else {
                return String.format("%s, %s, %s", wasStr, thenStr, nowStr);
            }
        }

        @Override
        public String getPrice(String was, String now, String currency) {
            return null;
        }
    },
    ShowPercDscount {
        @Override
        public String getPrice(Price price) {
            Double discountedPrice = price.calcPriceReduction();
            String formatedStr = "";
            if (discountedPrice > 0){
                formatedStr = formatPrice(discountedPrice) + "% off - now " + String.format("%s%s",price.getCurrency(),price.getNow());
            }
                // a price increase (i.e PriceNow > PriceWas is an unsupported operation so returning empty discount.
            return formatedStr;
        }

        @Override
        public String getPrice(String was, String now, String currency) {
            return null;
        }
    };

    public abstract String getPrice(Price price);

    public abstract String getPrice(String was, String now, String currency);

    private static double convertToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return 0D;
        }
    }

    private static String formatPrice(final Double doubleValue){
        String result;
        if (doubleValue == null){
            result = "0.00";
        }else if (doubleValue % 1 == 0) { //whole number
            if (doubleValue < 10){
                result = String.format("%.2f", doubleValue);
            }else{
                result = String.valueOf(doubleValue.intValue());
            }
        }else{ //floating point number
            result = String.format( "%.2f", doubleValue);
        }
        return result;
    }
}
