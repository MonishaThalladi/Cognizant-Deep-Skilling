package com.cognizant.gateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class LogFilter {

    @Bean
    @Order(-1)
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();
            String method = exchange.getRequest().getMethod().name();
            System.out.println("🔍 [GATEWAY] " + method + " request to: " + path);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("✅ [GATEWAY] Response sent for: " + path);
            }));
        };
    }
}