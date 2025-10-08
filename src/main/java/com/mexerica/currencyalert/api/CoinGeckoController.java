package com.mexerica.currencyalert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexerica.currencyalert.model.CoinPriceResponse;
import com.mexerica.currencyalert.service.CoinGeckoService;

@RestController
@RequestMapping("/api")
public class CoinGeckoController {

    @Autowired
    private CoinGeckoService coinGeckoService;

    @GetMapping(value = "/coin-prices", produces = {"application/json"})
    public ResponseEntity<CoinPriceResponse> getCoinPrices(
            @RequestParam String ids,
            @RequestParam(defaultValue = "usd") String vsCurrencies) {
        
        try {
            CoinPriceResponse coinPrices = coinGeckoService.getCoinPrices(ids, vsCurrencies);

            return ResponseEntity.ok(coinPrices);
        } catch (Exception e) {
            //ResponseEntity.status(500).body("Erro: " + e.getMessage());

            return null;
        }
    }
}