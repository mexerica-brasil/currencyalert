package com.mexerica.currencyalert.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Data;

@Data
public class CoinPriceResponse {
    private Map<String, Map<String, BigDecimal>> prices = new HashMap<>();

    @JsonAnySetter
    public void setPrice(String coinId, Map<String, BigDecimal> priceData) {
        prices.put(coinId, priceData);
    }
}