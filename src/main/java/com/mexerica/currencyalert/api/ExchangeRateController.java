package com.mexerica.currencyalert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mexerica.currencyalert.service.ExchangeRateService;
import com.mexerica.currencyalert.model.RealtimeCurrencyExchangeRate;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/exchange-rate")
    public ResponseEntity<?> getExchangeRate() {
        try {

            RealtimeCurrencyExchangeRate exchangeRate = exchangeRateService.getExchangeRate();

            return ResponseEntity.ok(exchangeRate);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
}
