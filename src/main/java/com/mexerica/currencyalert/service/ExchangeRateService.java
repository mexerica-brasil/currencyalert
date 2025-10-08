package com.mexerica.currencyalert.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mexerica.currencyalert.model.RealtimeCurrencyExchangeRate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_URL = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=SHIB&to_currency=USDT&apikey=JALX1ULABJ7ISZUO";

    public RealtimeCurrencyExchangeRate getExchangeRate() throws Exception {
        try {
            // Faz a requisição à API
            String response = restTemplate.getForObject(API_URL, String.class);
            JsonNode jsonNode = objectMapper.readTree(response);

            // Verifica se os dados esperados estão presentes
            JsonNode exchangeRateNode = jsonNode.get("Realtime Currency Exchange Rate");
            
            if (exchangeRateNode != null) {
                return objectMapper.treeToValue(exchangeRateNode, RealtimeCurrencyExchangeRate.class);
            } else {
                //throw new Exception("Dados de taxa de câmbio não encontrados");
                throw new Exception(response);
            }
        } catch (Exception e) {
            throw new Exception("Erro ao consultar a API da Alpha Vantage: " + e.getMessage());
        }
    }
}