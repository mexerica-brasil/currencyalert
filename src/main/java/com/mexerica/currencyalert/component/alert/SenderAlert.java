package com.mexerica.currencyalert.component.alert;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderAlert {

    private final Map<String, StrategyAlert> strategies;

    private StrategyAlert strategyAlert;

    @Autowired 
    public SenderAlert(Map<String, StrategyAlert> strategies) {
        this.strategies = strategies;
        strategyAlert = this.strategies.get("call");
        
        /*
        LocalTime now = LocalTime.now();
        if (now.getHour() >= 17 && now.getHour() <= 9) {
            strategyAlert = this.strategies.get("call");
        } else {
            strategyAlert = this.strategies.get("zap");
        }  */
    }  

    public void sendAlert(String texto) {
        strategyAlert.sendAlert(texto);
    }
}
