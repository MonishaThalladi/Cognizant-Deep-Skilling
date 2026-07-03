package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("📚 Library Management Application Started\n");
        
        // Load Spring Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // Get BookService bean
        BookService bookService = context.getBean(BookService.class);
        
        // Test the service
        System.out.println("--- Testing BookService ---");
        String book = bookService.getBook(101);
        System.out.println("Result: " + book);
        
        System.out.println();
        bookService.addBook("Effective Java");
        
        System.out.println("\n✅ Application ran successfully!");
        
        // Close context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
