package com.mexerica.currencyalert.component.alert;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mexerica.currencyalert.component.alertvalue.AlertValue;
import com.mexerica.currencyalert.model.CoinPriceResponse;
import com.mexerica.currencyalert.service.CoinGeckoService;

@Component
public class AlertSchedule {
    
    @Autowired
    SenderAlert senderAlert;

    @Autowired
    CoinGeckoService coinGeckoService;

    @Autowired
    AlertValue alertValue;

    @Scheduled(fixedRate = 4000) 
    public void executarTarefa() {
        
        CoinPriceResponse coinPrices = coinGeckoService.getCoinPrices(alertValue.getCoinsID(), "usd");

        if (coinPrices != null) {

            alertValue.getAlertValue().forEach((coinId, flashValue) -> {
                if (coinPrices.getPrices().containsKey(coinId)) {
                    BigDecimal currentPrice = coinPrices.getPrices().get(coinId).get("usd");
                    if (currentPrice != null && currentPrice.compareTo(flashValue.getFrashCrash()) <= 0 && flashValue.canAlert()) {
                        String message = String.format("Crash Alert: %s price dropped to %.6f USD", coinId, currentPrice);
                        senderAlert.sendAlert(message);
                    } else if (currentPrice != null && currentPrice.compareTo(flashValue.getFrashRally()) >= 0 && flashValue.canAlert()) {
                        String message = String.format("Rally Alert: %s price rose to %.6f USD", coinId, currentPrice);
                        senderAlert.sendAlert(message);
                    }
                }
            });
        }
    }
}