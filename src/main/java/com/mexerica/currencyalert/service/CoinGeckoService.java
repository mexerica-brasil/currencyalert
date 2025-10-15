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

@Service
public class CoinGeckoService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${coingecko.api.url}")
    private String coingeckoApiUrl;

    @Value("${coingecko.api.key}")
    private String apiKey;

    public CoinPriceResponse getCoinPrices(String coinIds, String vsCurrencies) {
        String url = UriComponentsBuilder.fromUriString(coingeckoApiUrl)
                .queryParam("ids", coinIds)
                .queryParam("vs_currencies", vsCurrencies)
                .toUriString();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-cg-demo-api-key", apiKey); 
            headers.set("Content-type", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            CoinPriceResponse price =  restTemplate.exchange(url, HttpMethod.GET, entity, CoinPriceResponse.class).getBody();

            return price;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a API da CoinGecko: " + e.getMessage());
        }
    }
}