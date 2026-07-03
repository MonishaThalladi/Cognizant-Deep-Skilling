package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;
    
    // Setter Injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("🔗 BookRepository injected into BookService");
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
