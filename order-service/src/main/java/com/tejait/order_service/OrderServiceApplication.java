package com.tejait.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	public WebClient webClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder.baseUrl("http://localhost:8085") // Optional: Set your base URL here
		.build();
	}

}
