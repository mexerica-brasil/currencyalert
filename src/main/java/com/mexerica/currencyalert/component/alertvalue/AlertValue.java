package com.mexerica.currencyalert.component.alertvalue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mexerica.currencyalert.model.FlashValue;

@Component
public class AlertValue {

    private final Map<String, FlashValue> alertValue = new HashMap<>();

    public AlertValue() {
        this.alertValue.put("xdce-crowd-sale", new FlashValue(new BigDecimal("0.008"), new BigDecimal("5.50"), null));
        this.alertValue.put("stellar", new FlashValue(new BigDecimal("0.115"), new BigDecimal("5.83"), null));
        this.alertValue.put("ripple", new FlashValue(new BigDecimal("0.887"), new BigDecimal("5.83"), null));
        this.alertValue.put("bitcoin", new FlashValue(new BigDecimal("33973.00"), new BigDecimal("186667.00"), null));
        this.alertValue.put("ethereum", new FlashValue(new BigDecimal("1000.00"), new BigDecimal("10000.00"), null));
        this.alertValue.put("shiba-inu", new FlashValue(new BigDecimal("0.0000046"), new BigDecimal("0.007"), null));
        this.alertValue.put("toshi", new FlashValue(new BigDecimal("0.000001"), new BigDecimal("0.01"), null));
        this.alertValue.put("terra-luna", new FlashValue(new BigDecimal("0.000024"), new BigDecimal("0.007"), null));
        this.alertValue.put("pepe", new FlashValue(new BigDecimal("0.0000007"), new BigDecimal("0.007"), null));
        this.alertValue.put("crepe-2", new FlashValue(new BigDecimal("0.000007"), new BigDecimal("0.007"), null));
        this.alertValue.put("wiki-cat", new FlashValue(new BigDecimal("0.00000007"), new BigDecimal("0.00006"), null));
        this.alertValue.put("turbo", new FlashValue(new BigDecimal("0.0001"), new BigDecimal("0.01"), null));
    }

    public Map<String, FlashValue> getAlertValue() {
        return this.alertValue;
    }

    public String getCoinsID() {
        return String.join(",", getAlertValue().keySet());
    }

    public BigDecimal getCrashValue(String idCoin) {
        return getAlertValue().get(idCoin).getFrashCrash();
    }

    public BigDecimal getRallyValue(String idCoin) {
        return getAlertValue().get(idCoin).getFrashRally();
    }
}