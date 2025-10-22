package com.mexerica.currencyalert.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexerica.currencyalert.model.LiveCoinResponse;
import com.mexerica.currencyalert.service.LiveCoinWatchService;

@RestController
@RequestMapping("/api")
public class LiveCoinController {

    @Autowired
    private LiveCoinWatchService liveCoinService;

    @GetMapping(value = "/coin-prices", produces = {"application/json"})
    public ResponseEntity<LiveCoinResponse> getCoinPrices(
            @RequestParam String id,
            @RequestParam(defaultValue = "usd") String vsCurrency) {
        
        try {

            LiveCoinResponse coinPrices = liveCoinService.getCoinPrices(id, vsCurrency);

            return ResponseEntity.ok(coinPrices);
        } catch (Exception e) {
            //ResponseEntity.status(500).body("Erro: " + e.getMessage());

            return null;
        }
    }
}