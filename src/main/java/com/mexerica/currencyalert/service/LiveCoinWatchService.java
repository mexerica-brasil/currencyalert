package com.mexerica.currencyalert.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mexerica.currencyalert.model.CoinPriceResponse;
import com.mexerica.currencyalert.model.LiveCoinResponse;

@Service
public class LiveCoinWatchService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${livecoin.api.url}")
    private String liveCoinApiUrl;

    @Value("${livecoin.api.key}")
    private String apiKey;

    public LiveCoinResponse getCoinPrices(String coinId, String vsCurrency) {
        String url = UriComponentsBuilder.fromUriString(liveCoinApiUrl).toUriString();
        StringBuilder body = new StringBuilder();
        body.append("{");
        body.append("\"currency\":");
        body.append("\"");
        body.append(vsCurrency.toUpperCase());
        body.append("\",");
        body.append("\"code\":");
        body.append("\"");
        body.append(coinId.toUpperCase());
        body.append("\",");
        body.append("\"meta\": false}");
	
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-api-key", apiKey); 
            headers.set("content-type", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(body.toString(), headers);

            LiveCoinResponse price =  restTemplate.exchange(url, HttpMethod.POST, entity, LiveCoinResponse.class).getBody();

            return price;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a API da LiveCoin: " + e.getMessage());
        }
    }
}