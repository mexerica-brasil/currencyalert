package com.mexerica.currencyalert.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=SHIB&to_currency=USDT&apikey=JALX1ULABJ7ISZUO
    // Alpha Vantage: API gratuita para ações, forex, cripto e mais. Limite: 5 chamadas/minuto e 500/dia.

    
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}