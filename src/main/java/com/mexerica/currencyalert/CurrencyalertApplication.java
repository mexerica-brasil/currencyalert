package com.mexerica.currencyalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencyalertApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyalertApplication.class, args);

		System.out.println("Application started successfully.");
	}

}
