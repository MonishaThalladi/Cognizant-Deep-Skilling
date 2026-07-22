package com.microservices.inventory.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class ProductClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Map getProduct(Long productId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/api/products/" + productId)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Integer getStock(Long productId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/api/products/" + productId + "/stock")
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
    }
}
