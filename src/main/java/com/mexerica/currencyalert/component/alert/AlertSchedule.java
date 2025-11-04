package com.mexerica.currencyalert.component.alert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mexerica.currencyalert.component.alertvalue.AlertValue;
import com.mexerica.currencyalert.model.CoinPriceResponse;
import com.mexerica.currencyalert.model.LiveCoinResponse;
import com.mexerica.currencyalert.service.CoinGeckoService;
import com.mexerica.currencyalert.service.LiveCoinWatchService;

@Component
public class AlertSchedule {
    
    @Autowired
    SenderAlert senderAlert;

    @Autowired
    CoinGeckoService coinGeckoService;

    @Autowired
    LiveCoinWatchService liveCoinService;

    @Autowired
    AlertValue alertValue;

    @Scheduled(cron = "0 */5 19-23 * * *")
    public void chamarGenckoNoite() {
        this.executarTarefaCoinGecko();
    }

    @Scheduled(cron = "*/30 * 0-8 * * *")
    public void chamarGenckoMadrugada() {
        this.executarTarefaCoinGecko();
    }

    //@Scheduled(fixedRate = 8000) 
    public void executarTarefaCoinGecko() {
        CoinPriceResponse coinPrices = coinGeckoService.getCoinPrices(alertValue.getCoinsIDGencko(), "usd");

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

    @Scheduled(cron = "0 */10 9-18 * * *")
    public void chamarLiveCoinHorarioComercial() {
        this.executarTarefaLiveCoin();
    }

    @Scheduled(cron = "0 */2 19-23 * * *")
    public void chamarLiveCoinHorarioNoite() {
        this.executarTarefaLiveCoin();
    }

    @Scheduled(cron = "0 */2 0-8 * * *")
    public void chamarLiveCoinHorarioMadrugada() {
        this.executarTarefaLiveCoin();
    }

    public void executarTarefaLiveCoin() {
        Map<String, LiveCoinResponse> prices = getCoinPrices();

        if (prices != null && !prices.isEmpty()) {
            alertValue.getAlertValue().forEach((coinId, flashValue) -> {
                if (prices.containsKey(coinId)) {
                    BigDecimal currentPrice = prices.get(coinId).getRate();
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

    private Map<String, LiveCoinResponse> getCoinPrices() {
        Map<String, LiveCoinResponse> prices = new HashMap<>();

        alertValue.getAlertValue().forEach((coinId, flashValue) -> {
            LiveCoinResponse coin = liveCoinService.getCoinPrices(coinId, "USD");

            prices.put(coinId, coin);
        });

        return prices;
    }
}