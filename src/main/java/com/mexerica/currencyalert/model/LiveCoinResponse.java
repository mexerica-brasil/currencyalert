package com.mexerica.currencyalert.model;

import java.math.BigDecimal;

public class LiveCoinResponse {

    private BigDecimal rate;
    private BigDecimal volume;
    private BigDecimal cap;
    private BigDecimal liquidity;
    Delta DeltaObject;


    public BigDecimal getRate() {
        return rate;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getCap() {
        return cap;
    }

    public BigDecimal getLiquidity() {
        return liquidity;
    }

    public Delta getDelta() {
        return DeltaObject;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setCap(BigDecimal cap) {
        this.cap = cap;
    }

    public void setLiquidity(BigDecimal liquidity) {
        this.liquidity = liquidity;
    }

    public void setDelta(Delta deltaObject) {
        this.DeltaObject = deltaObject;
    }

    public class Delta {
        private BigDecimal hour;
        private BigDecimal day;
        private BigDecimal week;
        private BigDecimal month;
        private BigDecimal quarter;
        private BigDecimal year;

        // Getter Methods

        public BigDecimal getHour() {
            return hour;
        }

        public BigDecimal getDay() {
            return day;
        }

        public BigDecimal getWeek() {
            return week;
        }

        public BigDecimal getMonth() {
            return month;
        }

        public BigDecimal getQuarter() {
            return quarter;
        }

        public BigDecimal getYear() {
            return year;
        }

        // Setter Methods

        public void setHour(BigDecimal hour) {
            this.hour = hour;
        }

        public void setDay(BigDecimal day) {
            this.day = day;
        }

        public void setWeek(BigDecimal week) {
            this.week = week;
        }

        public void setMonth(BigDecimal month) {
            this.month = month;
        }

        public void setQuarter(BigDecimal quarter) {
            this.quarter = quarter;
        }

        public void setYear(BigDecimal year) {
            this.year = year;
        }
    }
}