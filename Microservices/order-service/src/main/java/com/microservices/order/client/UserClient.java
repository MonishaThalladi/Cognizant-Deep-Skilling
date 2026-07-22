package com.microservices.order.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class UserClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Map getUser(Long userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/users/" + userId)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
