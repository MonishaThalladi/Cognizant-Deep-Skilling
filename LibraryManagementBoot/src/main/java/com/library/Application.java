package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("📚 Library Management Spring Boot Application Started!");
        System.out.println("🌐 API available at: http://localhost:8080/api/books");
        System.out.println("📊 H2 Console: http://localhost:8080/h2-console");
    }
}
