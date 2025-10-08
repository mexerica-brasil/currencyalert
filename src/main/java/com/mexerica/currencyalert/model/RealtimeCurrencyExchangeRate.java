package com.mexerica.currencyalert.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealtimeCurrencyExchangeRate {
    @JsonProperty("1. From_Currency Code")
    private String fromCurrencyCode;

    @JsonProperty("2. From_Currency Name")
    private String fromCurrencyName;

    @JsonProperty("3. To_Currency Code")
    private String toCurrencyCode;

    @JsonProperty("4. To_Currency Name")
    private String toCurrencyName;

    @JsonProperty("5. Exchange Rate")
    private String exchangeRate;

    @JsonProperty("6. Last Refreshed")
    private String lastRefreshed;

    @JsonProperty("7. Time Zone")
    private String timeZone;

    @JsonProperty("8. Bid Price")
    private String bidPrice;

    @JsonProperty("9. Ask Price")
    private String askPrice;

    // Getters e Setters
    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }
}