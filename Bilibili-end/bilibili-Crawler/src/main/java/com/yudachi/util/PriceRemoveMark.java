package com.yudachi.util;

public class PriceRemoveMark {
    public static String PriceRemoveMark(String price) {
        if(price.indexOf("-") > -1) {
            return price.substring(0, price.indexOf("-"));
        }else {
            if(price.indexOf("£¤") > -1) {
                return price.substring(1);
            }
            return price;
        }
    }
}
