package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    
    public String getBookById(int id) {
        return "Book ID: " + id + " - Title: Spring Framework";
    }
    
    public void saveBook(String bookName) {
        System.out.println("📚 Book saved: " + bookName);
    }
}
