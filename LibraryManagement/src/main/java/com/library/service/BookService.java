package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;
    
    // Constructor Injection (Exercise 7)
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("🔗 Constructor Injection: BookRepository injected!");
    }
    
    // Setter Injection (Exercise 7)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("🔗 Setter Injection: BookRepository injected!");
    }
    
    public String getBook(int id) {
        System.out.println("📖 Fetching book with ID: " + id);
        return bookRepository.getBookById(id);
    }
    
    public void addBook(String bookName) {
        System.out.println("📝 Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
