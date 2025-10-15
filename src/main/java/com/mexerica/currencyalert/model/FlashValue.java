package com.mexerica.currencyalert.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlashValue {
    private BigDecimal frashCrash;
    private BigDecimal frashRally;
    private LocalDate lastUpdate;

    public boolean canAlert() {
        boolean ret = true;
        LocalDate now = LocalDate.now();

        if (this.lastUpdate != null) {
            if (this.lastUpdate.isEqual(now)) {
                ret = false;
            }
        }

        this.lastUpdate = now;
        return ret;
    }
}