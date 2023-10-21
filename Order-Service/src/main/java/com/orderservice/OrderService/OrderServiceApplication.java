package com.orderservice.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	@Bean
	public RestTemplate getInstanceofRestTemplate(){
		return  new RestTemplate();
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWeb(){

		return WebClient.builder();
	}


}
